package com.student.management.studentManagement.service;

import com.student.management.studentManagement.entity.Student;
import com.student.management.studentManagement.exception.StudentAlreadyExistsException;
import com.student.management.studentManagement.repository.StudentRepository;
import com.student.management.studentManagement.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student) throws StudentAlreadyExistsException {
        if(!studentRepository.findByEmail(student.getEmail()).isEmpty()) {
            throw new StudentAlreadyExistsException("Student already exists");
        }
        studentRepository.save(student);
        return "Success";
    }

    public Optional<Student> findStudentById(int id){
        return studentRepository.findById(id);
    }

    public Optional<Student> findStudentByEmail(String email){
        return studentRepository.findByEmail(email);
    }
}
