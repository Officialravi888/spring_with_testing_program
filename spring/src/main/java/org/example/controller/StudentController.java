package org.example.controller;

import org.example.dto.StudentDto;
import org.example.model.Student;
import org.example.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Validated
public class StudentController {
    @Autowired
    private StudentServices studentServices;

    @GetMapping("/student")

    public ResponseEntity<List<Student>> getAllStudent() {
        return new ResponseEntity<List<Student>>(studentServices.getStudent(), HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> save(@RequestBody @Valid StudentDto studentDto) {

        return new ResponseEntity<Student>(studentServices.createStudent(studentDto), HttpStatus.CREATED);
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Student id) {
        studentServices.createStudent(new StudentDto());
    }

}