package com.bn.repository.impl;

import com.bn.domain.Customer;
import com.bn.exception.NotFoundException;
import com.bn.mapper.CustomerMapper;
import com.bn.persistence.CustomerBuilder;
import com.bn.persistence.CustomerDO;
import com.bn.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class CustomerRepositoryImpl implements CustomerRepository {
    private CustomerMapper customerMapper;

    @Override
    public Customer get(Long id) {
        CustomerDO customerDO = customerMapper.selectByPrimaryKey(id);
        if (customerDO == null) throw new NotFoundException("customer not found - " + id);
        return CustomerBuilder.fromDO(customerDO);
    }

    @Override
    public Long save(Customer customer) {
        CustomerDO customerDO = CustomerBuilder.fromDomain(customer);
        customerMapper.insert(customerDO);
        log.info("Customer Repository save data and return id - {}", customerDO.getId());
        return customerDO.getId();
    }

    @Autowired
    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }
}
