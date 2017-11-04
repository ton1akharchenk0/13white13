package org.knuba.task22;


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task22 {
    public static void main(String[] args) {
        int n = 3;
        ExecutorService executor = Executors.newFixedThreadPool(n);
        for (int i = 0; i < n; i++) {
            Runnable worker = new WorkerThread();
            executor.execute(worker);
        }
        executor.shutdown();
        System.out.println("Finished all threads");
    }
}

class WorkerThread implements Runnable {
    private ArrayList<String> words = new ArrayList<>();

    String str2 = "class";
    public void run() {
        words.add("Class");
        words.add("Class");
        for (String str1: words) {
            if(str1.toLowerCase().contains(str2.toLowerCase()))
                System.out.println("Class found");
        }
    }

}
