package com.project.library.bookservice;

import com.project.library.bookservice.repository.AuthorRepository;
import com.project.library.bookservice.repository.BookRepository;
import com.project.library.bookservice.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LibServiceApplicationTests {
    @Autowired
    BookService bookService;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    @Test
    void contextLoads() {


    }

}
