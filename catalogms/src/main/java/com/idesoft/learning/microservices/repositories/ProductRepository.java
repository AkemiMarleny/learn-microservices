package com.idesoft.learning.microservices.repositories;

import com.idesoft.learning.microservices.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Long countByChecksum(String checksum);

    Long countByChecksumAndIdNotIn(String checksum, List<Long> ids);
}
