package com.skmonjurul.fraud.service;

import com.skmonjurul.fraud.dto.FraudCustomerDetails;
import com.skmonjurul.fraud.model.Fraudster;
import com.skmonjurul.fraud.repository.FraudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudService implements IFraudService{


    private FraudRepository fraudRepository;

    public FraudService(@Autowired FraudRepository fraudRepository) {
        this.fraudRepository = fraudRepository;
    }

    public Boolean isFraudulentCustomer(Integer customerId) {
        fraudRepository.getById(customerId);
        return false;
    }

    public void addCustomer(FraudCustomerDetails fraudCustomerDetails) {
        fraudRepository.save(buildFraudster(fraudCustomerDetails));
    }

    private Fraudster buildFraudster(FraudCustomerDetails customerDetails) {
        Fraudster fraudster = new Fraudster();
        fraudster.setCustomerID(customerDetails.getCustomerId());
        fraudster.setIsFraudster(customerDetails.getIsFraud());
        fraudster.setCreatedOn(LocalDateTime.now());

        return fraudster;
    }
}
