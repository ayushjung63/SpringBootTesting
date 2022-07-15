package com.ayush.testing.repo;

import com.ayush.testing.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query(nativeQuery = true, value = "select * from student s where s.faculty=?1")
    List<Student> findStudentByFaculty(String faculty);
}
