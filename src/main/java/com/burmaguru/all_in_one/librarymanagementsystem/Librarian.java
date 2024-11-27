package com.burmaguru.all_in_one.librarymanagementsystem;

public class Librarian extends User {
    private Library library;

    public Librarian(String name, String id, Library library) {
        super(name, id);
        this.library = library;
    }

    @Override
    public void performAction() {
        System.out.println("Performing librarian actions.");
    }

    public void addBook(Book book) {
        library.addBook(book);
    }

    public void removeBook(String isbn) {
        library.removeBook(isbn);
    }
}
