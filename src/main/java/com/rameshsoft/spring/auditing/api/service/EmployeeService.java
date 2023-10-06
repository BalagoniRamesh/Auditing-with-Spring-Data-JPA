package com.rameshsoft.spring.auditing.api.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rameshsoft.spring.auditing.api.dao.EmployeeRepository;
import com.rameshsoft.spring.auditing.api.dto.InputRequest;
import com.rameshsoft.spring.auditing.api.model.Employee;



@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public String saveEmployee(InputRequest<Employee> request) { // get employee object from the repository by giving the id																	 
		String currentUser = request.getLoggedInUser();
		request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
		Employee employee = request.getEmployee();
		employee.setCreatedBy(currentUser);
		repository.save(employee);
		return "Employee saved successfully.."; // return dummy value
	}

	public String updateEmployee(int id, double salary, InputRequest<Employee> request) { // In entity update salary field, based on id																							
		Employee employee = repository.findById(id).get(); // get employee object from repository by id
		if (employee != null) {
			employee.setSalary(salary);
			employee.setModifiedBy(request.getLoggedInUser());
			repository.saveAndFlush(employee); // save
		} else {
			throw new RuntimeException("Employee not found with id: " + id);

		}
		return "Employee updated successfully ";
	}
}
