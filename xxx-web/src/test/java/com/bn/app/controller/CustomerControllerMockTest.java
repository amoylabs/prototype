package com.bn.app.controller;

import com.bn.controller.CustomerController;
import com.bn.controller.request.SaveCustomerRequest;
import com.bn.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerMockTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CustomerService customerService;

    @Test
    public void saveCustomer() throws Exception {
        Long result = 1L;
        when(customerService.save()).thenReturn(result);
        SaveCustomerRequest request = SaveCustomerRequest.builder().mobilePhone("12333222332").password("q1w2e3r4").build();
        MockHttpServletRequestBuilder builder = post("/api/customer")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request));
        ResultMatcher success = status().isOk();
        ResultMatcher body = content().string(result.toString());
        mockMvc.perform(builder).andDo(print()).andExpect(status().isOk()).andExpect(success).andExpect(body);
    }
}
