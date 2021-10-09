package com.ironhack.miniproject.transactionservice;

import com.ironhack.miniproject.transactionservice.dao.ThirdPartyTransaction;
import com.ironhack.miniproject.transactionservice.dao.Transaction;
import com.ironhack.miniproject.transactionservice.dto.ThirdPartyTransactionReceipt;
import com.ironhack.miniproject.transactionservice.dto.ThirdPartyTransactionRequest;
import com.ironhack.miniproject.transactionservice.dto.TransactionReceipt;
import com.ironhack.miniproject.transactionservice.dto.TransactionRequest;
import com.ironhack.miniproject.transactionservice.repository.ThirdPartyTransactionRepository;
import com.ironhack.miniproject.transactionservice.repository.TransactionRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class TransactionController {

    @Autowired
    ThirdPartyTransactionRepository thirdPartyTransactionRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionService transactionService;

    // Method to allow a AccountHolder to do a transaction from one of its Accounts
    @PostMapping(path = "/transfer")
    @ResponseStatus(HttpStatus.OK)
    public TransactionReceipt transferToAccountByOwnerAndId(@RequestBody @Valid TransactionRequest transactionRequest) {
        return transactionService.transferMoney(transactionRequest);
    }

    // Method to allow a ThirdParty to do a transaction with an account
    @PostMapping(path = "/transfer/{key}")
    @ResponseStatus(HttpStatus.OK)
    public ThirdPartyTransactionReceipt transferThirdParty(@PathVariable("key") int hashedKey, @RequestBody @Valid ThirdPartyTransactionRequest transactionRequest) {
        return transactionService.transferMoney(hashedKey, transactionRequest);
    }

    @GetMapping(path = "/transfer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionReceipt getTransactionById(@PathVariable("id") Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return new TransactionReceipt(transaction.get());
    }

    @GetMapping(path = "/third-party-transfer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ThirdPartyTransactionReceipt getThirdPartyTransactionById(@PathVariable("id") Long id) {
        Optional<ThirdPartyTransaction> transaction = thirdPartyTransactionRepository.findById(id);
        return new ThirdPartyTransactionReceipt(transaction.get());
    }
}
