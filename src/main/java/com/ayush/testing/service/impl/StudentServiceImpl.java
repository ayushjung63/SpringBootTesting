package com.ayush.testing.service.impl;

import com.ayush.testing.model.Student;
import com.ayush.testing.repo.StudentRepo;
import com.ayush.testing.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    public StudentServiceImpl() {
    }

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getStudentByFaculty(String faculty) {
        List<Student> studentByFaculty = studentRepo.findStudentByFaculty(faculty);
        if (studentByFaculty.isEmpty() || studentByFaculty == null) {
            return null;
        } else {
            return studentByFaculty;
        }
    }
}
