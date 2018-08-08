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
import javax.persistence.Table;

@Entity(name = "Project")
@Table(name = "M_D_PROJECT")
public class Project {

	@Id
	@Column(name = "PROJECT_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "STATUS")
	private String status;

	/*
	 * ManyToMany Project to Employee
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "M_D_EMPLOYEE_PROJECT_RELATION",
		joinColumns = { @JoinColumn(name = "PROJECT_ID") },
		inverseJoinColumns = {@JoinColumn(name = "EMPLOYEE_ID") })
	private Set<Employee> employees;
	
	/*
	 * OneToMany Project to Task
	 */
	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
	private Set<Task> tasks;

	public Project() {
		super();
	}

	public Project(int id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public Project(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * Tasks
	 */
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	/*
	 * Employee
	 */
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", status=" + status + "]";
	}

}
