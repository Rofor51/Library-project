package com.project.library.catalogservice.bookcatalog.feignclient;

import com.project.library.catalogservice.bookcatalog.models.Reviews;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Qualifier("serv2")
@FeignClient("REVIEWER-SERVICE")
public interface ReviewClient {
    @GetMapping("/api/v1/reviews/{id}?page={page}")
    @CircuitBreaker(name = "mainService", fallbackMethod = "fallBackMethod1")
    List<Reviews> getReviews(@PathVariable("id") Long id,@PathVariable("page") Integer page);

    @GetMapping("/api/v1/reviews/average/{id}")
    @CircuitBreaker(name = "mainService", fallbackMethod = "fallBackMethod2")
    Double getAverageScore(@PathVariable("id") Long bookId);

    default List<Reviews> fallBackMethod1(@PathVariable("id") Long id,@PathVariable("page") Integer page,Throwable throwable) {
        return new ArrayList<>();
    }
    default Double fallBackMethod2(Throwable throwable) {
        return null;
    }


}
