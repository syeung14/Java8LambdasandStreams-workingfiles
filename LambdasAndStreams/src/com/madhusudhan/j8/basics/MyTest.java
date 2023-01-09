package com.madhusudhan.j8.basics;

public class MyTest {
    void testRunnable(Runnable r) {
        new Thread(r).start();
    }

    void aTestMethod() {
        testRunnable(new Runnable() {
            @Override
            public void run() {
                sendMail();
            }

        });

    }

    void testB() {
        testRunnable(() -> sendMail());
    }

    private void sendMail() {
    }
}