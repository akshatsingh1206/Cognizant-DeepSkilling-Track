package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Spring's IoC container reads applicationContext.xml, creates the beans,
        // and injects BookRepository into BookService automatically.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println(bookService.getBookDetails(1));
        System.out.println(bookService.getBookDetails(2));

        // Confirms Spring is managing a single shared instance (singleton scope by default)
        BookService anotherReference = (BookService) context.getBean("bookService");
        System.out.println("Same bean instance? " + (bookService == anotherReference));
    }
}
