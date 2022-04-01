package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Address;
import com.example.demo.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private long employeeId;
	
	private long deptId;
	
	private String name;
	
	private String designation;
	
	private double salary;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	private long addressId;
}
