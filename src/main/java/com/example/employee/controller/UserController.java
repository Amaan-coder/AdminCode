package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

import jakarta.annotation.PostConstruct;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	
	@PostConstruct
	public void initRolesAndUser() {
		userService.initRolesandUser();
	}
	
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
	@GetMapping("/userrole/{userId}")
    public ResponseDto userRole(@PathVariable String userId) {
        List<String> roleIds = userService.fetchRoleIdsByUserId(userId);
        return new ResponseDto(roleIds);
    }
}
