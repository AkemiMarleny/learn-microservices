package com.idesoft.learning.microservices.inventoryms.adapters.repositories.dao.readonly;

import com.idesoft.learning.microservices.inventoryms.domain.events.ProductCreatedEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    private Long id;

    private String nome;

    private Long unitMeasureId;

    private Long totalStock;

    public static Product from(ProductCreatedEvent event) {

        Product product = new Product();
        product.setId(event.id());
        product.setNome(event.name());
        product.setUnitMeasureId(event.unitMeasureId());
        product.setTotalStock(event.totalStock());

        return product;
    }
}
