package org.example.services;

import org.example.dto.StudentDto;
import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudent() {

        return studentRepository.findAll();
    }
    public Student createStudent(StudentDto studentDto){
        Student student=Student.build(0, studentDto.getName(), studentDto.getNumber(),studentDto.getEmail());
        return studentRepository.save(student);
    }
    public Student findById(Integer Id){
        Optional<Student>studentResult=studentRepository.findById(Id);
        Student student=null;
        if(studentResult.isPresent()){
            student=studentResult.get();
        }
        return student;
    }
}
