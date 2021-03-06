package com.project.library.bookservice.service;

import com.project.library.bookservice.dto.AuthorDto;
import com.project.library.bookservice.entity.Book;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BookService {

    Book createBook(String title, Integer pages, Date year, Set<AuthorDto> authors, String imageLink,Boolean inStore);


    List<Book> lookUpAllBooks();

    Optional<Book> lookUpBook(Long id);




}
