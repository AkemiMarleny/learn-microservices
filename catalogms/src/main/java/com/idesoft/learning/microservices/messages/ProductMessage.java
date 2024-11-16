package com.idesoft.learning.microservices.messages;

import com.idesoft.learning.microservices.events.ProductCreatedEvent;
import com.idesoft.learning.microservices.events.ProductModifiedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMessage {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.product-created-rk}")
    private String productCreatedRk;

    @Value("${spring.rabbitmq.product-modified-rk}")
    private String productModifiedRk;

    public void send(ProductCreatedEvent event) {
        rabbitTemplate.convertAndSend(exchange, productCreatedRk, event);
    }

    public void send(ProductModifiedEvent event) {
        rabbitTemplate.convertAndSend(exchange, productModifiedRk, event);
    }
}
