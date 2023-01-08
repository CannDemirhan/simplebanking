package com.eteration.simplebanking.model;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;
import java.util.UUID;

// This class is a placeholder you can change the complete implementation
@NoArgsConstructor
@Entity
public class WithdrawalTransaction extends Transaction{

    public WithdrawalTransaction(int amount) {
        super(new Date(System.currentTimeMillis()), "WithdrawalTransaction", (double)amount, UUID.randomUUID().toString());
    }
    public WithdrawalTransaction(Double amount) {
        super(new Date(System.currentTimeMillis()), "WithdrawalTransaction", amount, UUID.randomUUID().toString());
    }
}


