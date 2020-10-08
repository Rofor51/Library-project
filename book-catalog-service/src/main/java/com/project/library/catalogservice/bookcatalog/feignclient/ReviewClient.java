package com.project.library.catalogservice.bookcatalog.feignclient;

import com.project.library.catalogservice.bookcatalog.models.Reviews;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Qualifier("serv2")
@FeignClient("REVIEWER-SERVICE")
public interface ReviewClient {
    @GetMapping("/api/v1/reviews/{id}?page={page}")
    List<Reviews> getReviews(@PathVariable("id") Long id,@PathVariable("page") Integer page);

    @GetMapping("/api/v1/reviews/average/{id}")
    Double getAverageScore(@PathVariable("id") Long bookId);

    default List<Reviews> fallBackMethod1(Throwable throwable) {
        return null;
    }


}
