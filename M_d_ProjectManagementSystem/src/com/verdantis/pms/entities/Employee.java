package com.verdantis.pms.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Employee")
@Table(name = "M_D_EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "BANDWIDTH")
	private Integer bandwidth;

	/*
	 * OneToOne Employee to UserLogin
	 */
	@OneToOne
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "USER_ID")
	private UserLogin userLogin;

	/*
	 * ManyToMany Employee to Project
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "M_D_EMPLOYEE_PROJECT_RELATION",
		joinColumns = { @JoinColumn(name = "EMPLOYEE_ID") },
		inverseJoinColumns = { @JoinColumn(name = "PROJECT_ID") })
	private Set<Project> projects;
	
	/*
	 * OneToMany Employee to Tasks
	 */
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	private Set<Task> tasks;

	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String firstName, String lastName, String email, Integer bandwidth) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.bandwidth = bandwidth;
	}

	public Employee(String firstName, String lastName, String email, Integer bandwidth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.bandwidth = bandwidth;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(Integer bandwidth) {
		this.bandwidth = bandwidth;
	}

	/*
	 * UserLogin
	 */
	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	/*
	 * Task
	 */
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	/*
	 * Project
	 */
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", bandwidth=" + bandwidth + ", userLogin=" + userLogin + ", projects=" + projects
				+ ", tasks=" + tasks + "]";
	}

}
