package com.janiv.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ledgertransaction", schema = "public")
public class LedgerTransaction {
	
	 
	public enum PayType {CASH(0), ONLINE(1), CHEQUE(2);
	
		@SuppressWarnings("unused")
		private int paytype;
	
		private PayType(int value) {
			this.paytype = value;
		}	
	}	
	
	public enum LedgerType {DEBIT(0), CREDIT(1);
		
		@SuppressWarnings("unused")
		private int value;
	
		private LedgerType(int value) {
			this.value = value;
		}	
	}
			
	// Defining mobilenumber as primary key                
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trans_generator")
	//@SequenceGenerator(name = "trans_generator", sequenceName = "trans_seq", allocationSize = 100, initialValue = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionid;

	@Column
	private LedgerType ledgertypeid;
	
	@JoinColumn(name="ledgermasterid")
	@ManyToOne
	private LedgerMaster ledgermasterid;
	
	@JoinColumn(name="projectid")
	@ManyToOne
	private Project project;
	
	@Column
	private Date date;
	
	@Column
	private String description;
	
	@Column
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User userid;
	
	@Column
	private PayType paytype;	
	
	@Column
	private String chequeno;
	
	@Column
	private String paidby;
	
	@Column
	private String receiptnumber;
	
	@Column
	private String recipientname;
	
	public LedgerTransaction(int transactionid, LedgerType ledgeryypeid,  LedgerMaster ledgermasters, Date date,
			String description, Double amount,User userid1,  PayType paytype, String chequeno, String paidby,
			String receiptnumber, String recipientname) {
		super();
		this.transactionid = transactionid;
		this.ledgertypeid = ledgeryypeid;				
		this.date = date;
		this.description = description;
		this.amount = amount;	
		this.paytype = paytype;
		this.chequeno = chequeno;
		this.paidby = paidby;
		this.receiptnumber = receiptnumber;
		this.recipientname = recipientname;
		this.ledgermasterid=ledgermasters;
		this.userid=userid1;
	}


	
	

	public LedgerTransaction() {
		// TODO Auto-generated constructor stub
	}


	public long getTransactionid() {
		return transactionid;
	}


	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}


	public LedgerType getLedgertypeid() {
		return ledgertypeid;
	}


	public void setLedgertypeid(LedgerType ledgeryypeid) {
		this.ledgertypeid = ledgeryypeid;
	}

	public Project getProject() {
		return project;
	}


	public void setProject(Project projectid) {
		this.project = projectid;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public User getUser() {
		return userid;
	}


	public void setUser(User contactid) {
		this.userid = contactid;
	}


	public PayType getPaytype() {
		return paytype;
	}


	public void setPaytype(PayType paytype) {
		this.paytype = paytype;
	}


	public String getChequeno() {
		return chequeno;
	}


	public void setChequeno(String chequeno) {
		this.chequeno = chequeno;
	}


	public String getPaidby() {
		return paidby;
	}


	public void setPaidby(String paidby) {
		this.paidby = paidby;
	}


	public String getReceiptnumber() {
		return receiptnumber;
	}


	public void setReceiptnumber(String receiptnumber) {
		this.receiptnumber = receiptnumber;
	}


	public String getRecipientname() {
		return recipientname;
	}


	public void setRecipientname(String recipientname) {
		this.recipientname = recipientname;
	}
	
	public LedgerMaster getLedgermaster() {
		return ledgermasterid;
	}

	 
	public void setLedgermaster(LedgerMaster ledgermasterid) {
		this.ledgermasterid = ledgermasterid;
	}
	
}
