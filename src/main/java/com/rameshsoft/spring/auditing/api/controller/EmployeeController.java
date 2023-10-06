package com.rameshsoft.spring.auditing.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rameshsoft.spring.auditing.api.dto.InputRequest;
import com.rameshsoft.spring.auditing.api.model.Employee;
import com.rameshsoft.spring.auditing.api.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody InputRequest<Employee> request) {   //Generic input request
		return service.saveEmployee(request);
	}
	@PutMapping("/updateEmlpoyee/{id}/{salary}")
	public String updateEmployeeSalary(@PathVariable int id, @PathVariable Double salary, @RequestBody InputRequest<Employee> request) {
		return service.updateEmployee(id, salary, request);
	}
}




