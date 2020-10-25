package com.project.library.order.service;

import com.project.library.order.model.Order;
import org.springframework.http.ResponseEntity;


public interface OrderService {
    ResponseEntity<String> createOrder(Order order);

}
