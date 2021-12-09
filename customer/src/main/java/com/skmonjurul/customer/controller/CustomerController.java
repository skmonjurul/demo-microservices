package com.skmonjurul.customer.controller;

import com.skmonjurul.customer.model.Customer;
import com.skmonjurul.customer.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/customers")
    public void registerCustomer(@RequestBody Customer customer) {
        customerService.registerCustomer(customer);
    }


    @GetMapping("/customers")
    public List<Customer> fetchAllCustomer() {
        return customerService.fetchAllCustomer();
    }

}
