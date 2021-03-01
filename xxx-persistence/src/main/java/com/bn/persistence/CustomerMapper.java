package com.bn.persistence;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDO selectByPrimaryKey(Long id);
    void insert(CustomerDO customerDO);
}
