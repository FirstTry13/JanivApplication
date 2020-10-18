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
@Table(name = "district", schema = "public")
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int districtid;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name="stateid")
	private State stateid;

	public int getDistrictid() {
		return districtid;
	}

	public void setDistrictid(int districtid) {
		this.districtid = districtid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getStateid() {
		return stateid;
	}

	public void setStateid(State stateid) {
		this.stateid = stateid;
	}

	public District(int districtid, String name, State stateid) {
		super();
		this.districtid = districtid;
		this.name = name;
		this.stateid = stateid;
	}

	public District()
	{
		
	}
		
	
	
}
