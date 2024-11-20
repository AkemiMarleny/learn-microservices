package com.idesoft.learning.microservices.inventoryms.domain.ports.spi;

import com.idesoft.learning.microservices.inventoryms.domain.valuables.SaveProductInventory;

public interface ProductInventoryRepository {

    Long save(SaveProductInventory payload, Long warehouseId);
}
