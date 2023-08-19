package com.example.employee.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.employee.dto.ResponseDto;
import com.example.employee.dto.RoleDto;
import com.example.employee.dto.UserDto;
import com.example.employee.exceptions.ValidationFailedException;
import com.example.employee.repository.RoleRepo;
import com.example.employee.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository dao;

	@Autowired
	private RoleRepo roleDao;

	public void initRolesandUser() {

		// Admin Role
		RoleDto adminRole = new RoleDto();
		adminRole.setRole("admin");
		adminRole.setRoleDes("Admin role");
		roleDao.save(adminRole);
		// UserRole
		RoleDto userRole = new RoleDto();
		userRole.setRole("user");
		userRole.setRoleDes("Default role for newly created record");
		roleDao.save(userRole);
		// Admin Information
		UserDto adminUser = new UserDto();
		adminUser.setFullName("Mohd Amaan");
		adminUser.setEmail("amaan@tcs.com");
		adminUser.setPassword("root");
		adminUser.setConfirmPassword("root");
		List<RoleDto> adminRoles = new ArrayList<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		dao.save(adminUser);

	}

	/// Signup
	public ResponseDto signup(UserDto userDto) {
    String outMessage = null;

    RoleDto role = roleDao.findById("user").get();

    List<RoleDto> userRoles = new ArrayList<>();
    userRoles.add(role);
    userDto.setRole(userRoles);

    UserDto retrievedUser = dao.findByEmail(userDto.getEmail());

    if (retrievedUser != null) {
        throw new ValidationFailedException("User already exists");
    } else {
        if (userDto.getEmail() != null && userDto.getFullName() != null && userDto.getPassword() != null
                && userDto.getConfirmPassword() != null) {
            if (userDto.getPassword().equals(userDto.getConfirmPassword())) {
                dao.save(userDto);
                outMessage = "User Signup Successful";
            } else {
                throw new ValidationFailedException("Password doesn't match");
            }
        } else {
            throw new ValidationFailedException("All fields are mandatory");
        }
    }
    return new ResponseDto(outMessage);
}
	// Login
	public ResponseDto login(UserDto userDto) {

		String outMessage = "Login Failed";

		UserDto retrievedUser = dao.findByEmail(userDto.getEmail());

		if (retrievedUser!=null) {

			if (retrievedUser.getPassword().equals(userDto.getPassword())
					&& retrievedUser.getEmail().equals(userDto.getEmail())) {

				List<RoleDto> roles = retrievedUser.getRole();

				if (roles.stream().anyMatch(role -> "admin".equals(role.getRole()))) {

					outMessage = "Admin Login Successful";

				} else if (roles.stream().anyMatch(role -> "user".equals(role.getRole()))) {

					outMessage = "User Login Successful";

				}

			} else {
				throw new ValidationFailedException("Incorrect username or password");
			}
		}
		else {
			throw new ValidationFailedException("User not found");
		}
		UserDto user = dao.findByEmail(userDto.getEmail());
		return new ResponseDto(user);
	}

	// Get All user List
	public ResponseDto fetchUserList() {

		return new ResponseDto(dao.findAll());
	}

}
