package com.klu.controller;

import com.klu.entity.Student;
import com.klu.exception.StudentNotFoundException;
import com.klu.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository repository;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {

        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
    }
}