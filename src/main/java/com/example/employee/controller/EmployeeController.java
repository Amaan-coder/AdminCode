package com.example.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseDto;
import com.example.employee.service.EmployeeService;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
		
	
	@GetMapping("/employeelist")
	
	public ResponseDto fetchEmployeeList(){
		
		
		return service.fetchEmployee();
	}
	
	@PostMapping("/addemployee")
	public ResponseDto createEmployee(@RequestBody EmployeeDto employee){
		
		return service.saveEmployee(employee);
		
	}
	
	@GetMapping("employee/{id}")
	public ResponseDto fetchEmployeeById(@PathVariable Integer id) {
		
		return service.fetchEmployeeById(id);
		
	}
	
	@GetMapping("delemployee/{id}")
	public ResponseDto deleteEmployeeById(@PathVariable Integer id){
		
		return service.deleteEmployee(id);
		
	}
	
}
