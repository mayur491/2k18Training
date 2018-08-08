package com.verdantis.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.verdantis.pms.entities.Employee;
import com.verdantis.pms.entities.Task;
import com.verdantis.pms.exceptions.PmsException;
import com.verdantis.pms.services.EmployeeService;

@RestController
public class PmsRestController {

	@Autowired
	private EmployeeService service;

	// url :
	// http://localhost:8080/M_d_ProjectManagementSystem/getEmployeeTasks.do?userId=3000&projectId=1
	/*
	 * Every Employee has a specific set of Tasks to be done by him/ her. This
	 * method returns all the tasks for a specific Employee in JSON Format.
	 */
	@RequestMapping(value = "/getEmployeeTasks", method = RequestMethod.GET)
	public ResponseEntity<List<Task>> getEmployeeTasks(@RequestParam(value = "userId") int userId,
			@RequestParam(value = "projectId") Integer projectId) throws PmsException {
		List<Task> tasks = (List<Task>) service.getEmployeeTasks(userId, projectId);
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}

	// url :
	// http://localhost:8080/M_d_ProjectManagementSystem/getTeamOfEmployees.do?managerId=3003&projectId=1
	/*
	 * Every Manager has a specific set of Employees under him. This method gets
	 * all the Employees for a specific Manager in JSON Format.
	 */
	@RequestMapping(value = "/getTeamOfEmployees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getTeamOfEmployees(@RequestParam(value = "managerId") int managerId,
			@RequestParam(value = "projectId") Integer projectId) throws PmsException {
		List<Employee> employees = (List<Employee>) service.getTeamOfEmployees(managerId, projectId);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

}
