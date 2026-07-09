package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService() {
        System.out.println("BookService bean created.");
    }

    // Setter used by Spring for dependency injection (see applicationContext.xml)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String getBookDetails(int id) {
        return bookRepository.findBookById(id);
    }
}
