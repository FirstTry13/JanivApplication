package com.janiv.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janiv.api.model.LedgerTransaction;
import com.janiv.api.repository.LedgerTransactionRepository;

@Service
public class LedgerTransactionService {
	
	@Autowired
	private LedgerTransactionRepository trans;
	

	public List<LedgerTransaction> getTransactionByLedgerType(int ledgertype)
	{
		return trans.findByLedgertypeid(ledgertype);
	}
	

}
