package com.janiv.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "public")
public class User {
	
	public enum Role {USER0(0), ADMIN(1), USER_MANAGER(2);
		
		@SuppressWarnings("unused")
		private int value;
	
		private Role(int value) {
			this.value = value;
		}	
	}	
	// Defining mobilenumber as primary key
	@Id
	@GeneratedValue
	private int userid;
	
	@Column
	private Long mobilenumber;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String othercontactno;
	@Column
	private String comment;
	@Column
	private String password;
	@Column
	private Role role;	
	@Column
	private String username;	
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
	private String alternateaddress;
	
	@ManyToOne
	@JoinColumn
	private Location alternatelocationid;
	
	@ManyToOne
	@JoinColumn
	private District alternatedistrictid;
	
	@ManyToOne
	@JoinColumn
	private State alternatestateid;
	
	@ManyToOne
	@JoinColumn
	private Country alternatecountryid;	
	
	@Column
	private Date birthdate;	
	@Column
	private String emailid1;	
	@Column
	private String emailid2;	
	@Column
	private String profession;	
	@Column
	private String companyname;	
	@Column
	private String designation;	
	@Column
	private Date deletedate;

	
	
	public User(int userid,Long mobilenumber, String firstname, String lastname, 
			String comment, String password, Role role, String userName, 
			String address, Location locationID, District districtID, State stateID, Country countryID ,
			String alternateAddress, Location alternateLocationID, District alternateDistrictID ,
			State alternateStateID, Country alternateCountryID, Date birthDate, String emailID1,
			String emailID2, String profession, String companyName,String designation, Date deleteDate) {
			
			this.userid=userid;
			this.role = role;
			this.mobilenumber = mobilenumber;
			this.firstname = firstname;
			this.lastname= lastname;
			this.comment = comment;
			this.password = password;
			this.username = userName;
			this.address = address;
			this.locationid= locationID;
			this.districtid = districtID;
			this.stateid = stateID;
			this.countryid = countryID;
			this.alternateaddress = alternateAddress;
			this.alternatelocationid = alternateLocationID;
			this.alternatedistrictid = alternateDistrictID;
			this.alternatestateid = alternateStateID;
			this.alternatecountryid = alternateCountryID;
			this.birthdate = birthDate;
			this.emailid1 = emailID1;
			this.emailid2 = emailID2;
			this.profession = profession;
			this.companyname = companyName;
			this.designation = designation;
			this.deletedate = deleteDate;
			
		
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		username = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Location getLocation() {
		return locationid;
	}

	public void setLocation(Location locationID) {
		locationid = locationID;
	}

	public District getDistrict() {
		return districtid;
	}

	public void setDistrict(District districtID) {
		districtid = districtID;
	}

	public State getState() {
		return stateid;
	}

	public void setState(State stateID) {
		stateid = stateID;
	}

	public Country getCountry() {
		return countryid;
	}

	public void setCountry(Country countryID) {
		countryid = countryID;
	}

	public String getAlternateaddress() {
		return alternateaddress;
	}

	public void setAlternateaddress(String alternateAddress) {
		this.alternateaddress = alternateAddress;
	}

	public Location getAlternatelocation() {
		return alternatelocationid;
	}

	public void setAlternatelocation(Location alternateLocationID) {
		alternatelocationid = alternateLocationID;
	}

	public District getAlternatedistrict() {
		return alternatedistrictid;
	}

	public void setAlternatedistrict(District alternateDistrictID) {
		alternatedistrictid = alternateDistrictID;
	}

	public State getAlternatestate() {
		return alternatestateid;
	}

	public void setAlternatestate(State alternateStateID) {
		alternatestateid = alternateStateID;
	}

	public Country getAlternatecountry() {
		return alternatecountryid;
	}

	public void setAlternatecountry(Country alternateCountryID) {
		alternatecountryid = alternateCountryID;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthDate) {
		birthdate = birthDate;
	}

	public String getEmailid1() {
		return emailid1;
	}

	public void setEmailid1(String emailID1) {
		emailid1= emailID1;
	}

	public String getEmailid2() {
		return emailid2;
	}

	public void setEmailid2(String emailID2) {
		emailid2= emailID2;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String proffession) {
		this.profession = proffession;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyName) {
		companyname = companyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(Date deleteDate) {
		deletedate = deleteDate;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstName) {
		firstname = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastName) {
		lastname = lastName;
	}

	public String getOthercontactno() {
		return othercontactno;
	}

	public void setOthercontactno(String otherContactNo) {
		othercontactno = otherContactNo;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int contactID) {
		userid = contactID;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role  role) {
		this.role = role;
	}
	
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment= comment;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
