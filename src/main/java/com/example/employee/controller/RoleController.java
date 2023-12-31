package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.ResponseDto;
import com.example.employee.dto.RoleDto;

import com.example.employee.service.RoleService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService role;
	
	@PostMapping("/addrole")
	public ResponseDto addRole(@RequestBody RoleDto user) {
		return role.addRole(user);
	}
	
	
}
