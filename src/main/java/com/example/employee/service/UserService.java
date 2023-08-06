package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.ResponseDto;
import com.example.employee.dto.UserDto;
import com.example.employee.exceptions.ValidationFailedException;
import com.example.employee.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository dao;

	public ResponseDto signup(UserDto userDto) {
		String outMessage = null;
		if (userDto.getEmail() != null && userDto.getFullName() != null && userDto.getPassword() != null
				&& userDto.getConfirmPassword() != null && userDto.getRole()!=null) {

			if (dao.findByEmail(userDto.getEmail()) != null) {
				outMessage = "Email already exists";
				throw new ValidationFailedException(outMessage);
			}

			if (userDto.getPassword().equals(userDto.getConfirmPassword())) {
				dao.save(userDto);
				outMessage = "Signup Sucessfully";

			}
			else {
				throw new ValidationFailedException("Password doesnot match");
			}
		}

		return new ResponseDto(outMessage);
	}

	public ResponseDto login(UserDto userDto) {
    String outMessage = null;

    UserDto user = dao.findByEmail(userDto.getEmail());
    
    System.out.println("User Details "+user);
    
    if (user != null && user.getPassword().equals(userDto.getPassword())) {
        String role = user.getRole();
        
        if ("admin".equals(role)|| "Admin".equals(role)) {
            outMessage = "Admin Login Successful";
            
        } else if ("user".equals(role)) {
            outMessage = "User Login Successful";
            
        } else {
            throw new ValidationFailedException("Invalid Role"); // Handle unrecognized roles if needed
        }
    } else {
        throw new ValidationFailedException("Bad Credentials");
    }

    return new ResponseDto(outMessage);
}

	
}
