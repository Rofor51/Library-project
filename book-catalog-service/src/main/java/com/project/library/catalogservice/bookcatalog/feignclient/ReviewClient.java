package com.project.library.catalogservice.bookcatalog.feignclient;

import com.project.library.catalogservice.bookcatalog.models.ReviewsDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@Qualifier("serv2")
@FeignClient("REVIEWER-SERVICE")
public interface ReviewClient {
    @GetMapping("/api/v1/reviews/{id}")
    @CircuitBreaker(name = "mainService", fallbackMethod = "fallBackMethod1")
    Set<ReviewsDto> getReviews(@PathVariable("id") Long id);

    @PostMapping("api/v1/reviews")
    @CircuitBreaker(name = "mainService", fallbackMethod = "fallBackMethod2")
    ReviewsDto createReview(@RequestBody @Validated ReviewsDto reviewsDto);


    default Set<ReviewsDto> fallBackMethod1(Throwable throwable) {
        return null;
    }

    default ReviewsDto fallBackMethod2(Throwable throwable) {
        return null;
    }

}
