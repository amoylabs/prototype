package com.bn.controller;

import com.bn.controller.request.SaveCustomerRequest;
import com.bn.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/customer")
@RestController
@Slf4j
public class CustomerController {
    private CustomerService customerService;

    @PostMapping
    public Long saveCustomer(@RequestBody SaveCustomerRequest request) {
        log.info("Save customer - {}", request.getMobilePhone());
        return customerService.save();
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
