package com.eteration.simplebanking.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.UUID;
@NoArgsConstructor
@Entity
public class PhoneBillPaymentTransaction extends BillPaymentTransaction{

    private String phoneNumber;

    public PhoneBillPaymentTransaction(String payee, String phoneNumber, Double amount) {
        super(payee, amount, "WithdrawalTransaction", UUID.randomUUID().toString());
        this. phoneNumber = phoneNumber;
    }
}
