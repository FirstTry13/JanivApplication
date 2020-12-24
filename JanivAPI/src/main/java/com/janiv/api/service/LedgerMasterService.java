package com.janiv.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janiv.api.model.LedgerMaster;
import com.janiv.api.model.LedgerTransaction;
import com.janiv.api.model.LedgerTransaction.LedgerType;
import com.janiv.api.repository.LedgerMasterRepository;
import com.janiv.api.repository.LedgerTransactionRepository;

@Service
public class LedgerMasterService {

	
	@Autowired
	private LedgerMasterRepository repo;
	

	public LedgerMaster getLedgerMasterById(Integer Id)
	{
		Optional<LedgerMaster> master= repo.findById(Id);
		if (master.isPresent())
			return master.get();
		else
			return null;
	}
	
	
}
