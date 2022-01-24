package com.skmonjurul.clients.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FraudCustomerDetails {
    private Integer customerId;
    private Boolean isFraud;
}
