package com.idesoft.learning.microservices.repositories;

import com.idesoft.learning.microservices.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Long countByChecksum(String checksum);
}
