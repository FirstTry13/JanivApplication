package com.janiv.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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

	public User(Long mobilenumber, String firstname, String lastname, 
		String comment, String password, Role role) {
		
		this.role = role;
		this.mobilenumber = mobilenumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.comment = comment;
		this.password = password;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role  role) {
		this.role = role;
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

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the othercontactno
	 */
	public String getOthercontactno() {
		return othercontactno;
	}

	/**
	 * @param othercontactno the othercontactno to set
	 */
	public void setOthercontactno(String othercontactno) {
		this.othercontactno = othercontactno;
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
		this.comment = comment;
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
