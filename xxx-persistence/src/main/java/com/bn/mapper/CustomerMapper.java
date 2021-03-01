package com.bn.mapper;

import com.bn.persistence.CustomerDO;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {
    CustomerDO selectByPrimaryKey(Long id);

    void insert(CustomerDO customerDO);
}
