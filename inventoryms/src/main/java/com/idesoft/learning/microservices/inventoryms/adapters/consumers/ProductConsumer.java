package com.idesoft.learning.microservices.inventoryms.adapters.consumers;

import com.idesoft.learning.microservices.inventoryms.domain.events.ProductCreatedEvent;
import com.idesoft.learning.microservices.inventoryms.domain.ports.spi.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductConsumer {

    private final ProductRepository productRepository;

    @RabbitListener(queues = {"queue.product_created"})
    public void consume(ProductCreatedEvent event) {
        log.info("received {}", event);
        
        productRepository.save(event);
    }
}
