package com.ayush.testing;

import com.ayush.testing.model.Student;
import com.ayush.testing.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TestingApplication {

	/*@Autowired
	private StudentRepo studentRepo;*/

    public static void main(String[] args) {
        SpringApplication.run(TestingApplication.class, args);
    }

	/*@Override
	public void run(String... args) throws Exception {
		List<Student> students = Arrays.asList(
				new Student(1L, "Ayush Basnet", "Gokarna", "BCA"),
				new Student(2L, "Naresh Ban", "KTM", "CSIT"),
				new Student(3L, "Shivani", "PKR", "BCA"),
				new Student(4L, "Prashant", "PKR", "CSIT"),
				new Student(5L, "Parash", "KTM", "BCA")
		);
		studentRepo.saveAll(students);
	}*/
}
