package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseDto;
import com.example.employee.dto.UserDto;
import com.example.employee.service.UserService;

//UserController.java
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	
	
	@PostMapping("/login")
	public ResponseDto login(@RequestBody UserDto user) {
		return userService.login(user);
	}
	

	@PostMapping("/signup")
	public ResponseDto signup(@RequestBody UserDto userDto) {
		return userService.signup(userDto);

	}
	
	@GetMapping("/userlist")
	public ResponseDto userList() {
		
		return userService.fetchUserList();
	}
}
