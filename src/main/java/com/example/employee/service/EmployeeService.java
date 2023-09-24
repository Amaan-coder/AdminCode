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

	public ResponseDto updateEmployee(Integer id, EmployeeDto updatedEmployee) {
		
		EmployeeDto existingEmployee = dao.findById(id).orElse(null);

        // Update the existing employee's properties based on the provided data
        if (updatedEmployee.getFirstName() != null) {
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
        }
        if (updatedEmployee.getLastName() != null) {
            existingEmployee.setLastName(updatedEmployee.getLastName());
        }
        if (updatedEmployee.getEmail() != null) {
            existingEmployee.setEmail(updatedEmployee.getEmail());
        }
        if (updatedEmployee.getCompany() != null) {
            existingEmployee.setCompany(updatedEmployee.getCompany());
        }
        if (updatedEmployee.getPhone() != null) {
            existingEmployee.setPhone(updatedEmployee.getPhone());
        }
        if (updatedEmployee.getAddressLine1() != null) {
            existingEmployee.setAddressLine1(updatedEmployee.getAddressLine1());
        }
        if (updatedEmployee.getAddressLine2() != null) {
            existingEmployee.setAddressLine2(updatedEmployee.getAddressLine2());
        }
        if (updatedEmployee.getPostalCode() != null) {
            existingEmployee.setPostalCode(updatedEmployee.getPostalCode());
        }
        if (updatedEmployee.getCity() != null) {
            existingEmployee.setCity(updatedEmployee.getCity());
        }
        if (updatedEmployee.getState() != null) {
            existingEmployee.setState(updatedEmployee.getState());
        }

        // Save the updated employee
        dao.save(existingEmployee);
		String results = "Employee Updated Successfully";
		return new ResponseDto(results);
		
	}
}
