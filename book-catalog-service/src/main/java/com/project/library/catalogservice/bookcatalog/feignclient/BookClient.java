package com.project.library.catalogservice.bookcatalog.feignclient;


import com.project.library.catalogservice.bookcatalog.models.BookCatalog;
import com.project.library.catalogservice.bookcatalog.models.BookDetail;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

@Qualifier("serv")
@FeignClient(value = "BOOK-SERVICE")
public interface BookClient {
    @GetMapping(value = "/api/v1/books/{id}")
    @CircuitBreaker(name = "mainService", fallbackMethod = "fallBackMethod1")
    Optional<BookDetail> getBook(@PathVariable("id") Long id);

    @GetMapping(value = "api/v1/books")
    @CircuitBreaker(name = "mainService", fallbackMethod = "fallBackMethod2")
    List<BookCatalog> getAllBooks();


    default Optional<BookDetail> fallBackMethod1(Throwable throwable) {
        return null;
    }

    default List<BookDetail> fallBackMethod2(Throwable throwable) {
        return null;
    }
}
