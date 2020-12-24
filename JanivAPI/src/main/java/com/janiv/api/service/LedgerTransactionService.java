package com.janiv.api.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.janiv.api.mapper.LedgerTransactionMapper;
import com.janiv.api.model.LedgerMaster;
import com.janiv.api.model.LedgerTransaction;
import com.janiv.api.model.Project;
import com.janiv.api.model.User;
import com.janiv.api.model.LedgerTransaction.LedgerType;
import com.janiv.api.repository.LedgerTransactionRepository;

@Service
public class LedgerTransactionService {
	
	@Autowired
	private LedgerTransactionRepository transRepo;
	
	
	public LedgerTransaction getTransactionById(Long Id)
	{
		Optional<LedgerTransaction> ltrans= transRepo.findById(Id);
		if(ltrans.isPresent())
			return ltrans.get();
		else
			return null;
	}

	
	public List<LedgerTransaction> getTransactionByLedgerType(LedgerType ledgertype)
	{
		return transRepo.findByLedgertypeid(ledgertype);
	}
	
	public List<LedgerTransaction> getTransactionByProjectAndLedgerType(Project  proj, LedgerType ledgertype)
	{
		return transRepo.findByLedgertypeid(ledgertype);
	}
	
	public List<LedgerTransaction> getTransactionByLedgerMaster(LedgerMaster master)
	{
		return transRepo.findByledgermasterid(master);
	}

	public List<LedgerTransaction> getTransactionBetweenDates(Date from, Date to)
	{
		return transRepo.findBydateBetween(from, to);
	}
	
	public List<LedgerTransaction> getTransactionByUser(User  user)
	{
		return transRepo.findByuserid(user);
	}
	
	public List<LedgerTransaction> getTransactionByProject(Project  proj)
	{
		return transRepo.findByproject(proj);
	}
	
	
	public LedgerTransaction addLedgerTransaction(LedgerTransaction trans)
	{
		
		LedgerTransaction result=transRepo.save(trans);
		
		return result;
	}
		
	public List<LedgerTransaction> getAvalibleBalanceByProject(Project  proj)
	{
		return transRepo.findByproject(proj);
	}
	
}
