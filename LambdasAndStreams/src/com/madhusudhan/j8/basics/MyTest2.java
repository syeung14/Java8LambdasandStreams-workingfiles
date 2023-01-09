package com.madhusudhan.j8.basics;

import java.util.function.DoubleToIntFunction;

public class MyTest2 {
    @FunctionalInterface
    interface Component {
        String find(String name);
    }

    interface Greeting {
        String sayHi(String msg);
    }

    void method2(Greeting g, String msg) {
        System.out.println("msg: " + g.sayHi(msg));
    }

    public static void main(String[] args) {
        new MyTest2().method2((s) -> "hello " + s, " greeting from main ");
    }
}
