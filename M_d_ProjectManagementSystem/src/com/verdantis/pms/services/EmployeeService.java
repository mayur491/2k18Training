package com.verdantis.pms.services;

import java.util.List;
import java.util.Set;

import com.verdantis.pms.entities.Employee;
import com.verdantis.pms.entities.Project;
import com.verdantis.pms.entities.Task;
import com.verdantis.pms.entities.UserLogin;
import com.verdantis.pms.exceptions.PmsException;

public interface EmployeeService {

	String validateLogin(int userId, String password) throws PmsException;
	
	Employee getEmployeeDetails(int userId) throws PmsException;

	Set<Project> getProjects(int userId) throws PmsException;

	String changeTaskStatus(int taskId, String status) throws PmsException;
	
	List<Task> getEmployeeTasks(int userId, int projectId) throws PmsException;
	
	int setUserDetails(UserLogin userLogin, Employee employee) throws PmsException;

	List<Employee> getTeamOfEmployees(int managerId, Integer projectId) throws PmsException;

	boolean changeProjectStatus(int projectId, String status) throws PmsException;

	int setTask(Task task) throws PmsException;

	Project getProjectDetails(int projectId) throws PmsException;

	List<Employee> getAllEmployees() throws PmsException;

	List<Employee> getAllManagers() throws PmsException;

	void createProject(Project project, int manager, String[] employees) throws PmsException;

	int getWorkload(int userId) throws PmsException;

	boolean checkDuplicate(String email) throws PmsException;

	boolean checkDuplicateProject(String projectName) throws PmsException;

}
