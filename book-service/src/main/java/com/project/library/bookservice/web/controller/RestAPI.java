package com.project.library.bookservice.web.controller;

import com.project.library.bookservice.dto.BookDto;
import com.project.library.bookservice.entity.Book;
import com.project.library.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/books")
public class RestAPI {
    private final BookService bookService;
    private final ModelMapper modelMapper;


    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.lookUpAllBooks().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable("id") Long id) {
        System.out.println(convertToDto(bookService.lookUpBook(id).get()).getAvailable());
        return convertToDto(bookService.lookUpBook(id).get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto.getTitle(),bookDto.getPages(),bookDto.getYear(),bookDto.getAuthors(),bookDto.getAvailable());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@RequestBody BookDto bookDto) {
        bookService.updateBook(bookDto.getBookId(),bookDto.getTitle(),bookDto.getPages(),bookDto.getYear(),bookDto.getAuthors(),bookDto.getAvailable());
    }


    @GetMapping("/validate/{id}")
    public ResponseEntity<String> validateBook(@PathVariable("id") Long id) {
        bookService.lookUpBook(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Book found");
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    private String return400(NoSuchElementException ex) {
        return ex.getMessage();

    }

    private BookDto convertToDto(Book book) {
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        return bookDto;
    }


}
