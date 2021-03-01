package com.bn.controller;

import com.bn.controller.request.CreateCustomerRequest;
import com.bn.domain.Customer;
import com.bn.exception.ResourceNotFoundException;
import com.bn.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RequestMapping("v1/customers")
@RestController
@Slf4j
public class CustomerController {
    private CustomerService customerService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomer(@PathVariable("id") Long id) {
        log.info("Get customer - {}", id);
        return customerService.get(id);
    }

    @PostMapping
    public Long createCustomer(@RequestBody CreateCustomerRequest request) {
        log.info("Create customer - {}", request.getMobilePhone());
        Customer customer = Customer.builder()
            .mobilePhone(request.getMobilePhone())
            .password(request.getPassword())
            .build();
        return customerService.create(customer);
    }

    @GetMapping("/{id}/error")
    public void testGetCustomerFailure(@PathVariable String id) {
        Objects.requireNonNull(id, "customer id should not be null");
        throw new ResourceNotFoundException(String.format("customer is not found - %s", id));
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
