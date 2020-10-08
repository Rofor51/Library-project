package com.project.library.catalogservice.bookcatalog.web;

import com.project.library.catalogservice.bookcatalog.assembler.BookCatalogAssembler;
import com.project.library.catalogservice.bookcatalog.models.BookCatalog;
import com.project.library.catalogservice.bookcatalog.models.BookDetail;
import com.project.library.catalogservice.bookcatalog.service.BookService;
import com.project.library.catalogservice.bookcatalog.service.ReviewService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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
    public BookDetail getBookWithReviews(@PathVariable("id") Long id,@RequestParam(defaultValue = "0") Integer page) {
        Optional<BookDetail> bookDto = bookService.getBook(id);
        bookDto.get().setReviews(reviewService.getReviews(bookDto.get().getBookId(),page));
        return bookDto.get();

    }

    @GetMapping("/all")
    public List<BookCatalog> getAllBooksWithAverageScore() {
     List<BookCatalog> bookCatalog = bookService.getAllBooks().stream().map(x -> assembler.process(x)).collect(Collectors.toList());
     bookCatalog.forEach(k -> k.setAverageScore(reviewService.getAverageScore(k.getBookId())));
     return bookCatalog;

    }




    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(FeignException.class)
    private String return400(FeignException ex) {
        return ex.getMessage();

    }
}
