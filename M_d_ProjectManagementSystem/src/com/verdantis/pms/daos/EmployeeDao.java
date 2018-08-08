package com.verdantis.pms.daos;

import java.util.List;

import com.verdantis.pms.entities.Employee;
import com.verdantis.pms.entities.Project;
import com.verdantis.pms.entities.Task;
import com.verdantis.pms.entities.UserLogin;
import com.verdantis.pms.exceptions.PmsException;

public interface EmployeeDao {

	String getRole(int userId, String password) throws PmsException;
	
	public Employee getEmployeeDetails(int employeeId) throws PmsException;

	void changeTaskStatus(int taskId, String status) throws PmsException;

	List<Task> getEmployeeTasks(int employeeId, int projectId) throws PmsException;

	int getMaxUserId() throws PmsException;

	void setEmployee(UserLogin userLogin, Employee employee) throws PmsException;

	List<Employee> getTeamOfEmployees(int managerId, int projectId) throws PmsException;

	void changeProjectStatus(int projectId, String status) throws PmsException;

	List<Task> getProjectTasks(int projectId) throws PmsException;

	Project getProjectDetails(int projectId) throws PmsException;

	@SuppressWarnings("rawtypes")
	List getWorkLoad(int employeeId) throws PmsException;

	void setTask(Task task) throws PmsException;

	int getMaxTaskId() throws PmsException;

	List<Employee> getAllEmployees() throws PmsException;

	List<Employee> getAllManagers() throws PmsException;

	int getMaxProjectId() throws PmsException;

	void createProject(Project project, int manager, String[] employees) throws PmsException;

	String checkDuplicate(String email) throws PmsException;

	Object checkDuplicateProject(String projectName) throws PmsException;
	
}
