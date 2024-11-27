package com.idesoft.learning.microservices.inventoryms.adapters.repositories.jpa;

import com.idesoft.learning.microservices.inventoryms.adapters.repositories.dao.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaProductInventoryRepository extends JpaRepository<ProductInventory, Long> {

    @Query("SELECT SUM(p.quantity) FROM ProductInventory p WHERE p.productId= ?1")
    Long sumQuantityByProductId(Long productId);
}
