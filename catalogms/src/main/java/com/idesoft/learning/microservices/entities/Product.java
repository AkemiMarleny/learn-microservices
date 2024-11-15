package com.idesoft.learning.microservices.entities;

import java.io.Serializable;

public record Product(
        Long id,
        String name)
        implements Serializable {

}
