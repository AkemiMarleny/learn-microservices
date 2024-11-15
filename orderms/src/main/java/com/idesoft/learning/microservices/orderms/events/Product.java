package com.idesoft.learning.microservices.orderms.events;

import java.io.Serializable;

public record Product(Long id, String name) implements Serializable {
}
