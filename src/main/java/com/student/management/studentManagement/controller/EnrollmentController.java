package com.student.management.studentManagement.controller;

import com.student.management.studentManagement.entity.Course;
import com.student.management.studentManagement.entity.Student;
import com.student.management.studentManagement.exception.CourseNotFoundException;
import com.student.management.studentManagement.exception.StudentNotFoundException;
import com.student.management.studentManagement.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enrollment")
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping("create/{studentId}/{courseId}")
    public ResponseEntity<String> createEnrollment(@PathVariable int studentId, @PathVariable int courseId) throws Exception{
        enrollmentService.enrollStudentToCourse(studentId, courseId);
        return new ResponseEntity<>("Student enrolled successfully", HttpStatus.CREATED);
    }

    @GetMapping("findCourseOfStudent/{id}")
    public ResponseEntity<List<Course>> findCourseOfStudent(@PathVariable int studentId) throws StudentNotFoundException {
        return ResponseEntity.ok(enrollmentService.findEnrollByStudent(studentId));
    }

    @GetMapping("findStudentOfCourse/{id}")
    public ResponseEntity<List<Student>> findStudentOfCourse(@PathVariable int courseId) throws CourseNotFoundException {
        return ResponseEntity.ok(enrollmentService.findEnrollByCourse(courseId));
    }
}
