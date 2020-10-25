package com.project.library.bookservice.service.imp;

import com.project.library.bookservice.aspect.Logger;
import com.project.library.bookservice.dto.AuthorDto;
import com.project.library.bookservice.entity.Author;
import com.project.library.bookservice.entity.Book;
import com.project.library.bookservice.repository.AuthorRepository;
import com.project.library.bookservice.repository.BookRepository;
import com.project.library.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    @Override
    @Logger
    public Book createBook(String title, Integer pages, Date year, Set<AuthorDto> authors, String imageLink,Boolean inStore) {
        return bookRepository.save(new Book(title, pages, year,imageLink,inStore, getAndValidateAuthors(authors)));
    }


    @Logger
    @Override
    public List<Book> lookUpAllBooks() {
        return bookRepository.findAll();
    }

    @Logger
    @Override
    public Optional<Book> lookUpBook(Long id) {
        return Optional.of(validate(id));
    }

    private Book validate(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Book was not found in database."));
    }

    private Author verifyAuthor(String name,String lastName) {
        if(authorRepository.findByNameIgnoreCaseAndLastNameIgnoreCase(name,lastName).isPresent()) {
            return authorRepository.findByNameIgnoreCaseAndLastNameIgnoreCase(name,lastName).get();
        }
        return authorRepository.save(new Author(name,lastName));
    }

    private Set<Author> getAndValidateAuthors(Set<AuthorDto> authorIds) {
        return authorIds.stream().map(k -> verifyAuthor(k.getName(),k.getLastName())).collect(Collectors.toSet());
    }
}
