package com.idesoft.learning.microservices.inventoryms.adapters.repositories.jpa;

import com.idesoft.learning.microservices.inventoryms.adapters.repositories.dao.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductInventoryRepository extends JpaRepository<ProductInventory, Long> {
}
