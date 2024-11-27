package com.burmaguru.all_in_one.librarymanagementsystem;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Library implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Map<String, Book> books;
    private Map<String, User> users;

    private static final Logger LOGGER = Logger.getLogger(Library.class.getName());

    public Library() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
    }

    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            System.out.println("Error: A book with ISBN " + book.getIsbn() + " already exists in the library.");
        } else {
            books.put(book.getIsbn(), book);
            System.out.println("Book with ISBN " + book.getIsbn() + " has been added to the library.");
        }
    }

    public void removeBook(String isbn) {
        if (books.containsKey(isbn)) {
            books.remove(isbn);
            System.out.println("Book with ISBN " + isbn + " has been removed.");
        } else {
            System.out.println("Error: No book found with ISBN " + isbn + ".");
        }
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public void registerUser(User user) {
        users.put(user.id, user);
    }

    public void removeUser(String id) {
        users.remove(id);
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public void displayBooks() {
        books.forEach((isbn, book) -> {
            System.out.println(book);
        });
    }

    public User login(String id) {
        User user = users.get(id);
        if (user != null) {
            System.out.println("Welcome, " + user.name + "!");
        } else {
            System.out.println("User not found. Please register first.");
        }
        return user;
    }

    public void saveLibraryToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Library data saved to " + filename);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to save library data to file: " + filename, e);
        }
    }

    public static Library loadLibraryFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Library) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.WARNING, "Failed to load library data from file: " + filename, e);
            return new Library();
        }
    }

    public void searchBooks(String query) {
        books.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(query) ||
                        book.getAuthor().equalsIgnoreCase(query) ||
                        book.getIsbn().equals(query) ||
                        book.getCategory().equalsIgnoreCase(query))
                .forEach(System.out::println);
    }
}
