package com.example.employee.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.employee.dto.RoleDto;
import com.example.employee.dto.UserDto;

public interface RoleRepo extends CrudRepository<RoleDto, String>{


}
