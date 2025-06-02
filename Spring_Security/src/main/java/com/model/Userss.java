package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userss")  
public class Userss 
{
	@Id
	private String username;
	private String password;
	private String role;
	
	public Userss() {}
	public Userss(String username, String password, String role) 
	{
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getRole() 
	{
		return role;
	}
	public void setRole(String role) 
	{
		this.role = role;
	}
}
