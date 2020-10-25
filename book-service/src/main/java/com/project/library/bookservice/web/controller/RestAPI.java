package com.project.library.bookservice.web.controller;

import com.project.library.bookservice.dto.BookDto;
import com.project.library.bookservice.entity.Book;
import com.project.library.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
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
        return convertToDto(bookService.lookUpBook(id).get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('Admin')")
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto.getTitle(),bookDto.getPages(),bookDto.getYear(),bookDto.getAuthors(),bookDto.getImageLink(),bookDto.getInStore());
    }



    @PostMapping("/validate")
    public ResponseEntity<String> validateBooks(@RequestBody Long [] id) {
        Arrays.stream(id).forEach(t -> bookService.lookUpBook(t));
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
