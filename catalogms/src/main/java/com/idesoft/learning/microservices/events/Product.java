package com.idesoft.learning.microservices.events;

import java.io.Serializable;

public record Product(
        Long id,
        String name)
        implements Serializable {

}
