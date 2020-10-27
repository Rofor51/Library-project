package com.project.library.process.web;

import com.project.library.process.entity.UserOrder;
import com.project.library.process.service.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class Rest {
    private OrderService orderService;

    public Rest(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public List<UserOrder> getAllOrders() {
        return orderService.getAllOrders();
    }




}
