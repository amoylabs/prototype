package com.bn.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveCustomerRequest {
    @JsonProperty("mobile_phone")
    private String mobilePhone;
    @JsonProperty("password")
    private String password;
}
