package com.bn.domain;

import com.bn.common.PasswordUtils;
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

    private CustomerRepository customerRepository;

    private void generatePasswordSalt() {
        this.passwordSalt = PasswordUtils.getSalt();
    }

    public Long save() {
        generatePasswordSalt();
        setStatus(CustomerStatus.ACTIVE);
        return customerRepository.save(this);
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
