package com.ayush.testing.service;

import com.ayush.testing.StudentFactory;
import com.ayush.testing.StudentInterface;
import com.ayush.testing.StudentInterfaceImpl;

public class MainRunner {
    public static void main(String[] args) {
        StudentInterface ayush = StudentFactory.getStudentInterface();
        ayush.code("Java");

        StudentInterface studentInterface = new StudentInterfaceImpl();
        studentInterface.code("JAVA LANG");
    }
}
