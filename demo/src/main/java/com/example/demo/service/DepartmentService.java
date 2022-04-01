package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;

public interface DepartmentService {

	public List<Department> getDepartments();

	public Department addDepartment(Department department);
	
	public Department updateDepartment(Department department);

	public Department getDepartmentById(long deptId);
	
	
}
