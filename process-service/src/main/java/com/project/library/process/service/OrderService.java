package com.project.library.process.service;

import com.project.library.process.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@EnableKafka
public class OrderService {
    private final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @KafkaListener(topics = "order_topic", groupId = "order_handlers",containerFactory = "orderConcurrentKafkaListenerContainerFactory")
    public void messageProcess(@Payload Order order) {
        LOGGER.info("New order has been received : " + order);

    }
}
