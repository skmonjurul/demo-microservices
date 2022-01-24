package com.skmonjurul.customer.service;

import com.skmonjurul.clients.FraudClient;
import com.skmonjurul.customer.dto.FraudCustomerDetails;
import com.skmonjurul.customer.model.Customer;
import com.skmonjurul.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FraudServiceProxy fraudServiceProxy;

    @Autowired
    private FraudClient fraudClient;

    private final String FRAUD = "fraud";

    public void registerCustomer(Customer customer) {
        //first add the customer to customer database
        customerRepository.save(customer);

        //check if the customer is fraud or not by customer name
        Boolean isFraud = checkCustomerFraudOrNot(customer.getFirstName() + " " + customer.getLastName());

        //add the customer to fraud database as per fraud status
//        addCustomerToFraudService(customer.getId(), isFraud);

        //add the customer to fraud database as per fraud status using feign clients
        addCustomerToFraudServiceUsingOpenFeignClient(customer.getId(), isFraud);
    }

    private void addCustomerToFraudServiceUsingOpenFeignClient(Integer id, Boolean isFraud) {
        com.skmonjurul.clients.dto.FraudCustomerDetails fraudCustomerDetails = new com.skmonjurul.clients.dto.FraudCustomerDetails();
        fraudCustomerDetails.setCustomerId(id);
        fraudCustomerDetails.setIsFraud(isFraud);
        fraudClient.addCustomer(fraudCustomerDetails);
    }

    private void addCustomerToFraudService(Integer id, Boolean isFraud) {
        fraudServiceProxy.addCustomer(buildFraudCustomerDetails(id, isFraud));
    }

    private FraudCustomerDetails buildFraudCustomerDetails(Integer id, Boolean isFraud) {
        FraudCustomerDetails fraudCustomerDetails = new FraudCustomerDetails();
        fraudCustomerDetails.setCustomerId(id);
        fraudCustomerDetails.setIsFraud(isFraud);

        return fraudCustomerDetails;
    }

    @Override
    public List<Customer> fetchAllCustomer() {
        return customerRepository.findAll();
    }

    //this is just a dummy method to check a customer fraud or not based on their name
    private Boolean checkCustomerFraudOrNot(String name) {
        return name.contains(FRAUD);
    }
}
