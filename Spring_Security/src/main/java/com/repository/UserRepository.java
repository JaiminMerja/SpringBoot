package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Userss;

public interface UserRepository extends JpaRepository<Userss, String>
{
	Optional<Userss> findByUsername(String username);
}
