package com.project.library.bookservice.service;

import com.project.library.bookservice.dto.AuthorDto;
import com.project.library.bookservice.entity.Book;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BookService {

    Book createBook(String title, Integer pages, String year, Set<AuthorDto> authorId,Boolean isAvailable);


    Book updateBook(Long id, String title, Integer pages, String year, Set<AuthorDto> authorId,Boolean isAvailable);

    List<Book> lookUpAllBooks();

    Optional<Book> lookUpBook(Long id);

    List<Book> getBooksByAuthor(Long id);


}
