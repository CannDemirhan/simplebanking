package com.eteration.simplebanking.services;


import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.repository.IAccountRepository;
import org.springframework.stereotype.Service;

// This class is a placeholder you can change the complete implementation

@Service
public class AccountService {

    private final IAccountRepository accountRepository;

    public AccountService(IAccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account findAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
            .orElseThrow(() -> new IllegalArgumentException("Account not found!"));
    }
    public Account save(Account account){
        return accountRepository.save(account);
    }
    public TransactionStatus credit(String accountNumber, DepositTransaction transaction) throws InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        account.post(transaction);
        accountRepository.save(account);
        return TransactionStatus.builder().status("OK").approvalCode(transaction.getApprovalCode()).build();
    }
    public TransactionStatus debit(String accountNumber, WithdrawalTransaction transaction) throws InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        account.post(transaction);
        accountRepository.save(account);
        return TransactionStatus.builder().status("OK").approvalCode(transaction.getApprovalCode()).build();
    }
}
