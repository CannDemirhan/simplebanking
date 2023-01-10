package com.eteration.simplebanking.model;


// This class is a placeholder you can change the complete implementation

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String owner;
    private String accountNumber;
    @Setter
    private Double balance;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private List<Transaction> transactions = new ArrayList<>();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createDate;

    public Account(String owner, String accountNumber){
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.createDate = new Date(System.currentTimeMillis());
    }

    public void post(Transaction transaction) throws InsufficientBalanceException {
        transaction.setAccount(this);
        if("DepositTransaction".equals(transaction.getType())){
            credit(transaction.getAmount());
        }else if("WithdrawalTransaction".equals(transaction.getType())){
            debit(transaction.getAmount());
        }else{
            transaction.doTransaction();
        }
        getTransactions().add(transaction);
    }
    public void credit(Double amount){
        setBalance(getBalance() + amount);
    }
    public void debit(Double amount) throws InsufficientBalanceException {
        if(getBalance() < amount){
            throw new InsufficientBalanceException();
        }
        setBalance(getBalance() - amount);
    }
    public void deposit(int amount){
        setBalance(getBalance() + amount);
    }
    public void withdraw(int amount) throws InsufficientBalanceException {
        if(getBalance() < amount){
            throw new InsufficientBalanceException();
        }
        setBalance(getBalance() - amount);
    }
}
