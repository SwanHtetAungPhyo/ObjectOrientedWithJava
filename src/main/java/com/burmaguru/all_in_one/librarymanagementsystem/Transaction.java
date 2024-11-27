package com.burmaguru.all_in_one.librarymanagementsystem;

import java.time.LocalDate;

public class Transaction {

    private Member member;
    private Book book;
    private boolean isBorrow;
    private LocalDate dueDate;

    public Transaction(Member member, Book book, boolean isBorrow) {
        this.member = member;
        this.book = book;
        this.isBorrow = isBorrow;
        if (isBorrow) {
            this.dueDate = LocalDate.now().plusDays(14);
        }
    }

    public void processTransaction() {
        if (isBorrow) {
            member.borrowBook(book.getIsbn());
        } else {
            member.returnBook(book.getIsbn());
        }
    }

    public void checkOverdueAndFine() {
        if (dueDate == null) {
            System.out.println("No due date set for this transaction.");
            return;
        }
        if (LocalDate.now().isAfter(dueDate)) {
            long overdueDays = LocalDate.now().toEpochDay() - dueDate.toEpochDay();
            double fine = overdueDays * 1.0;
            System.out.println("Book is overdue by " + overdueDays + " days. Fine: $" + fine);
        } else {
            System.out.println("No fine. Book is within due date.");
        }
    }
}
