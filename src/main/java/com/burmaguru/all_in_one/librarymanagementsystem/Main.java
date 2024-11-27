package com.burmaguru.all_in_one.librarymanagementsystem;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Library library;

        File file = new File("library_data.dat");
        if (file.exists()) {
            library = Library.loadLibraryFromFile("library_data.dat");
            System.out.println("Library data loaded from file.");
        } else {
            library = new Library();
            System.out.println("No existing data file found. Creating a new library with default data.");

            Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "12345", "Fiction");
            Book book2 = new Book("Moby Dick", "Herman Melville", "67890", "Classic");

            library.addBook(book1);
            library.addBook(book2);

            Librarian librarian = new Librarian("Alice", "lib001", library);
            Member member = new Member("Bob", "mem001", library);

            library.registerUser(librarian);
            library.registerUser(member);
        }

        System.out.println("Login to Library System:");
        System.out.println("Enter your ID:");
        String id = scanner.nextLine();
        User currentUser = library.login(id);

        if (currentUser == null) {
            return;
        }

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book (Member only)");
            System.out.println("3. Return Book (Member only)");
            System.out.println("4. Add Book (Librarian only)");
            System.out.println("5. Remove Book (Librarian only)");
            System.out.println("6. Search Book");
            System.out.println("7. Exit");

            System.out.println("Enter your choice:");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                case 3:
                    if (currentUser instanceof Member) {
                        if (choice == 2) {
                            System.out.println("Enter ISBN of the book to borrow:");
                            String borrowIsbn = scanner.nextLine();
                            ((Member) currentUser).borrowBook(borrowIsbn);
                        } else {
                            System.out.println("Enter ISBN of the book to return:");
                            String returnIsbn = scanner.nextLine();
                            ((Member) currentUser).returnBook(returnIsbn);
                        }
                    } else {
                        System.out.println("Access denied. Only members can perform this action.");
                    }
                    break;
                case 4:
                case 5:
                    if (currentUser instanceof Librarian) {
                        if (choice == 4) {
                            System.out.println("Enter ISBN of the new book to add:");
                            String newIsbn = scanner.nextLine();
                            System.out.println("Enter title:");
                            String title = scanner.nextLine();
                            System.out.println("Enter author:");
                            String author = scanner.nextLine();
                            System.out.println("Enter category:");
                            String category = scanner.nextLine();
                            Book newBook = new Book(title, author, newIsbn, category);
                            ((Librarian) currentUser).addBook(newBook);
                        } else {
                            System.out.println("Enter ISBN of the book to remove:");
                            String removeIsbn = scanner.nextLine();
                            ((Librarian) currentUser).removeBook(removeIsbn);
                        }
                    } else {
                        System.out.println("Access denied. Only librarians can perform this action.");
                    }
                    break;
                case 6:
                    System.out.println("Enter title, author, ISBN or category to search:");
                    String query = scanner.nextLine();
                    library.searchBooks(query);
                    break;
                case 7:
                    System.out.println("Exiting and saving data...");
                    library.saveLibraryToFile("library_data.dat");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
