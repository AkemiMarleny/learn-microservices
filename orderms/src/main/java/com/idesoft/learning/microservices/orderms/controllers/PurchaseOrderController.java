package com.idesoft.learning.microservices.orderms.controllers;

import com.idesoft.learning.microservices.orderms.commands.CreatePurchaseOrderProductCommand;
import com.idesoft.learning.microservices.orderms.dtos.CreatePurchaseOrderProductDto;
import com.idesoft.learning.microservices.orderms.dtos.PurchaseOrderProductCreatoDto;
import com.idesoft.learning.microservices.orderms.services.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/purchase-orders")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrderProductCreatoDto> create(@RequestBody CreatePurchaseOrderProductDto request) {

        Long purchaseOrderId = purchaseOrderService.save(new CreatePurchaseOrderProductCommand(
                request.productId(),
                request.quantity()
        ));
        return new ResponseEntity<>(new PurchaseOrderProductCreatoDto(purchaseOrderId), HttpStatus.CREATED);
    }
}
