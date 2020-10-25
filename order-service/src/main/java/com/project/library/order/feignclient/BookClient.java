package com.project.library.order.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("BOOK-SERVICE")
public interface BookClient {
    @PostMapping("api/v1/books/validate")
    ResponseEntity<String> validateBook(@RequestBody Long [] id);
}
