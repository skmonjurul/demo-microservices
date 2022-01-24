package com.skmonjurul.clients;

import com.skmonjurul.clients.dto.FraudCustomerDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("fraud")
public interface FraudClient {

    @PostMapping("/v1/fraud")
    void addCustomer(@RequestBody FraudCustomerDetails fraudCustomerDetails);

    @GetMapping("/v1/fraud/{customerID}")
    Boolean isCustomerFraudulent(@PathVariable(value = "customerID") Integer customerId);
}
