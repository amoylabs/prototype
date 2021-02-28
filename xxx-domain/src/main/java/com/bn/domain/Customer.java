package com.bn.domain;

import com.bn.util.PasswordUtils;
import com.bn.repository.CustomerRepository;
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

    public Long save(CustomerRepository customerRepository) {
        generatePasswordSalt();
        setStatus(CustomerStatus.ACTIVE);
        return customerRepository.save(this);
    }
}
