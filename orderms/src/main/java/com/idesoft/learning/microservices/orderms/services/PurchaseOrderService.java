package com.idesoft.learning.microservices.orderms.services;

import com.idesoft.learning.microservices.orderms.Repositories.PurchaseOrderRepository;
import com.idesoft.learning.microservices.orderms.commands.CreatePurchaseOrderProductCommand;
import com.idesoft.learning.microservices.orderms.entities.PurchaseOrder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;

    public Long save(@Valid CreatePurchaseOrderProductCommand command) {

        PurchaseOrder purchaseOrder = PurchaseOrder.from(command);

        return purchaseOrderRepository.save(purchaseOrder).getId();
    }
}
