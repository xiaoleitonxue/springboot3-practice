package org.example;

import net.bytebuddy.asm.Advice;

public class ThreadLocalTest {

    private static final ThreadLocal<String> tl = new ThreadLocal<>();
    public static void main(String[] args) {
        tl.set("tom");

        new Thread(new Runnable() {
            @Override
            public void run() {
                tl.set("jerry");
                System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + ":" + tl.get());

        tl.remove();

        System.out.println(Thread.currentThread().getName() + ":" +tl.get());
    }
}
