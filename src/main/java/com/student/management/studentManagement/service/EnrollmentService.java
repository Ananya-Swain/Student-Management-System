package com.student.management.studentManagement.service;

import com.student.management.studentManagement.entity.Course;
import com.student.management.studentManagement.entity.Enrollment;
import com.student.management.studentManagement.entity.Student;
import com.student.management.studentManagement.exception.CourseNotFoundException;
import com.student.management.studentManagement.exception.EnrollmentAlreadyExistsException;
import com.student.management.studentManagement.exception.StudentNotFoundException;
import com.student.management.studentManagement.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentService {
    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    EnrollmentRepository enrollmentRepository;

    public void enrollStudentToCourse(int studentId, int courseId) throws Exception {
        Student student = studentService.findStudentById(studentId);
        Course course = courseService.findCourseById(courseId);
        List<Enrollment> enrollments = enrollmentRepository.findByStudent(student);
        boolean enrollmentExists = false;
        if(!enrollments.isEmpty()) {
            for(Enrollment enrollment : enrollments) {
                if(enrollment.getCourse().getId() == course.getId()) {
                    enrollmentExists = true;
                    break;
                }
            }
        }
        if(enrollmentExists) {
            throw new EnrollmentAlreadyExistsException("Enrollment already exists");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDateTime.now());
        enrollment.setStatus("Active");

        enrollmentRepository.save(enrollment);
    }

    public List<Course> findEnrollByStudent(int studentId) throws StudentNotFoundException {
        Student student = studentService.findStudentById(studentId);
        List<Course> courseList = new ArrayList<>();
        List<Enrollment> enrollmentList = enrollmentRepository.findByStudent(student);
        for(Enrollment enrollment : enrollmentList) {
            courseList.add(enrollment.getCourse());
        }
        return courseList;
    }

    public List<Student> findEnrollByCourse(int courseId) throws CourseNotFoundException {
        Course course = courseService.findCourseById(courseId);
        List<Student> studentList = new ArrayList<>();
        List<Enrollment> enrollmentList = enrollmentRepository.findByCourse(course);
        for(Enrollment enrollment : enrollmentList) {
            studentList.add(enrollment.getStudent());
        }
        return studentList;
    }
}
