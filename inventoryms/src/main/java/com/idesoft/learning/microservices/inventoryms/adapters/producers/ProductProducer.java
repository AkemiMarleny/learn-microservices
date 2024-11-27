package com.idesoft.learning.microservices.inventoryms.adapters.producers;

import com.idesoft.learning.microservices.inventoryms.domain.events.ProductStockModifiedEvent;
import com.idesoft.learning.microservices.inventoryms.domain.ports.spi.ProductStockChangedPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductProducer implements ProductStockChangedPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.product-stock-modified-rk}")
    private String productStockModifiedRk;

    @Override
    public void publish(ProductStockModifiedEvent event) {
        rabbitTemplate.convertAndSend(exchange, productStockModifiedRk, event);

    }
}
