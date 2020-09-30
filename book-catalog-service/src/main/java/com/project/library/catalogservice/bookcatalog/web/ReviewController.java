package com.project.library.catalogservice.bookcatalog.web;

import com.project.library.catalogservice.bookcatalog.models.BookDto;
import com.project.library.catalogservice.bookcatalog.models.ReviewsDto;
import com.project.library.catalogservice.bookcatalog.service.BookService;
import com.project.library.catalogservice.bookcatalog.service.ReviewService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final BookService bookService;
    private final ReviewService reviewService;

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void createReview(@RequestBody @Valid ReviewsDto reviewDto) {
            Optional<BookDto> bookDto = bookService.getBook(reviewDto.getBookId());
            reviewService.createReview(new ReviewsDto(bookDto.get().getBookId(),reviewDto.getUsername(),reviewDto.getComment(),reviewDto.getPoints(),reviewDto.getDate()));
        }






    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(FeignException.class)
    private String  return400(FeignException ex) {
        return ex.getMessage();

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private String  return400(MethodArgumentNotValidException ex) {
        return ex.getMessage();

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    private String  return400(Exception ex) {
        return ex.getMessage();

    }
}
