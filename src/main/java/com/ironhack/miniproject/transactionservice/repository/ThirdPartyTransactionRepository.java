package com.ironhack.miniproject.transactionservice.repository;

import com.ironhack.miniproject.transactionservice.dao.ThirdPartyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyTransactionRepository extends JpaRepository<ThirdPartyTransaction, Long> {
}
