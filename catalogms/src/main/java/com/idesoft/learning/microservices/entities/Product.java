package com.idesoft.learning.microservices.entities;

import com.idesoft.learning.microservices.common.helpers.Sum;
import com.idesoft.learning.microservices.controllers.dto.CreateProductDto;
import com.idesoft.learning.microservices.controllers.dto.UpdateProductDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_measure_id", insertable = false, updatable = false)
    private UnitMeasure unitMeasure;

    @Column(name = "unit_measure_id")
    private Long unitMeasureId;

    private Long totalStock;

    @Column(length = 50)
    private String checksum;

    public static Product from(CreateProductDto request) {
        Product product = new Product();

        product.setName(request.name());
        product.setDescription(request.description());
        product.setUnitMeasureId(request.unitMeasureId());
        product.setTotalStock(request.totalStock());
        product.setChecksum(Sum.fromContent(request.name().trim().toLowerCase()));

        return product;
    }

    public void updateWith(UpdateProductDto request) {

        name = request.name();
        description = request.description();
        unitMeasureId = request.unitMeasureId();
        checksum = Sum.fromContent(request.name().trim().toLowerCase());
    }
}
