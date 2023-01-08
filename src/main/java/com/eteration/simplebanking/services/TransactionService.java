package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.repository.ITransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final ITransactionRepository transactionRepository;

    public TransactionService(ITransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    public void createDepositTransaction(DepositTransaction depositTransaction) {
        transactionRepository.save(depositTransaction);
    }
}
