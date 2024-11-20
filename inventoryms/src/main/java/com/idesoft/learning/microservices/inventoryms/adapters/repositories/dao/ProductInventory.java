package com.idesoft.learning.microservices.inventoryms.adapters.repositories.dao;

import com.idesoft.learning.microservices.inventoryms.adapters.repositories.dao.readonly.Product;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.SaveProductInventory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_inventories")
@Getter
@Setter
public class ProductInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    private Long quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warehouse_id", insertable = false, updatable = false)
    private Warehouse warehouse;

    @Column(name = "warehouse_id", nullable = false)
    private Long warehouseId;

    public static ProductInventory from(SaveProductInventory payload, Long warehouseId) {

        ProductInventory productInventory = new ProductInventory();

        productInventory.setProductId(payload.productId());
        productInventory.setQuantity(payload.quantity());
        productInventory.setWarehouseId(warehouseId);

        return productInventory;
    }
}
