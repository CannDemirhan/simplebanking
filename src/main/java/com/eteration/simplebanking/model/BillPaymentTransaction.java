package com.eteration.simplebanking.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;
@NoArgsConstructor
@Entity
public abstract class BillPaymentTransaction extends Transaction{

    private String payee;

    public BillPaymentTransaction(String payee, Double amount, String type, String approvalCode) {
        super(new Date(System.currentTimeMillis()), type, amount, approvalCode);
        this.payee = payee;
    }
}
