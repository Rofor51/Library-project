package com.project.library.process.service;

import com.project.library.process.entity.UserOrder;
import com.project.library.process.model.Order;
import com.project.library.process.repository.UserOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableKafka
public class OrderService {
    private final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    private UserOrderRepository userOrderRepository;

    public OrderService(UserOrderRepository userOrderRepository) {
        this.userOrderRepository = userOrderRepository;
    }


    @KafkaListener(topics = "order_topic", groupId = "order_handlers",containerFactory = "orderConcurrentKafkaListenerContainerFactory")
    public void messageProcess(@Payload(required = false) Order order) {
        LOGGER.info("New order has been received : " + order);
        createNewOrder(order.getUserName(),order.getBookId());

    }

    public List<UserOrder> getAllOrders() {
        return userOrderRepository.findAll();
    }

    public void createNewOrder(String username, Long [] bookIds) {
        userOrderRepository.save(new UserOrder(username,bookIds));
    }







}
