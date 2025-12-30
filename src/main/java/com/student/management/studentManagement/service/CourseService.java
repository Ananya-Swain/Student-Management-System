package com.student.management.studentManagement.service;

import com.student.management.studentManagement.entity.Course;
import com.student.management.studentManagement.entity.Student;
import com.student.management.studentManagement.exception.CourseNotFoundException;
import com.student.management.studentManagement.exception.StudentNotFoundException;
import com.student.management.studentManagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public void createCourse(Course course) {
        course.setCreatedAt(LocalDateTime.now());
        courseRepository.save(course);
    }

    public Course findCourseById(int id) throws CourseNotFoundException {
        Optional<Course> optional = courseRepository.findById(id);
        if(optional.isEmpty()) {
            throw new CourseNotFoundException("Course not found");
        }
        return optional.get();
    }
}
