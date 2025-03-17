package com.security.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(
        new Student(1, 100, "Ramesh"),
        new Student(2, 90, "Suresh"),
        new Student(3, 80, "Dinesh"),
        new Student(4, 70, "Ganesh")
    ));
    @GetMapping("/student")
    public List<Student> student (){
        return students;
    }

    @GetMapping("/csrf")
    public CsrfToken getcsrftoken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/student")
    public Student addstudent (@RequestBody Student student){
        students.add(student);
        return student;
    }
}
