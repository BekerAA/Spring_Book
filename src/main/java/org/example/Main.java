package org.example;

import org.example.config.AppConfig;
import org.example.entity.Book;
import org.example.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.time.Year;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        BookService bookService = annotationConfigApplicationContext.getBean(BookService.class);

        Book book1 = Book.builder().title("Книга1").author("автор1").year(Year.of(1999)).build();
        Book book2 = Book.builder().title("Книга2").author("автор2").year(Year.of(2003)).build();
        Book book3 = Book.builder().title("Книга3").author("автор3").year(Year.of(1812)).build();

        bookService.saveBook(book1);
        bookService.saveBook(book2);
        bookService.saveBook(book3);

        List<Book> bookList = bookService.findAllBook();
        System.out.println(bookList);
        bookService.deleteById((long) 2);
        List<Book> bookList1 = bookService.findAllBook();
        System.out.println(bookList1);

        annotationConfigApplicationContext.close();

    }
}
