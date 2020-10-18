package com.janiv.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country", schema = "public")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int countryid;
	
	@Column
	private String name;

	public int getCountryid() {
		return countryid;
	}

	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country(int countryid, String name) {
		super();
		this.countryid = countryid;
		this.name = name;
	}
	
	public Country()
	{
		
	}
	
	
}
