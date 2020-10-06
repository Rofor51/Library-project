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
    public Book createBook(String title, Integer pages, Date year, Set<AuthorDto> authorId,Boolean isAvailable) {


        return bookRepository.save(new Book(title, pages, year,isAvailable, getAndValidateAuthors(authorId)));
    }

    @Logger
    @Override
    public Book updateBook(Long id, String title, Integer pages, Date year, Set<AuthorDto> authorId,Boolean isAvailable) {
        Optional<Book> book = lookUpBook(id);
        if (title != null) {
            book.get().setTitle(title);
        }
        if (pages != null) {
            book.get().setPages(pages);
        }
        if (year != null) {
            book.get().setYear(year);
        }
        if (authorId != null) {

            book.get().setAuthors(getAndValidateAuthors(authorId));
        }

        if (isAvailable != null) {
            book.get().setAvailable(isAvailable);
        }

        return bookRepository.save(book.get());
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

    @Logger
    @Override
    public List<Book> getBooksByAuthor(Long id) {
        return bookRepository.findAllByAuthorsName(verifyAuthor(id).getName());
    }


    private Book validate(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Book was not found in database."));
    }



    private Author verifyAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Author was not found in database."));
    }

    private Set<Author> getAndValidateAuthors(Set<AuthorDto> authorIds) {
        return authorIds.stream().map(k -> verifyAuthor(k.getId())).collect(Collectors.toSet());
    }
}
