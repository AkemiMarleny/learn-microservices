package com.idesoft.learning.microservices.inventoryms.adapters.repositories.factories;

import com.idesoft.learning.microservices.inventoryms.adapters.repositories.dao.Warehouse;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.WarehouseDetail;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WarehouseFactory {

    public static WarehouseDetail warehouseDetailFrom(Warehouse warehouse) {
        return new WarehouseDetail(
                warehouse.getId(),
                warehouse.getName(),
                warehouse.getDescription()
        );
    }

}
