package com.ayush.testing.controller;

import com.ayush.testing.model.Student;
import com.ayush.testing.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/faculty/{faculty}")
    public ResponseEntity getStudentByFaculty(@PathVariable("faculty") String faculty) {
        List<Student> studentByFaculty = studentService.getStudentByFaculty(faculty);
        if (studentByFaculty == null) {
            return ResponseEntity.ok(errorMessage(customMessageSource.get("failure.retrieve", customMessageSource.get("student")), null));
        } else {
            return ResponseEntity.ok(successMessage(customMessageSource.get("crud.get.list", customMessageSource.get("student")), studentByFaculty));
        }
    }
}
