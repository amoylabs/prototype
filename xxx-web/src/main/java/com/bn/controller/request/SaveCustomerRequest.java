package com.bn.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SaveCustomerRequest {
    @JsonProperty("mobile_phone")
    private String mobilePhone;
    @JsonProperty("password")
    private String password;
}
