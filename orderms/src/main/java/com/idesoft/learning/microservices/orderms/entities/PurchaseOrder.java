package com.idesoft.learning.microservices.orderms.entities;

import com.idesoft.learning.microservices.orderms.commands.CreatePurchaseOrderProductCommand;
import com.idesoft.learning.microservices.orderms.entities.readonly.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "purchase_orders")
@Getter
@Setter
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    private Long quantity;

    public static PurchaseOrder from(CreatePurchaseOrderProductCommand command) {

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setProductId(command.productId());
        purchaseOrder.setQuantity(command.quantity());

        return purchaseOrder;
    }
}
