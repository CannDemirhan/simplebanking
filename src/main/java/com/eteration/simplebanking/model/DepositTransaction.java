package com.eteration.simplebanking.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;
import java.util.UUID;

// This class is a placeholder you can change the complete implementation
@NoArgsConstructor
@Entity
public class DepositTransaction extends Transaction{

    public DepositTransaction(int amount) {
        super(new Date(System.currentTimeMillis()), "DepositTransaction", (double)amount, UUID.randomUUID().toString());
    }
    public DepositTransaction(Double amount) {
        super(new Date(System.currentTimeMillis()), "DepositTransaction", amount, UUID.randomUUID().toString());
    }
}
