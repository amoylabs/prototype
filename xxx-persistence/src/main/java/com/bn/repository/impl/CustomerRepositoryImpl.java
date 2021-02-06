package com.bn.repository.impl;

import com.bn.domain.Customer;
import com.bn.persistence.CustomerBuilder;
import com.bn.persistence.CustomerDO;
import com.bn.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Long save(Customer customer) {
        CustomerDO customerDO = CustomerBuilder.fromDomain(customer);
        log.info("Customer Repository save data and return pk value - {}", customerDO.getMobilePhone());
        return 1L;
    }
}
