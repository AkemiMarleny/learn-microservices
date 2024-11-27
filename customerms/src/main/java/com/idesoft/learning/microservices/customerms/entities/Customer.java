package com.idesoft.learning.microservices.customerms.entities;

import com.idesoft.learning.microservices.customerms.controllers.dto.CreateCustomerDto;
import com.idesoft.learning.microservices.customerms.valuables.CustomerChecksum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "document_type_id", insertable = false, updatable = false)
    private DocumentType documentType;

    @Column(name = "document_type_id", nullable = false)
    private Long documentTypeId;

    private String documentNumber;

    private String checksum;

    public static Customer from(CreateCustomerDto request) {

        Customer customer = new Customer();
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setDocumentTypeId(request.documentTypeId());
        customer.setDocumentNumber(request.documentNumber());
        customer.setChecksum(new CustomerChecksum(request).get());

        return customer;
    }

}
