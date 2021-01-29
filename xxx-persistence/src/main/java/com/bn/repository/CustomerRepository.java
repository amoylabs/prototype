package com.bn.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class CustomerRepository {
    public Long save() {
        log.info("Customer Repository save data and return pk value - {}", 1L);
        return 1L;
    }
}
