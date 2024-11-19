package com.idesoft.learning.microservices.orderms.consumers;

import com.idesoft.learning.microservices.orderms.entities.readonly.Product;
import com.idesoft.learning.microservices.orderms.events.ProductCreatedEvent;
import com.idesoft.learning.microservices.orderms.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductConsumer {

    private final ProductRepository productRepository;

    @RabbitListener(queues = {"queue.product_created"})
    public void consume(ProductCreatedEvent event) {
        log.info("received {}", event);

        Product product = Product.from(event);

        productRepository.save(product);
    }
}
