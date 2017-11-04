package org.knuba.task23;


import java.util.Queue;

import static org.knuba.task23.Task23.elementLeft;
import static org.knuba.task23.Task23.limit;
import static org.knuba.task23.Task23.limitedQueue;


public class Task23 {
    static int limit = 100;
    static int elementLeft = 10;
    static LimitedQueue<String> limitedQueue = new LimitedQueue<>(limit);
    synchronized public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        limitedQueue.add("S");
        limitedQueue.add("2");
        a.start();
        b.start();
        c.start();


        try {
            a.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(limitedQueue);
    }
}

class A extends Thread {
    @Override
    public void run() {
        System.out.println("Start a");
        for (int i = 0; i <limit/2; i++) {
            limitedQueue.add("A"+i);
        }
        System.out.println("Finish a");
    }
}

class B extends Thread {
    @Override
    public void run() {
        System.out.println("Start b");
        for (int i = 0; i <limit/2 ; i++) {
            limitedQueue.add("B"+i);
        }
        System.out.println("Finish b");
    }
}

class C extends Thread {
    @Override
    public void run() {
        System.out.println("Start c");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <limit-elementLeft ; i++) {
            limitedQueue.remove();
        }
        System.out.println("Finish c");
    }
}
