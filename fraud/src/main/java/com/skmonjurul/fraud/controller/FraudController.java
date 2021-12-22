package com.skmonjurul.fraud.controller;


import com.skmonjurul.fraud.dto.FraudCustomerDetails;
import com.skmonjurul.fraud.service.IFraudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/fraud")
public class FraudController {

    @Autowired
    private IFraudService fraudService;

    @PostMapping
    public void addCustomer(@RequestBody FraudCustomerDetails fraudCustomerDetails) {
        fraudService.addCustomer(fraudCustomerDetails);
    }

    @GetMapping("/{customerID}")
    public Boolean isCustomerFraudulent(@PathVariable(value = "customerID") Integer customerId) {
        return fraudService.isFraudulentCustomer(customerId);
    }
}
