package com.student.management.studentManagement.service;

import com.student.management.studentManagement.entity.Course;
import com.student.management.studentManagement.entity.Student;
import com.student.management.studentManagement.exception.CourseNotFoundException;
import com.student.management.studentManagement.exception.StudentNotFoundException;
import com.student.management.studentManagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public String createCourse(Course course) {
        courseRepository.save(course);
        return "Success";
    }

    public Optional<Course> findCourseById(int id){
        return courseRepository.findById(id);
    }
}
