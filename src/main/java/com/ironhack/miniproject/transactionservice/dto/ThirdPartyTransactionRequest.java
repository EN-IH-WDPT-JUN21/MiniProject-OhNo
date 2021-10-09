package com.ironhack.miniproject.transactionservice.dto;

import com.ironhack.miniproject.transactionservice.ThirdPartyTransactionType;
import com.ironhack.miniproject.transactionservice.dao.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThirdPartyTransactionRequest {
    @NotNull
    @Enumerated(EnumType.STRING)
    ThirdPartyTransactionType transactionType;
    @NotBlank
    private String toAccountId;
    @NotNull
    private String secretKey;
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "balance_amount"))
    })
    @Valid
    @NotNull
    private Money transfer;
}
