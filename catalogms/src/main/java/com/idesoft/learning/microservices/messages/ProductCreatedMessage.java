package com.idesoft.learning.microservices.messages;

import com.idesoft.learning.microservices.events.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductCreatedMessage {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.product-created-rk}")
    private String routingKey;

    public void send(ProductCreatedEvent productCreated) {
        rabbitTemplate.convertAndSend(exchange, routingKey, productCreated);
    }
}
