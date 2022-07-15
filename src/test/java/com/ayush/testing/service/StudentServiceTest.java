package com.ayush.testing.service;

import com.ayush.testing.model.Student;
import com.ayush.testing.repo.StudentRepo;
import com.ayush.testing.service.impl.StudentServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ContextConfiguration({"classpath*:spring/applicationContext.xml"})
@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepo studentRepo;


    @Test
    public void findStudentByFacultyTest() {
        String faculty = "BCA";
        List<Student> studentByFaculty = studentService.getStudentByFaculty(faculty);
        studentByFaculty.stream().forEach(x -> Assertions.assertThat(x.getFaculty().equals(faculty)));
    }


    @TestConfiguration
    static class StudentServiceTestContextConfig {

        @Bean
        public StudentService studentService() {
            return new StudentServiceImpl();
        }

    }
}
