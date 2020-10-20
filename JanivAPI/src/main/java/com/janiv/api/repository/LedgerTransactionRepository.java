package com.janiv.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.janiv.api.model.LedgerTransaction;
import com.janiv.api.model.User;

public interface LedgerTransactionRepository extends CrudRepository<LedgerTransaction, Integer>{
	
	//rrr
	List<LedgerTransaction> findByLedgertypeid(int ledgerType);


}
