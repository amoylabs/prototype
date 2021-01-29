package com.bn.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
@Slf4j
public class CustomerRepository {
    public Long save() {
        long id = new Random().nextLong();
        log.info("Customer Repository save data and return pk value - {}", id);
        return id;
    }
}
