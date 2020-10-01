package com.project.library.order.web;

import com.project.library.order.model.Order;
import com.project.library.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/validate")
public class OrderController {
    private final OrderService orderService;


    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody  Order order) {
        return orderService.createOrder(order);

    }
}
