package com.ayush.testing;

public class TestImpl implements Test {
    public static void main(String[] args) {
        TestImpl test = new TestImpl();
        test.hello();

        Test.hello2("Sup");
    }
}
