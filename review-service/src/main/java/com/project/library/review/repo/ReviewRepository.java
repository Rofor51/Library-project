package com.project.library.review.repo;

import com.project.library.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    Review findByUsername(String username);

    Page<Review> findAll(Pageable pageable);

    Page<Review> findByBookId(Long id, Pageable pageable);

    List<Review> findByBookId(Long id);

}
