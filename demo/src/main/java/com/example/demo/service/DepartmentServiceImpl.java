package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.exception.ResourceNotFound;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartmentById(long deptId) {
		return departmentRepository.findById(deptId).orElseThrow(()-> new ResourceNotFound("deptId not exist with given id :"+deptId));
	}

}
