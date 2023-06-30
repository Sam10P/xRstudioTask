package com.example.xRstudioTask.service;

import com.example.xRstudioTask.exception.StudentNotFoundException;
import com.example.xRstudioTask.model.Student;
import com.example.xRstudioTask.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){

        Student savedStudent = studentRepository.save(student);

        return "Student has been saved Successfully!!!.";
    }

    public Student findStudentById(int id) throws StudentNotFoundException {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if(studentOptional.isEmpty()){
            throw new StudentNotFoundException("Student does not exist!!");
        }

        Student student = studentOptional.get();

        return student;
    }

}
