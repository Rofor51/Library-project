package com.project.library.catalogservice.bookcatalog.feignclient;


import com.project.library.catalogservice.bookcatalog.models.BookDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Qualifier("serv")
@FeignClient(value = "BOOK-SERVICE")
public interface BookClient {
    @GetMapping(value = "/api/v1/books/{id}")
    @CircuitBreaker(name = "mainService", fallbackMethod = "fallBackMethod1")
    Optional<BookDto> getBook(@PathVariable("id") Long id);

    @GetMapping(value = "api/v1/books")
    @CircuitBreaker(name = "mainService", fallbackMethod = "fallBackMethod2")
    List<BookDto> getAllBooks();


    default Optional<BookDto> fallBackMethod1(Throwable throwable) {
        return null;
    }

    default List<BookDto> fallBackMethod2(Throwable throwable) {
        return null;
    }
}
