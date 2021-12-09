package com.skmonjurul.customer.service;

import com.skmonjurul.customer.model.Customer;
import com.skmonjurul.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public void registerCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchAllCustomer() {
        return customerRepository.findAll();
    }
}
