package com.skmonjurul.fraud.service;

import com.skmonjurul.fraud.dto.FraudCustomerDetails;

public interface IFraudService {

    public Boolean isFraudulentCustomer(Integer customerId);
    public void addCustomer(FraudCustomerDetails fraudCustomerDetails);
}
