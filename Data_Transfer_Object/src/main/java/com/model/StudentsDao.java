package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentsDao 
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // CREATE
    public int addStudent(Students student) 
    {
        String sql = "INSERT INTO student (id, name, email, password) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, student.getId(), student.getName(), student.getEmail(), student.getPassword());
    }

    // READ ALL
    public List<Students> getAllStudents() 
    {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Students.class));
    }

    // READ ONE
    public Students getStudentById(int id) 
    {
        String sql = "SELECT * FROM student WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Students.class), id);
    }

    // UPDATE
    public int updateStudent(Students student) 
    {
        String sql = "UPDATE student SET name = ?, email = ?, password = ? WHERE id = ?";
        return jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getPassword(), student.getId());
    }

    // DELETE
    public int deleteStudent(int id) 
    {
        String sql = "DELETE FROM student WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
