package com.student.management.studentManagement.service;

import com.student.management.studentManagement.entity.Student;
import com.student.management.studentManagement.exception.StudentAlreadyExistsException;
import com.student.management.studentManagement.repository.StudentRepository;
import com.student.management.studentManagement.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void createStudent(Student student) throws StudentAlreadyExistsException {
        if(!studentRepository.findByEmail(student.getEmail()).isEmpty()) {
            throw new StudentAlreadyExistsException("Student already exists");
        }
        student.setCreatedAt(LocalDateTime.now());
        studentRepository.save(student);
    }

    public Student findStudentById(int id) throws StudentNotFoundException {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isEmpty()) {
            throw new StudentNotFoundException("Student not found");
        }
        return optional.get();
    }

    public Student findStudentByEmail(String email) throws StudentNotFoundException {
        Optional<Student> optional = studentRepository.findByEmail(email);
        if(optional.isEmpty()) {
            throw new StudentNotFoundException("Student not found");
        }
        return optional.get();
    }
}
