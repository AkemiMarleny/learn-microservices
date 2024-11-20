package com.idesoft.learning.microservices.inventoryms.adapters.repositories;

import com.idesoft.learning.microservices.inventoryms.adapters.repositories.factories.WarehouseFactory;
import com.idesoft.learning.microservices.inventoryms.adapters.repositories.jpa.JpaWarehouseRepository;
import com.idesoft.learning.microservices.inventoryms.domain.ports.spi.WarehouseRepository;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.WarehouseDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class WarehouseRepositoryImpl implements WarehouseRepository {

    private final JpaWarehouseRepository jpaWarehouseRepository;

    @Override
    public Optional<WarehouseDetail> findById(Long warehouseId) {
        return jpaWarehouseRepository.findById(warehouseId).map(WarehouseFactory::warehouseDetailFrom);
    }
}
