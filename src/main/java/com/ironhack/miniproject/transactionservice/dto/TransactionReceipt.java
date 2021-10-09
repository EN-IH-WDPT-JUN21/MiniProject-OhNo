package com.ironhack.miniproject.transactionservice.dto;

import com.ironhack.miniproject.transactionservice.dao.Money;
import com.ironhack.miniproject.transactionservice.dao.Transaction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

// Class to provide feedback when doing a Transaction
public class TransactionReceipt {
    private Long transactionId;
    private Money finalBalance;
    private String fromAccountId;
    private String toAccountId;

    public TransactionReceipt(Transaction transaction) {
        setTransactionId(transaction.getId());
        setFinalBalance(transaction.getFromAccount().getBalance());
        setFromAccountId(transaction.getFromAccount().getId());
        setToAccountId(transaction.getToAccount().getId());
    }
}
