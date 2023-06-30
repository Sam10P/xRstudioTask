package com.example.xRstudioTask.controller;

import com.example.xRstudioTask.exception.StudentNotFoundException;
import com.example.xRstudioTask.model.Student;
import com.example.xRstudioTask.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody Student student){

        String ans = studentService.addStudent(student);
        return new ResponseEntity(ans, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity findStudentById(@PathVariable int id){


        try{
            Student student = studentService.findStudentById(id);
            return new ResponseEntity(student, HttpStatus.FOUND);
        } catch (StudentNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
