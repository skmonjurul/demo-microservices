package com.skmonjurul.customer.service;

import com.skmonjurul.customer.dto.FraudCustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FraudServiceProxy {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${fraud.service.url}")
    private String fraudServiceUrl;

    public void addCustomer(FraudCustomerDetails fraudCustomerDetails) {

        HttpEntity<FraudCustomerDetails> httpEntity = new HttpEntity<>(fraudCustomerDetails);
        restTemplate.postForObject(fraudServiceUrl, httpEntity, Void.class);
    }
}
