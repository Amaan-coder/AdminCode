package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.dto.EmployeeDto;

public interface EmployeeRepo extends JpaRepository<EmployeeDto, Integer>{

}
