package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DepartmentService;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private ModelMapper modelMapper;

//	//get list of department
//	@GetMapping("/department")
//	public List<Department> listOfDepartment(){
//		return departmentService.getDepartments();	
//	}
	
	//get list of department by DTO logic
	@GetMapping("/department")
	public List<DepartmentDto> listOfDepartment(){
		return departmentService.getDepartments().stream()
				.map(department-> modelMapper.map(department, DepartmentDto.class))
				.collect(Collectors.toList());
	}

//	//add department
//	@PostMapping("/department")
//	public Department addDepartment(@RequestBody Department department) {
//		return departmentService.addDepartment(department);	
//	}
	
	//add department by DTO logic 
	@PostMapping("/department")
	public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
	
		//Convert DTO to entity
		Department deptRequest = modelMapper.map(departmentDto, Department.class);
		
		Department department=departmentService.addDepartment(deptRequest);
		
		//Convert entity to DTO
		DepartmentDto deptResponce=modelMapper.map(department, DepartmentDto.class);

		return new ResponseEntity<DepartmentDto>(deptResponce,HttpStatus.CREATED);
		}

//	//update department
//	@PutMapping("/department")
//	public Department updateDepartment(@RequestBody Department department) {
//		return departmentService.updateDepartment(department);
//	}

	//update department by DTO logic 
		@PutMapping("/department")
		public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto) {
		
			//Convert DTO to entity
			Department deptRequest = modelMapper.map(departmentDto, Department.class);
		
			Department department=departmentService.updateDepartment(deptRequest);
			
			//Convert entity to DTO
			DepartmentDto deptResponce=modelMapper.map(department, DepartmentDto.class);
		
			return ResponseEntity.ok().body(deptResponce);
		}
		
//	//get department by id
//	@GetMapping("/department/{deptId}")
//	public ResponseEntity<Department> getDepartmentById(@PathVariable long deptId){
//		return new ResponseEntity<Department>(departmentService.getDepartmentById(deptId), HttpStatus.OK);
//	}
	
	//get department by id by DTO logic 
	@GetMapping("/department/{deptId}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable long deptId){
		Department department=departmentService.getDepartmentById(deptId);
		
		// convert entity to DTO
		DepartmentDto departmentDto=modelMapper.map(department, DepartmentDto.class);
		return ResponseEntity.ok(departmentDto);
	}
}
