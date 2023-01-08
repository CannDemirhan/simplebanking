package com.eteration.simplebanking.controller;


import lombok.Builder;
import lombok.Getter;

// This class is a place holder you can change the complete implementation
@Getter
@Builder
public class TransactionStatus {

    private String status;
    private String approvalCode;
}
