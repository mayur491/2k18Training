package com.verdantis.pms.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ManagerEmployeeRelation")
@Table(name = "M_D_MANAGER_EMPLOYEE_RELATION")
public class ManagerEmployeeRelation implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MANAGER_ID")
	private int managerId;

	@Id
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;

	public ManagerEmployeeRelation() {
		super();
	}

	public ManagerEmployeeRelation(int managerId, int employeeId) {
		super();
		this.managerId = managerId;
		this.employeeId = employeeId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "ManagerEmployeeRelation [managerId=" + managerId + ", employeeId=" + employeeId + "]";
	}

}
