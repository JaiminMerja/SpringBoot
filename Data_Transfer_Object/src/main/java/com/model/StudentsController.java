package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController 
{

    @Autowired
    private StudentsService service;

    // GET one student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentsDTO> getStudent(@PathVariable int id) 
    {
        StudentsDTO dto = service.getStudentsDTOByid(id);
        if (dto == null) 
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    // GET all students
    @GetMapping
    public ResponseEntity<List<StudentsDTO>> getAllStudents() 
    {
        List<StudentsDTO> students = service.getAllStudentDTOs();
        return ResponseEntity.ok(students);
    }

    // POST create a new student
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentsDTO dto) 
    {
        service.createStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student created successfully");
    }

    // PUT update student
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody StudentsDTO dto) 
    {
        dto.setId(id); // Ensure the ID is set from the path
        service.updateStudent(dto);
        return ResponseEntity.ok("Student updated successfully");
    }

    // DELETE student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) 
    {
        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
