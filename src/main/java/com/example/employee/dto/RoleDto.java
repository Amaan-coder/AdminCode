package com.example.employee.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Role")
public class RoleDto {

	@Id
	private String role;
	private String roleDes;

	public RoleDto() {
		super();
	}

	public RoleDto(String role, String roleDes) {
		super();
		this.role = role;
		this.roleDes = roleDes;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleDes() {
		return roleDes;
	}

	public void setRoleDes(String roleDes) {
		this.roleDes = roleDes;
	}

}
