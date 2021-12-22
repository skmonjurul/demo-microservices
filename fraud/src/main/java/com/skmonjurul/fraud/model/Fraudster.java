package com.skmonjurul.fraud.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "fraud_master")
@NoArgsConstructor
@Getter
@Setter
public class Fraudster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer customerID;
    private Boolean isFraudster;
    private LocalDateTime createdOn;
}
