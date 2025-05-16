package com;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository 
{
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = new RowMapper<>() 
    {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException 
        {
            return new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email")
            );
        }
    };

    public UserRepository(JdbcTemplate jdbcTemplate) 
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create
    public int save(User user) 
    {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail());
    }

    // Read all
    public List<User> findAll() 
    {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    // Read by ID
    public Optional<User> findById(Long id) 
    {
        String sql = "SELECT * FROM users WHERE id = ?";
        List<User> users = jdbcTemplate.query(sql, userRowMapper, id);
        if (users.isEmpty()) 
        {
            return Optional.empty();
        }
        return Optional.of(users.get(0));
    }

    // Update
    public int update(User user) 
    {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getId());
    }

    // Delete
    public int deleteById(Long id) 
    {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
