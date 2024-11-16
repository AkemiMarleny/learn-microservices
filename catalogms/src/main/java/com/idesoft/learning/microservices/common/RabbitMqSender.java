package com.idesoft.learning.microservices.common;

import com.idesoft.learning.microservices.events.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RabbitMqSender {
    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    public void send(Product product) {
        log.info("sending {}", product.toString());
        rabbitTemplate.convertAndSend(exchange, routingKey, product);
    }
}
