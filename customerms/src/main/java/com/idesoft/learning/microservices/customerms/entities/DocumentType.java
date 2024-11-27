package com.idesoft.learning.microservices.customerms.entities;

import com.idesoft.learning.microservices.customerms.common.helpers.Sum;
import com.idesoft.learning.microservices.customerms.controllers.dto.CreateDocumentTypeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "documentTypes")
@Getter
@Setter
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String checksum;

    public static DocumentType from(CreateDocumentTypeDto request) {

        DocumentType documentType = new DocumentType();
        documentType.setName(request.name());
        documentType.setDescription(request.description());
        documentType.setChecksum(Sum.fromContent(request.name()));

        return documentType;

    }

}
