package com.example.democi_cd.controller;

import com.example.democi_cd.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        if (student.getEmail() == null || !student.getEmail().contains("@")) {
            return ResponseEntity.badRequest().body("Email không hợp lệ!");
        }
        return ResponseEntity.ok(student);
    }
}
