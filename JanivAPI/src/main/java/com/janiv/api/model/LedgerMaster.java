package com.janiv.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ledgermaster", schema = "public")
public class LedgerMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int ledgermasterid;
	
	@Column
	private String name;
	
	@Column
	private String descripation;
	

	public int getLedgermasterid() {
		return ledgermasterid;
	}

	public void setLedgermasterid(int ledgermasterid) {
		this.ledgermasterid = ledgermasterid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripation() {
		return descripation;
	}

	public void setDescripation(String descripation) {
		this.descripation = descripation;
	}
	
	public LedgerMaster(int ledgermasterid, String name, String descripation) {
		super();
		this.ledgermasterid = ledgermasterid;
		this.name = name;
		this.descripation = descripation;
	}
	
	
	
	
}
