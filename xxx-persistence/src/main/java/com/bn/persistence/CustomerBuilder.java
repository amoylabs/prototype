package com.bn.persistence;

import com.bn.domain.Customer;

import java.time.LocalDateTime;

public interface CustomerBuilder {
    static CustomerDO fromDomain(Customer customer) {
        CustomerDO data = CustomerDO.builder()
            .mobilePhone(customer.getMobilePhone())
            .password(customer.getPassword())
            .passwordSalt(customer.getPasswordSalt())
            .status(customer.getStatus())
            .build();
        data.setCreatedTime(LocalDateTime.now());
        data.setUpdatedTime(LocalDateTime.now());
        return data;
    }

    static Customer fromDO(CustomerDO customerDO) {
        Customer customer = Customer.builder()
                .mobilePhone(customerDO.getMobilePhone())
                .password(customerDO.getPassword())
                .passwordSalt(customerDO.getPasswordSalt())
                .status(customerDO.getStatus())
                .build();
        return customer;
    }
}
