package com.project.library.catalogservice.bookcatalog.service;

import com.project.library.catalogservice.bookcatalog.models.Reviews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ReviewService {
    List<Reviews> getReviews(Long bookId,Integer page);

    Double getAverageScore(Long bookId);

}
