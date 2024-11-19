package com.idesoft.learning.microservices.inventoryms.adapters.repositories.jpa;

import com.idesoft.learning.microservices.inventoryms.adapters.repositories.dao.readonly.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long> {
}
