package com.library.repository;

public class BookRepository {

    public BookRepository() {
        System.out.println("BookRepository bean created.");
    }

    public String findBookById(int id) {
        // Simulated data access
        return "Book #" + id + ": The Pragmatic Programmer";
    }
}
