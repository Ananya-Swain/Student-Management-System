package com.student.management.studentManagement.controller;

import com.student.management.studentManagement.entity.Course;
import com.student.management.studentManagement.entity.Student;
import com.student.management.studentManagement.exception.CourseNotFoundException;
import com.student.management.studentManagement.exception.StudentAlreadyExistsException;
import com.student.management.studentManagement.exception.StudentNotFoundException;
import com.student.management.studentManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("create")
    public ResponseEntity<String> createStudent(@RequestBody Course course) {
        courseService.createCourse(course);
        return new ResponseEntity<>("Course created successfully", HttpStatus.CREATED);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Course> findStudentById(@PathVariable int id) throws CourseNotFoundException {
        return ResponseEntity.ok(courseService.findCourseById(id));
    }
}
