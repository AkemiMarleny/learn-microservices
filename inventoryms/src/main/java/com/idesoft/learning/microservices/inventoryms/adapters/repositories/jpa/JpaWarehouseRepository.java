package com.idesoft.learning.microservices.inventoryms.adapters.repositories.jpa;

import com.idesoft.learning.microservices.inventoryms.adapters.repositories.dao.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaWarehouseRepository extends JpaRepository<Warehouse, Long> {
}
