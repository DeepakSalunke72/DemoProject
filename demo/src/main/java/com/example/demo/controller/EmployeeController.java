package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ModelMapper modelMapper;

	//get all employee
//	@GetMapping("/employee")
//	public List<Employee> listOfEmployee(){
//		return employeeService.getEmployees();
//}	
	
	//Get all employee by DTO logic
	@GetMapping("/employee")
	public List<EmployeeDto> getAllEmployee() {
		return employeeService.getEmployees();
	}
	
//	//get employee by id
//	@GetMapping("/employee/{employeeId}")
//	public ResponseEntity<Employee> getDepartmentById(@PathVariable long employeeId){
//		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
//	}
	
	//get employee by id by DTO logic
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<EmployeeDto> getPostById(@PathVariable Long employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);

		// convert entity to DTO
		EmployeeDto employeeResponse = modelMapper.map(employee, EmployeeDto.class);

		return ResponseEntity.ok().body(employeeResponse);
	}
	
//	//add employee
//	@PostMapping("/employee")
//	public Employee addDepartment(@RequestBody Employee employee) {
//		return employeeService.addEmployee(employee);
//	}

}

