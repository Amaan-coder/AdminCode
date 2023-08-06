package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.employee.dto.UserDto;

public interface UserRepository extends JpaRepository<UserDto, Long> {
    UserDto findByEmail(String email);
    UserDto findByPassword(String password);
    UserDto findByRole(String role);
}