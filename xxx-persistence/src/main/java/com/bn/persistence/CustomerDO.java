package com.bn.persistence;

import com.bn.domain.CustomerStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class CustomerDO {
    private Long id;
    private String mobilePhone;
    private String password;
    private String passwordSalt;
    private CustomerStatus status;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
