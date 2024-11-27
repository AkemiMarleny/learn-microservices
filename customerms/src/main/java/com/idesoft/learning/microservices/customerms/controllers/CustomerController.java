package com.idesoft.learning.microservices.customerms.controllers;

import com.idesoft.learning.microservices.customerms.controllers.dto.CreateCustomerDto;
import com.idesoft.learning.microservices.customerms.controllers.dto.CustomerCreatedDto;
import com.idesoft.learning.microservices.customerms.entities.Customer;
import com.idesoft.learning.microservices.customerms.exceptions.ConflictException;
import com.idesoft.learning.microservices.customerms.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<CustomerCreatedDto> creare(@RequestBody CreateCustomerDto request) throws ConflictException {

        Customer customer = Customer.from(request);

        Long customerCounter = customerRepository.countByChecksum(customer.getChecksum());

        if (customerCounter > 0) {
            throw new ConflictException("Customer already exist");
        }

        Long customerId = customerRepository.save(customer).getId();

        return new ResponseEntity<>(new CustomerCreatedDto(customerId), HttpStatus.CREATED);
    }
}
