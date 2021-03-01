package com.bn.service;

import com.bn.domain.Customer;

public interface CustomerService {
    Long create(Customer customer);

    Customer get(Long id);
}
