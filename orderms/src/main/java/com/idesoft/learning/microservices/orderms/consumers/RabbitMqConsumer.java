package com.idesoft.learning.microservices.orderms.consumers;

import com.idesoft.learning.microservices.orderms.events.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMqConsumer {
    @RabbitListener(queues =  {"${spring.rabbitmq.queue}"})
    public void consume(Product object) {
        log.info("received {}", object);
    }
}
