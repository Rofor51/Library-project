package com.project.library.catalogservice.bookcatalog.service.imp;

import com.project.library.catalogservice.bookcatalog.feignclient.ReviewClient;
import com.project.library.catalogservice.bookcatalog.models.Reviews;
import com.project.library.catalogservice.bookcatalog.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewServiceImp implements ReviewService {
    private final ReviewClient reviewClient;

    @Override
    public List<Reviews> getReviews(Long bookid,Integer page) {
        return reviewClient.getReviews(bookid,page);
    }

    @Override
    public Double getAverageScore(Long bookid) {
        return reviewClient.getAverageScore(bookid);
    }


}
