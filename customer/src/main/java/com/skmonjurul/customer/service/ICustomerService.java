package com.skmonjurul.customer.service;

import com.skmonjurul.customer.model.Customer;

import java.util.List;

public interface ICustomerService {

    public void registerCustomer(Customer customer);

    public List<Customer> fetchAllCustomer();
}
