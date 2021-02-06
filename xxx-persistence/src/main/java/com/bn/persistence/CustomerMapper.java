package com.bn.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    @Insert("INSERT INTO customer (mobile_phone, password, password_salt, status, created_time, updated_time) VALUES")
    void save();
}
