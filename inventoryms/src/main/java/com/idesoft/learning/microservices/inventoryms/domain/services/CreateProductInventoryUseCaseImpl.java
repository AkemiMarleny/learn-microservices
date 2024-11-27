package com.idesoft.learning.microservices.inventoryms.domain.services;

import com.idesoft.learning.microservices.inventoryms.domain.events.ProductStockModifiedEvent;
import com.idesoft.learning.microservices.inventoryms.domain.exceptions.InvalidDataException;
import com.idesoft.learning.microservices.inventoryms.domain.exceptions.RecordNotFoundException;
import com.idesoft.learning.microservices.inventoryms.domain.ports.api.CreateProductInventoryUseCase;
import com.idesoft.learning.microservices.inventoryms.domain.ports.spi.ProductInventoryRepository;
import com.idesoft.learning.microservices.inventoryms.domain.ports.spi.ProductRepository;
import com.idesoft.learning.microservices.inventoryms.domain.ports.spi.ProductStockChangedPublisher;
import com.idesoft.learning.microservices.inventoryms.domain.ports.spi.WarehouseRepository;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.CreateProductInventory;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.ProductDetail;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.SaveProductInventory;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.WarehouseDetail;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class CreateProductInventoryUseCaseImpl implements CreateProductInventoryUseCase {

    private final ProductInventoryRepository productInventoryRepository;
    private final WarehouseRepository warehouseRepository;
    private final ProductRepository productRepository;
    private final ProductStockChangedPublisher productStockChangedPublisher;

    @Override
    public Long create(@Valid CreateProductInventory payload, Long warehouseId) throws RecordNotFoundException, InvalidDataException {

        WarehouseDetail warehouseDetail = warehouseRepository.findById(warehouseId).orElseThrow(() -> new RecordNotFoundException(String.format("Warehouse with id %s not found", warehouseId)));

        ProductDetail productDetail = productRepository.findById(payload.productId()).orElseThrow(() -> new InvalidDataException(String.format("Product with id %s not found", payload.productId())));

        Long productInventoryId = productInventoryRepository.save(new SaveProductInventory(
                        payload.productId(),
                        payload.quantity()),
                warehouseId);

        Long totalStock = productInventoryRepository.sumQuantityByProductId(payload.productId());

        productStockChangedPublisher.publish(new ProductStockModifiedEvent(productDetail.id(), totalStock));

        return productInventoryId;
    }
}
