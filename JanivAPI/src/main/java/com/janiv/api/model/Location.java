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
@Table(name = "location", schema = "public")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int locationid;
	
	@ManyToOne
	@JoinColumn
	private District district;
	
	@Column
	private String name;

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location(int locationid, District district, String name) {
		super();
		this.locationid = locationid;
		this.district = district;
		this.name = name;
	}
	
			
	
	
}
