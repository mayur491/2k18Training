package com.verdantis.pms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "UserLogin")
@Table(name = "M_D_USER_LOGIN")
public class UserLogin {

	@Id
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	private String role;
	
	/*
	 * OneToOne UserLogin to Employee
	 */
	@OneToOne(mappedBy = "userLogin")
	private Employee employee;
	
	public UserLogin() {
		super();
	}

	public UserLogin(int userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}

	public UserLogin(String password, String role) {
		super();
		this.password = password;
		this.role = role;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*
	 * Employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
}
