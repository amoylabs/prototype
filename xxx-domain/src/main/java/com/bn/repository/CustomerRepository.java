package com.bn.repository;

import com.bn.domain.Customer;

public interface CustomerRepository {
    Long save(Customer customer);
}
