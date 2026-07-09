package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load the Spring application context from the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean managed by Spring
        BookService bookService = (BookService) context.getBean("bookService");

        // Use the service (which internally uses the injected BookRepository)
        String details = bookService.getBookDetails(1);
        System.out.println("Retrieved: " + details);
    }
}
