package com.ironhack.miniproject.transactionservice.dto;

import com.ironhack.miniproject.transactionservice.dao.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    private String authenticatedName;
    @NotBlank
    private String fromAccountId;
    @NotBlank
    private String toAccountId;
    @NotBlank
    private String toOwnerName;
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "balance_amount"))
    })
    @Valid
    @NotNull
    private Money transfer;
}
