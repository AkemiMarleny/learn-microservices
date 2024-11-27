package com.idesoft.learning.microservices.customerms.controllers;

import com.idesoft.learning.microservices.customerms.controllers.dto.CreateDocumentTypeDto;
import com.idesoft.learning.microservices.customerms.controllers.dto.DocumentTypeCreatedDto;
import com.idesoft.learning.microservices.customerms.entities.DocumentType;
import com.idesoft.learning.microservices.customerms.exceptions.ConflictException;
import com.idesoft.learning.microservices.customerms.repositories.DocumentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/documentTypes")
@RequiredArgsConstructor
public class DocumentTypeController {

    private final DocumentTypeRepository documentTypeRepository;

    @PostMapping
    public ResponseEntity<DocumentTypeCreatedDto> creare(@RequestBody CreateDocumentTypeDto request) throws ConflictException {

        DocumentType documentType = DocumentType.from(request);

        Long documentTypeCounter = documentTypeRepository.countByChecksum(documentType.getChecksum());

        if (documentTypeCounter > 0) {
            throw new ConflictException("Document type already exist");
        }

        Long documentTypeId = documentTypeRepository.save(documentType).getId();

        return new ResponseEntity<>(new DocumentTypeCreatedDto(documentTypeId), HttpStatus.CREATED);

    }
}
