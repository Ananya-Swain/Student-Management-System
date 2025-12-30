package com.student.management.studentManagement.controller;

import com.student.management.studentManagement.entity.Student;
import com.student.management.studentManagement.exception.StudentAlreadyExistsException;
import com.student.management.studentManagement.exception.StudentNotFoundException;
import com.student.management.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("create")
    public ResponseEntity<String> createStudent(@RequestBody Student student) throws StudentAlreadyExistsException {
        studentService.createStudent(student);
        return new ResponseEntity<>("Student created successfully", HttpStatus.CREATED);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable int id) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.findStudentById(id));
    }

    @GetMapping("findByEmail/{email}")
    public ResponseEntity<Student> findStudentByEmail(@PathVariable String email) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.findStudentByEmail(email));
    }
}
