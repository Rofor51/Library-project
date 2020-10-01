package com.project.library.order.service.imp;

import com.project.library.order.feignclient.BookClient;
import com.project.library.order.model.Order;
import com.project.library.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {
    private final BookClient bookClient;


    @Override
    public ResponseEntity<String> createOrder(Order order) {
        if(bookClient.validateBook(order.getBookId()).getStatusCode() == HttpStatus.ACCEPTED) {
            return ResponseEntity.ok().body("Order has been confirmed. " + HttpStatus.OK);
        }
        else {
            return ResponseEntity.ok().body("Sorry order could not be processed. " + HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
