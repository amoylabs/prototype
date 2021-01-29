package com.bn.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Customer {
    private Long id;
    private String mobilePhone;
    private String password;
    private String passwordSalt;
}
