package com.idesoft.learning.microservices.inventoryms.adapters.repositories.factories;

import com.idesoft.learning.microservices.inventoryms.adapters.repositories.dao.readonly.Product;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.ProductDetail;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductFactory {

    public static ProductDetail productDetailFrom(Product product) {
        return new ProductDetail(
                product.getId(),
                product.getNome(),
                product.getUnitMeasureId(),
                product.getTotalStock()
        );
    }
}
