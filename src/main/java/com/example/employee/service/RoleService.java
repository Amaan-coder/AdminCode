package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.ResponseDto;
import com.example.employee.dto.RoleDto;
import com.example.employee.repository.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo dao;

	public ResponseDto addRole(RoleDto user) {
		String outMessage=null;
		
		
		dao.save(user);
		outMessage ="Role added Successfully";
		return new ResponseDto(outMessage);
	}
	
	

}
