package com.burmaguru.all_in_one.librarymanagementsystem;

public class Member extends User{
    private final Library library;

    public Member(String name, String id, Library library) {
        super(name, id);
        this.library = library;
    }

    @Override
    public void performAction() {
        System.out.println("Performing member actions.");
    }

    public void borrowBook(String isbn) {
        Book book = library.getBook(isbn);
        if (book != null) {
            if (book.isAvailable()) {
                book.borrowBook();
                System.out.println("Book borrowed: " + book.getTitle());
            } else {
                System.out.println("Book is already borrowed by another user.");
            }
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void returnBook(String isbn) {
        Book book = library.getBook(isbn);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("Book was not borrowed.");
        }
    }
}
