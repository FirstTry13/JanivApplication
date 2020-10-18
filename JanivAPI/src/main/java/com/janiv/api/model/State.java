package com.janiv.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "state", schema = "public")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int stateid;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name="countryid")
	private Country countryid;

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return countryid;
	}

	public void setCountry(Country countryid) {
		this.countryid = countryid;
	}

	public State(int stateid, String name, Country countryid) {
		super();
		this.stateid = stateid;
		this.name = name;
		this.countryid = countryid;
	}

	
	public State()
	{
		
	}
	
	
}
