package com.bn.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {
    @JsonProperty("mobile_phone")
    @NotBlank(message = "mobile phone is required")
    private String mobilePhone;

    @NotBlank(message = "password is required")
    @JsonProperty("password")
    private String password;
}
