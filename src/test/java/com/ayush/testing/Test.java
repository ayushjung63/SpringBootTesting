package com.ayush.testing;

public interface Test {
    default void hello() {
        System.out.println("Hello From Interface Using Default Keyword");
    }

    static void hello2(String text) {
        System.out.println("Hello from Interface using Static Impl");
        System.out.println(text);
    }
}
