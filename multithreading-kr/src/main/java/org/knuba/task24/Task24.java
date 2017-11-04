package org.knuba.task24;

import static org.knuba.task24.Task24.allowed;
import static org.knuba.task24.Task24.isAllowed;
import static org.knuba.task24.Task24.setAllowed;

public class Task24 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.start();
        b.start();
    }
    static boolean allowed = true;
    public synchronized static void setAllowed(boolean allowed) {
        Task24.allowed = allowed;
    }

    public synchronized static boolean isAllowed() {
        return allowed;
    }
}

class A extends Thread {
    //private
    @Override
    public void run() {
       while (true){
           try {
               sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           setAllowed(false);
           System.out.println("Thread A: allowed = "+ allowed);

           try {
               sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           setAllowed(true);
           System.out.println("Thread A: allowed = "+ allowed);
       }
    }

    public boolean getIsAllowed() {
        return allowed;
    }
}

class B extends Thread {
    private volatile boolean running = true;
    @Override
    public void run() {
        while (running){
            if (Task24.isAllowed()) {
                System.out.println("Thread B: allowed = "+isAllowed());
                for (int i = 10; i > 0; i--) {
                    System.out.println(i);
                }
            }
            if (!Task24.isAllowed()){
                System.out.println("Stop thread B: allowed = "+isAllowed());
                running = false;
            }
        }

    }
}