package com.idesoft.learning.microservices.inventoryms.domain.ports.api;

import com.idesoft.learning.microservices.inventoryms.domain.exceptions.InvalidDataException;
import com.idesoft.learning.microservices.inventoryms.domain.exceptions.RecordNotFoundException;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.CreateProductInventory;
import jakarta.validation.Valid;

public interface CreateProductInventoryUseCase {
    Long create(@Valid CreateProductInventory payload, Long warehouseId) throws RecordNotFoundException, InvalidDataException;
}
