package com.ayush.testing;

public class StudentFactory {
    public static StudentInterface getStudentInterface() {
        return new StudentInterfaceImpl();
    }
}
