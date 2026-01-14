package com.example.democi_cd.controller;

import com.example.democi_cd.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping()
    public List<Student> getStudent(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "alice@gmail.com", 20, "123 Main St"));
        students.add(new Student("Bob", "bob@gamil.com", 22, "456 Oak St"));
        students.add(new Student("Charlie", "char@gmail.com", 21, "789 Pine St"));
        return students;
    }
}
