package com.idesoft.learning.microservices.customerms.repositories;

import com.idesoft.learning.microservices.customerms.entities.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {

    Long countByChecksum(String checksum);
}
