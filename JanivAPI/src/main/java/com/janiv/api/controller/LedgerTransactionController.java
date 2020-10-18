package com.janiv.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.janiv.api.model.LedgerTransaction;
import com.janiv.api.service.LedgerTransactionService;

@RestController
@RequestMapping(value= "/api/ledgertrans")
public class LedgerTransactionController {

	@Autowired
	LedgerTransactionService  transService;
	
	@GetMapping
	public List<LedgerTransaction> getLedgerTransactionByLedgerType( ) {
		
		//@RequestParam(name = "ledgertypeid") int ledgertype
		return transService.getTransactionByLedgerType(1);
				
	}
	
}
