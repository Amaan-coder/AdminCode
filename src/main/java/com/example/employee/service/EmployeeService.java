package com.example.employee.service;


import java.util.List;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseDto;
import com.example.employee.exceptions.ValidationFailedException;
import com.example.employee.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo dao;

	public ResponseDto fetchEmployee() {

		return new ResponseDto(dao.findAll());

	}

	public ResponseDto saveEmployee(EmployeeDto employee) {
	
		
		String email = null;
		String name = null;
		List<EmployeeDto> employee1 = dao.findAll();
		for(EmployeeDto user : employee1) {
			email = user.getEmail();
			name = user.getFirstName().concat(user.getLastName());
		}
		if(employee.getEmail().equals(email)) {
			throw new ValidationFailedException("Employee already exist");
		}
		if(employee.getFirstName().concat(employee.getLastName()).equals(name)) {
			throw new ValidationFailedException("Name already exist");
		}
			String outMessage;
		
			dao.save(employee);

			outMessage = "Employee Added Sucessfully";
		
		return new ResponseDto(outMessage);
	}

	public ResponseDto fetchEmployeeById(Integer Id) {
		return new ResponseDto(dao.findById(Id));
	}

	public ResponseDto deleteEmployee(Integer id) {

		String results;
		try {
			dao.deleteById(id);
			results = "Successfully Deleted";
		} catch (Exception e) {
			results = "Not Deleted";
		}
		return new ResponseDto(results);
	}

	public void initValues() {
			
		EmployeeDto emp = new EmployeeDto();
		emp.setAddressLine1("Khadra");
		emp.setAddressLine2("Sitapur Road");
		emp.setCity("Lucknow");
		emp.setCompany("TCS");
		emp.setEmail("amaan@tcs.com");
		emp.setFirstName("Mohd");
		emp.setLastName("Amaan");
		emp.setPhone((long) 790537846);
		emp.setPostalCode(229090);
		emp.setState("Uttar Pradesh");
		
		dao.save(emp);
	
	}
}
