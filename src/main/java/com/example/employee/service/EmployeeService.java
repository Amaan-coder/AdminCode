package com.example.employee.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseDto;
import com.example.employee.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo dao;

	public ResponseDto fetchEmployee() {

		return new ResponseDto(dao.findAll());

	}

	public ResponseDto saveEmployee(EmployeeDto employee) {
		String outMessage;
		try {
			dao.save(employee);

			outMessage = "Employee Added Sucessfully";
		} catch (Exception e) {

			outMessage = "Not Employee Added Sucessfully";
		}

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
}
