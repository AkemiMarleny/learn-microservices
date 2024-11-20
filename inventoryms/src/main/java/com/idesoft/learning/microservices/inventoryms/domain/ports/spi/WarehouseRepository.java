package com.idesoft.learning.microservices.inventoryms.domain.ports.spi;

import com.idesoft.learning.microservices.inventoryms.domain.valuables.WarehouseDetail;

import java.util.Optional;

public interface WarehouseRepository {

    Optional<WarehouseDetail> findById(Long warehouseId);
}
