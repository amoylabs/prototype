package com.bn.domain;

import com.bn.util.PasswordUtils;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private String mobilePhone;
    private String password;
    private String passwordSalt;
    private CustomerStatus status;

    private void generatePasswordSalt() {
        this.passwordSalt = PasswordUtils.getSalt();
    }

    public void init() {
        generatePasswordSalt();
        setStatus(CustomerStatus.ACTIVE);
    }
}
