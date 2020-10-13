package com.janiv.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project", schema = "public")
public class Project {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int projectid;	
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@ManyToOne
	@JoinColumn
	private Location locationid;		
	
	@ManyToOne
	@JoinColumn
	private District districtid;		
	
	@ManyToOne
	@JoinColumn
	private State stateid;	
	
	@ManyToOne
	@JoinColumn
	private Country countryid;
	
	@Column
	private Date creatdate;	
	@Column
	private Date startdate;	
	@Column
	private Date enddate;	
	
	public Project(int projectid, String name, String address, Location locationid, District districtid, State stateid,
			Country countryid, Date creatdate, Date startdate, Date enddate) {
		super();
		this.projectid = projectid;
		this.name = name;
		this.address = address;
		this.locationid = locationid;
		this.districtid = districtid;
		this.stateid = stateid;
		this.countryid = countryid;
		this.creatdate = creatdate;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Location getLocationid() {
		return locationid;
	}
	public void setLocationid(Location locationid) {
		this.locationid = locationid;
	}
	public District getDistrictid() {
		return districtid;
	}
	public void setDistrictid(District districtid) {
		this.districtid = districtid;
	}
	public State getStateid() {
		return stateid;
	}
	public void setStateid(State stateid) {
		this.stateid = stateid;
	}
	public Country getCountryid() {
		return countryid;
	}
	public void setCountryid(Country countryid) {
		this.countryid = countryid;
	}
	public Date getCreatdate() {
		return creatdate;
	}
	public void setCreatdate(Date creatdate) {
		this.creatdate = creatdate;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	
	
	
	
}
