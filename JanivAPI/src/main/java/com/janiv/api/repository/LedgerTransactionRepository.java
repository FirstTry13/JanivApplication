package com.janiv.api.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.janiv.api.model.LedgerMaster;
import com.janiv.api.model.LedgerTransaction;
import com.janiv.api.model.LedgerTransaction.LedgerType;
import com.janiv.api.model.Project;
import com.janiv.api.model.User;

public interface LedgerTransactionRepository extends JpaRepository<LedgerTransaction, Long>{
	
	//rrr
	List<LedgerTransaction> findByLedgertypeid(LedgerType ledgerType);
	 
	List<LedgerTransaction> findByledgermasterid(LedgerMaster  master);
	
	List<LedgerTransaction> findBydateBetween(Date from, Date to);
	
	List<LedgerTransaction> findByuserid(User  user);
	
	List<LedgerTransaction> findByproject(Project  proj);
	
	List<LedgerTransaction> findByprojectAndLedgertypeid(Project  proj, LedgerType ledgerType);
	
}
