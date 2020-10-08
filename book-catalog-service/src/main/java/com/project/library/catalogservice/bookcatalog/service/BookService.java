package com.project.library.catalogservice.bookcatalog.service;

import com.project.library.catalogservice.bookcatalog.models.BookCatalog;
import com.project.library.catalogservice.bookcatalog.models.BookDetail;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<BookDetail> getBook(Long id);

    List<BookCatalog> getAllBooks();


}
