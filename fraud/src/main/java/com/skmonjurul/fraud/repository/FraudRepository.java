package com.skmonjurul.fraud.repository;

import com.skmonjurul.fraud.model.Fraudster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRepository extends JpaRepository<Fraudster, Integer> {
}
