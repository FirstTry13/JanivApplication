package com.janiv.api.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.janiv.api.mapper.LedgerTransactionMapper;
import com.janiv.api.model.LedgerMaster;
import com.janiv.api.model.LedgerTransaction;
import com.janiv.api.model.LedgerTransaction.LedgerType;
import com.janiv.api.model.Project;
import com.janiv.api.model.User;
import com.janiv.api.service.LedgerMasterService;
import com.janiv.api.service.LedgerTransactionService;
import com.janiv.api.service.ProjectService;
import com.janiv.api.service.UsersService;

@RestController
@RequestMapping(value= "/api/ledger/transaction")
public class LedgerTransactionController {

	@Autowired
	LedgerTransactionService  transService;

	@Autowired
	LedgerMasterService  masterService;
	
	@Autowired
	ProjectService projService;
	
	@Autowired
	UsersService userService;
		
	
	private  LedgerTransactionMapper mapper;
	

	@RequestMapping(value = "/ledgertype/{ledgertypeid}", method = RequestMethod.GET)
	public List<LedgerTransaction> getLedgerTransactionByLedgerType(@PathVariable("ledgertypeid") String ledgertypeid  ) {

		LedgerType ltype;
		if (ledgertypeid.trim().equals("1"))
			ltype=LedgerType.CREDIT;
		else
			ltype=LedgerType.DEBIT;
		return transService.getTransactionByLedgerType(ltype);

	}

	@RequestMapping(value = "/{transactionid}", method = RequestMethod.GET)
	public LedgerTransaction getTransactionById(@PathVariable(value = "transactionid") Long transactionid) {
	
		return transService.getTransactionById(transactionid);
	}

	@RequestMapping(value = "/ledgermaster/{ledgermasterid}", method = RequestMethod.GET)
	public List<LedgerTransaction> getTransactionByLedgermaster(@PathVariable(value = "ledgermasterid") Integer ledgermasterid) 
	{
		List<LedgerTransaction> ltrans = new ArrayList<LedgerTransaction>();
		LedgerMaster lmaster =masterService.getLedgerMasterById(ledgermasterid);

		if (lmaster!=null)
		{
			ltrans=transService.getTransactionByLedgerMaster(lmaster);
		}

		return ltrans;
	}
	
	@RequestMapping(value = "/project/{projectid}", method = RequestMethod.GET)
	public List<LedgerTransaction> getTransactionByProject(@PathVariable(value = "projectid") Integer projectid) 
	{
		List<LedgerTransaction> ltrans = new ArrayList<LedgerTransaction>();
		Project proj =projService.getProjectById(projectid);

		if (proj!=null)
		{
			ltrans=transService.getTransactionByProject(proj);
		}

		return ltrans;
	}
	
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
	public List<LedgerTransaction> getTransactionByUser(@PathVariable(value = "userid") Long userid) 
	{
		List<LedgerTransaction> ltrans = new ArrayList<LedgerTransaction>();
		User user =userService.getUserById(userid);

		if (user!=null)
		{
			ltrans=transService.getTransactionByUser(user);
		}

		return ltrans;
	}
	
	@RequestMapping(value = "/date/{fromDate}/{toDate}", method = RequestMethod.GET)
	public List<LedgerTransaction> getTransactionBetweenDate(@PathVariable(value = "fromDate") @DateTimeFormat(pattern = "yyyy-mm-dd")String fromDate,
			@PathVariable(value = "toDate")  @DateTimeFormat(pattern = "yyyy-mm-dd") String toDate) 
	{
		List<LedgerTransaction> ltrans = new ArrayList<LedgerTransaction>();
		
		 SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-mm-dd"); 
		 Date fromdate = null;
		 Date todate=null;
	
		 fromdate = Date.valueOf(fromDate) ;
		 todate=Date.valueOf(toDate) ;
		 	 		
		ltrans=transService.getTransactionBetweenDates(fromdate, todate);
		
		return ltrans;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addupdateLedgerTransaction(@RequestBody LedgerTransaction trans)
	{
		LedgerTransaction result=transService.addLedgerTransaction(trans);
		if (result !=null)
			return new ResponseEntity<>("Transaction is added/updated successsfully.", HttpStatus.OK);
		else
			return new ResponseEntity<>("Failed to add Transaction.", HttpStatus.FORBIDDEN);
		
	}
	
	/*@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<String> updateLedgerTransaction(@RequestBody LedgerTransaction trans)
	{
		LedgerTransaction dbtrans=null;
		LedgerTransaction result=null;
		if (trans.getTransactionid()!=0)
		{
			 dbtrans=getTransactionById(trans.getTransactionid());
			
			mapper.updateLedgerTransactionFromDto(trans, dbtrans);
			
		}		
		if (dbtrans!=null)
			result=transService.addLedgerTransaction(dbtrans);
		if (result !=null)
			return new ResponseEntity<>("Transaction is updated successsfully.", HttpStatus.OK);
		else
			return new ResponseEntity<>("Failed to updated Transaction.", HttpStatus.FORBIDDEN);
		
	}
	*/
	@RequestMapping(value = "/projectbalance/{projectid}", method = RequestMethod.GET)
	public double getAvalibleBalanceByProject(@PathVariable(value = "projectid") int projectid)
	{
		List<LedgerTransaction> alltrans = getTransactionByProject(projectid);
		
		List creditlst = alltrans.stream().filter(s->s.getLedgertypeid()==LedgerType.CREDIT).collect(Collectors.toList());
		List debitlst = alltrans.stream().filter(s->s.getLedgertypeid()==LedgerType.DEBIT).collect(Collectors.toList());
		
		Double creditAmts  = (Double) creditlst.stream().reduce(0,(ans , s)-> Double.sum((double)ans, (double)((LedgerTransaction) s).getAmount() ) );
		Double debitAmts  = (Double) debitlst.stream().reduce(0,(ans , s)-> Double.sum((double)ans, (double)((LedgerTransaction) s).getAmount() ) );
		
		
		return (creditAmts-debitAmts);
	}
}
