package com.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.model.Userss;
import com.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	private UserRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Userss user = ur.findByUsername(username)
				      .orElseThrow(() -> new UsernameNotFoundException("User Not Found....."));
		return  org.springframework.security.core.userdetails.User
				.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole().replace("ROLE_", ""))
				.build();
	}
}
