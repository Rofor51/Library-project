package com.project.library.catalogservice.bookcatalog.service.imp;

import com.project.library.catalogservice.bookcatalog.feignclient.BookClient;
import com.project.library.catalogservice.bookcatalog.models.BookDto;
import com.project.library.catalogservice.bookcatalog.service.BookService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class BookServiceImp implements BookService {
    private final BookClient bookClient;

    @Override
    public Optional<BookDto> getBook(Long id) {
        return bookClient.getBook(id);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookClient.getAllBooks();
    }

    @Override
    public void createBook(BookDto bookDto) {
         bookClient.createBook(bookDto);
    }

    @Override
    public void updateBook(BookDto bookDto) {
        bookClient.updateBook(bookDto);
    }
}
