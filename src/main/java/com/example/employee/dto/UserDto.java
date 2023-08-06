package com.example.employee.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

//User.java
@Entity
@Table(name = "users")
public class UserDto {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false)
 private String fullName;

 @Column(nullable = false, unique = true)
 private String email;

 @Column(nullable = false)
 private String password;
 
 @Column(nullable = false)
 private String role;
 
 @Transient
 private String confirmPassword;


 public UserDto() {
 }


public UserDto(String fullName, String email, String password, String role, String confirmPassword) {
	super();
	
	this.fullName = fullName;
	this.email = email;
	this.password = password;
	this.role = role;
	this.confirmPassword = confirmPassword;
}





public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getConfirmPassword() {
	return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}


public String getRole() {
	return role;
}


public void setRole(String role) {
	this.role = role;
}



}

