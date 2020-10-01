package com.project.library.catalogservice.bookcatalog.service;

import com.project.library.catalogservice.bookcatalog.models.BookDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<BookDto> getBook(Long id);

    List<BookDto> getAllBooks();
}
