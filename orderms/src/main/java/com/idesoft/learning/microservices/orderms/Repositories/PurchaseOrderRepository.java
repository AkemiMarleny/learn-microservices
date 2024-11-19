package com.idesoft.learning.microservices.orderms.repositories;


import com.idesoft.learning.microservices.orderms.entities.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
