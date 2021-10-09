package com.ironhack.miniproject.transactionservice;

import com.ironhack.miniproject.transactionservice.dto.ThirdPartyTransactionReceipt;
import com.ironhack.miniproject.transactionservice.dto.ThirdPartyTransactionRequest;
import com.ironhack.miniproject.transactionservice.dto.TransactionReceipt;
import com.ironhack.miniproject.transactionservice.dto.TransactionRequest;
import com.ironhack.miniproject.transactionservice.repository.ThirdPartyTransactionRepository;
import com.ironhack.miniproject.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ThirdPartyTransactionRepository thirdPartyTransactionRepository;

    public ThirdPartyTransactionReceipt transferMoney(int hashedKey, ThirdPartyTransactionRequest transactionRequest) {
    }

    public TransactionReceipt transferMoney(TransactionRequest transactionRequest) {
    }
}
