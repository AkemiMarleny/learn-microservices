package com.idesoft.learning.microservices.orderms.repositories;

import com.idesoft.learning.microservices.orderms.entities.readonly.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
