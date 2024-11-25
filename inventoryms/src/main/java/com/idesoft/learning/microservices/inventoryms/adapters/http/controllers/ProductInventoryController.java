package com.idesoft.learning.microservices.inventoryms.adapters.http.controllers;

import com.idesoft.learning.microservices.inventoryms.adapters.http.dto.CreateProductInventoryDto;
import com.idesoft.learning.microservices.inventoryms.adapters.http.dto.ProductInventoryCreatedDto;
import com.idesoft.learning.microservices.inventoryms.domain.exceptions.InvalidDataException;
import com.idesoft.learning.microservices.inventoryms.domain.exceptions.RecordNotFoundException;
import com.idesoft.learning.microservices.inventoryms.domain.ports.api.CreateProductInventoryUseCase;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.CreateProductInventory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/warehouses/{warehouseId}/products")
@RestController
@RequiredArgsConstructor
public class ProductInventoryController {

    private final CreateProductInventoryUseCase createProductInventoryUseCase;

    @PostMapping
    public ResponseEntity<ProductInventoryCreatedDto> creare(@RequestBody CreateProductInventoryDto request,
                                                             @PathVariable Long warehouseId) throws RecordNotFoundException, InvalidDataException {


        Long productInventoryId = createProductInventoryUseCase.create(new CreateProductInventory(
                        request.productId(),
                        request.quantity()),
                warehouseId);

        return new ResponseEntity<>(new ProductInventoryCreatedDto(productInventoryId), HttpStatus.CREATED);
        
    }
}

