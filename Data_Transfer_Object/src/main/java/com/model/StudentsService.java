package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentsService 
{

    @Autowired
    private StudentsDao dao;

    // Convert entity to DTO
    private StudentsDTO convertToDTO(Students student) 
    {
        if (student != null) 
        {
            return new StudentsDTO(student.getId(), student.getName(), student.getEmail(), student.getPassword());
        }
        return null;
    }

    // Convert DTO to entity
    private Students convertToEntity(StudentsDTO dto) 
    {
        if (dto != null) 
        {
            Students student = new Students();
            student.setId(dto.getId());
            student.setName(dto.getName());
            student.setEmail(dto.getEmail());
            student.setPassword(dto.getPassword());
            return student;
        }
        return null;
    }

    // Get DTO by ID
    public StudentsDTO getStudentsDTOByid(int id) 
    {
        Students student = dao.getStudentById(id);
        return convertToDTO(student);
    }

    // Get all DTOs
    public List<StudentsDTO> getAllStudentDTOs() 
    {
        List<Students> students = dao.getAllStudents();
        return students.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Create new Student (from DTO)
    public void createStudent(StudentsDTO dto) 
    {
        Students student = convertToEntity(dto);
        // Set default password if null
        if (student.getPassword() == null || student.getPassword().isEmpty()) 
        {
            student.setPassword("secret");
        }
        dao.addStudent(student);
    }

    // Update existing student
    public void updateStudent(StudentsDTO dto) 
    {
        Students student = convertToEntity(dto);
        dao.updateStudent(student);
    }

    // Delete student by ID
    public void deleteStudent(int id) 
    {
        dao.deleteStudent(id);
    }
}
