package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	public List<EmployeeDto> getEmployees();

	public Employee getEmployeeById(long employeeId);
	
	//public Employee addEmployee(Employee employee);
}
