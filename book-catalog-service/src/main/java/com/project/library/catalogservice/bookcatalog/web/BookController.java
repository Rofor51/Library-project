package com.project.library.catalogservice.bookcatalog.web;

import com.project.library.catalogservice.bookcatalog.assembler.BookCatalogAssembler;
import com.project.library.catalogservice.bookcatalog.models.BookCatalog;
import com.project.library.catalogservice.bookcatalog.models.BookDto;
import com.project.library.catalogservice.bookcatalog.service.BookService;
import com.project.library.catalogservice.bookcatalog.service.ReviewService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final ReviewService reviewService;
    private final BookCatalogAssembler assembler;
    private final BookService bookService;

    @GetMapping("/{id}")
    public BookCatalog getBook(@PathVariable("id") Long bookId) {
        Optional<BookDto> bookDto = bookService.getBook(bookId);
        System.out.println(bookDto.get().getAvailable());
        final BookCatalog bookCatalog = assembler.toModel(bookDto.get());
        bookCatalog.setReviews(reviewService.getReviews(bookDto.get().getBookId()));
        return bookCatalog;

    }

    @GetMapping
    public List<BookCatalog> getAllBooks() {
        List<BookDto> bookDto = bookService.getAllBooks();
        List<BookCatalog> bookCatalog = bookDto.stream().map(k -> assembler.toModel(k)).collect(Collectors.toList());
        bookCatalog.forEach(x -> x.setReviews(reviewService.getReviews(x.getBookId())));
        return bookCatalog;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody BookDto bookDto) {
        System.out.println("YTO" + bookDto.getAvailable());
        bookService.createBook(bookDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@RequestBody BookDto bookDto) {
        System.out.println("YTO" + bookDto.getAvailable());
        bookService.updateBook(bookDto);
    }




    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(FeignException.class)
    private String return400(FeignException ex) {
        return ex.getMessage();

    }
}
