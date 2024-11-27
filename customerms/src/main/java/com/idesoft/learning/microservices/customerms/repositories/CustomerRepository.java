package com.idesoft.learning.microservices.customerms.repositories;

import com.idesoft.learning.microservices.customerms.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Long countByChecksum(String checksum);
}
