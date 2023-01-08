package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/v1/")
@RequiredArgsConstructor
public class TransactionController {

    private TransactionService transactionService;

    @PostMapping
    public void createDepositTransaction(@RequestBody DepositTransaction depositTransaction) {
        transactionService.createDepositTransaction(depositTransaction);
    }

}