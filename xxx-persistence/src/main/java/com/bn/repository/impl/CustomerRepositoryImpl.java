package com.bn.repository.impl;

import com.bn.domain.Customer;
import com.bn.persistence.CustomerBuilder;
import com.bn.persistence.CustomerDO;
import com.bn.persistence.CustomerMapper;
import com.bn.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer get(Long id) {
        CustomerDO customerDO = customerMapper.selectByPrimaryKey(id);
        return CustomerBuilder.fromDO(customerDO);
    }

    @Override
    public Long save(Customer customer) {
        CustomerDO customerDO = CustomerBuilder.fromDomain(customer);
        customerMapper.insert(customerDO);
        log.info("Customer Repository save data and return pk value - {}", customerDO.getMobilePhone());
        return customerDO.getId();
    }
}
