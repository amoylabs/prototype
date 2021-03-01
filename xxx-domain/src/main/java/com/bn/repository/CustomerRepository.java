package com.bn.repository;

import com.bn.domain.Customer;

public interface CustomerRepository {
    Customer get(Long id);
    Long save(Customer customer);
}
