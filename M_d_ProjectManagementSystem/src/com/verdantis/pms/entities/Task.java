package com.verdantis.pms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Task")
@Table(name = "M_D_TASK")
public class Task {

	@Id
	@Column(name = "TASK_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "INSTRUCTIONS")
	private String instructions;

	@Column(name = "ESTIMATED_HOURS")
	private int estimatedHours;

	@Column(name = "STATUS")
	private String status;

	/*
	 * ManyToOne Task to Employee
	 */
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;

	public Task(String name, String instructions, int estimatedHours, Employee employee,
			Project project) {
		super();
		this.name = name;
		this.instructions = instructions;
		this.estimatedHours = estimatedHours;
		this.employee = employee;
		this.project = project;
	}

	/*
	 * ManyToOne Task to Project
	 */
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

	public Task() {
		super();
	}

	public Task(int id, String name, String instructions, int estimatedHours, String status) {
		super();
		this.id = id;
		this.name = name;
		this.instructions = instructions;
		this.estimatedHours = estimatedHours;
		this.status = status;
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

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public int getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	/*
	 * Project
	 */
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", instructions=" + instructions + ", estimatedHours="
				+ estimatedHours + ", status=" + status + "]";
	}
}
