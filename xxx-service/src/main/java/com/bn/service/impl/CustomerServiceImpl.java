package com.bn.service.impl;

import com.bn.domain.Customer;
import com.bn.repository.CustomerRepository;
import com.bn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public Long create(Customer customer) {
        customer.init();
        return customerRepository.save(customer);
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
