package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;
import com.eteration.simplebanking.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// This class is a placeholder you can change the complete implementation
@RequestMapping("/account/v1")
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    @GetMapping(value = "/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable("accountNumber") String accountNumber) {

        return  ResponseEntity.ok(accountService.findAccount(accountNumber));
    }
    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable("accountNumber") String accountNumber,
                                                    @RequestBody DepositTransaction transaction) throws InsufficientBalanceException {

        Account account = accountService.findAccount(accountNumber);
        Transaction trx = new DepositTransaction(transaction.getAmount());
        account.post(trx);
        accountService.save(account);
        return ResponseEntity.ok(TransactionStatus.builder().status("OK").approvalCode(trx.getApprovalCode()).build());
        //return ResponseEntity.ok(accountService.credit(accountNumber,transaction));
    }
    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable("accountNumber") String accountNumber,
                                                   @RequestBody WithdrawalTransaction transaction) throws InsufficientBalanceException {

        Account account = accountService.findAccount(accountNumber);
        Transaction trx = new WithdrawalTransaction(transaction.getAmount());
        account.post(trx);
        accountService.save(account);
        return ResponseEntity.ok(TransactionStatus.builder().status("OK").approvalCode(trx.getApprovalCode()).build());
        //return ResponseEntity.ok(accountService.credit(accountNumber,transaction));
    }
}