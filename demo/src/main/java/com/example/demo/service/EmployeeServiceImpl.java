package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javafx.scene.DepthTest;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	 @Autowired
	 private ModelMapper modelMapper;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
//	@Override
//	public List<Employee> getEmployees() {	
//		return employeeRepository.findAll();
//	}

	@Override
	public List<EmployeeDto> getEmployees() {
		return employeeRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	//Convert entity to DTO
	 private EmployeeDto convertEntityToDto(Employee employee){
	        modelMapper.getConfiguration()
	                .setMatchingStrategy(MatchingStrategies.LOOSE);
	        EmployeeDto employeeDto = new EmployeeDto();
	        employeeDto = modelMapper.map(employee, EmployeeDto.class);
	        return employeeDto;
	    }
	
//	private EmployeeDto convertEntityToDto(Employee employee) {
//		EmployeeDto employeeDto=new EmployeeDto();
//		employeeDto.setEmployeeId(employee.getEmployeeId());
//		employeeDto.setDepartment(employee.getDepartment());
//		employeeDto.setName(employee.getName());
//		employeeDto.setDesignation(employee.getDesignation());
//		employeeDto.setSalary(employee.getSalary());
//		employeeDto.setCreatedAt(employee.getCreatedAt());
//		employeeDto.setUpdatedAt(employee.getUpdatedAt());	
//		employeeDto.setAddresses(employee.getAddress());
//		return employeeDto;
//	}

//	@Override
//	public Employee getEmployeeById(long employeeId) {
//		return employeeRepository.findById(employeeId)
//				.orElseThrow(()-> new ResourceNotFound("employeeId not exist with given id :"+ employeeId));
//	
//	}	
	
	@Override
	public Employee getEmployeeById(long employeeId) {
		Optional<Employee> result = employeeRepository.findById(employeeId);
		if(result.isPresent()) {
			return result.get();
		} else {
			throw new ResourceNotFound("employeeId not exist with given id :"+employeeId);
		}
	}
	
//	@Override
//	public Employee addEmployee(Employee employee) {
//		return employeeRepository.save(employee);
//	}
	
//	@Override
//	public EmployeeDto addEmployee(Employee employee) {
//		Employee emp=new Employee();
//		Department department=departmentRepository.findById(employee.getEmployeeId());
//		List<Address> list=addressRepository.findById(employee.getEmployeeId());
//		emp.setDepartment(department);
//		emp.setAddress(list);
//		return employeeRepository.save(emp);
//	}
	
}
