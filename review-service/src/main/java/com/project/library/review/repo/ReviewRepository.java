package com.project.library.review.repo;

import com.mongodb.client.MongoDatabase;
import com.project.library.review.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    Review findByUsername(String username);

    List<Review> findByBookId(Long id);

}
