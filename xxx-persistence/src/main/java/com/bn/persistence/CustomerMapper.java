package com.bn.persistence;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    void insert(CustomerDO customerDO);
}
