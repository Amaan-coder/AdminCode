package com.example.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.employee.dto.RoleDto;
import com.example.employee.dto.UserDto;

public interface UserRepository<RoleDto> extends CrudRepository<UserDto, String> {

    UserDto findByEmail(String email);
    
}