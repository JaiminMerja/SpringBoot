package com;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController 
{

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) 
    {
        this.userRepository = userRepository;
    }

    // Create user
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) 
    {
        try {
            	int rows = userRepository.save(user);
            	if (rows > 0) 
            	{
            		return ResponseEntity.ok("User created successfully");
            	} 
            	else 
            	{
            		return ResponseEntity.status(500).body("Failed to create user");
            	}
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }


    // Get all users
    @GetMapping
    public List<User> getAllUsers() 
    {
        return userRepository.findAll();
    }

    // Get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) 
    {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) 
    {
        user.setId(id);
        int rows = userRepository.update(user);
        if (rows > 0) 
        {
            return ResponseEntity.ok("User updated successfully");
        } 
        else 
        {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
    {
        int rows = userRepository.deleteById(id);
        if (rows > 0)
        {
            return ResponseEntity.ok("User deleted successfully");
        } 
        else 
        {
            return ResponseEntity.notFound().build();
        }
    }
}
