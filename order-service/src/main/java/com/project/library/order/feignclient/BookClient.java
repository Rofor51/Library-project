package com.project.library.order.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.Path;
import java.util.List;

@FeignClient("BOOK-SERVICE")
public interface BookClient {
    @GetMapping("api/v1/books/validate/{id}")
    ResponseEntity<String> validateBook(@PathVariable("id") Long id);
}
