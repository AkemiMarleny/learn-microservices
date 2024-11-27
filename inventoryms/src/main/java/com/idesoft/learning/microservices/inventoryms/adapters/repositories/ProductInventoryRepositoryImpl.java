package com.idesoft.learning.microservices.inventoryms.adapters.repositories;

import com.idesoft.learning.microservices.inventoryms.adapters.repositories.dao.ProductInventory;
import com.idesoft.learning.microservices.inventoryms.adapters.repositories.jpa.JpaProductInventoryRepository;
import com.idesoft.learning.microservices.inventoryms.domain.ports.spi.ProductInventoryRepository;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.SaveProductInventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductInventoryRepositoryImpl implements ProductInventoryRepository {

    private final JpaProductInventoryRepository jpaProductInventoryRepository;

    @Override
    public Long save(SaveProductInventory payload, Long warehouseId) {
        return jpaProductInventoryRepository.save(ProductInventory.from(payload, warehouseId)).getId();
    }

    @Override
    public Long sumQuantityByProductId(Long productId) {
        return jpaProductInventoryRepository.sumQuantityByProductId(productId);
    }
}
