package com.student.management.studentManagement.repository;

import com.student.management.studentManagement.entity.Course;
import com.student.management.studentManagement.entity.Enrollment;
import com.student.management.studentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    public List<Enrollment> findByStudent(Student student);
    public List<Enrollment> findByCourse(Course course);
}
