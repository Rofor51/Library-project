package com.project.library.order.web;

import com.project.library.order.model.Order;
import com.project.library.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/validate")
public class OrderController {
    private final OrderService orderService;


    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    private String return400(Exception ex) {
        return ex.getMessage();

    }
}
