package com.ayush.testing.service;

import com.ayush.testing.model.Student;

import java.util.*;

public interface StudentService {
    List<Student> getStudentByFaculty(String faculty);
}
