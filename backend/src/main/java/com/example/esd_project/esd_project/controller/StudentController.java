package com.example.esd_project.esd_project.controller;
import com.example.esd_project.esd_project.model.Domain;
import com.example.esd_project.esd_project.model.Student;
import com.example.esd_project.esd_project.service.DomainService;
import com.example.esd_project.esd_project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create_student")
    public ResponseEntity<String> createStudent(@RequestBody Student studentData) {
        studentService.saveStudent(studentData);
        return new ResponseEntity<>("Student created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/view_student/{domain}")
    public List<Student> getStudentByDomain(@PathVariable Long domain) {
        return studentService.getStudentByDomain(domain);
    }
}