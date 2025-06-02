package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.model.Userss;
import com.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner 
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Override
    public void run(String... args) 
    {
        userRepository.save(new Userss("admin", encoder.encode("admin123"), "ROLE_ADMIN"));
        userRepository.save(new Userss("jaimin", encoder.encode("user123"), "ROLE_USER"));
    }
}
