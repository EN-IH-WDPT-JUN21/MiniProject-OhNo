package com.ironhack.miniproject.transactionservice.dto;

import com.ironhack.miniproject.transactionservice.ThirdPartyTransactionType;
import com.ironhack.miniproject.transactionservice.dao.Money;
import com.ironhack.miniproject.transactionservice.dao.ThirdPartyTransaction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

// Class to provide feedback when doing a ThirdPartyTransaction
public class ThirdPartyTransactionReceipt {
    private Long id;
    private Money transfer;
    private String thirdPartyName;
    private String toAccountId;
    private ThirdPartyTransactionType transactionType;

    public ThirdPartyTransactionReceipt(ThirdPartyTransaction transaction) {
        if (transaction.getThirdParty() != null) {
            setId(transaction.getId());
            setTransfer(transaction.getTransfer());
            setThirdPartyName(transaction.getThirdParty().getName());
            setToAccountId(transaction.getToAccount().getId());
            setTransactionType(transaction.getTransactionType());
        }
    }
}
