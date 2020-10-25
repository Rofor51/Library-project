package com.project.library.process.repository;

import com.project.library.process.entity.UserOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserOrderRepository extends MongoRepository<UserOrder, String> {




}
