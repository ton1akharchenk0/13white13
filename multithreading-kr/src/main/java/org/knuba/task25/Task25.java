package org.knuba.task25;

public class Task25 {
    public static int rowsA = 200;
    public static int colsA = 100;
    public static int rowsB = colsA;
    public static int colsB = rowsA;
    //elements to fill the matrix with
    public static int constA = 2;
    public static int constB = 2;
    public static int[][] c;
    public static int[][] a;
    public static int[][] b;


    public static void main(String[] args) throws Exception {
        long t1 = System.currentTimeMillis();
        a = matrixAInput();
        b = matrixBInput();
        c= new int [a.length][b[0].length];

        Thread1 m1 = new Thread1();
        Thread2 m2 = new Thread2();
        Thread3 m3 = new Thread3();
        Thread4 m4 = new Thread4();
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m1.join();
        m2.join();
        m3.join();
        m4.join();

        matrixOut(c);

        long t2 = System.currentTimeMillis();
        System.out.println("the time is "+(t2-t1)+"ms");

    }


    public static int[][] matrixAInput() {
        int[][] matrix = new int[rowsA][colsA];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrix[i][j] = constA;
            }
        }
        return matrix;
    }
    public static int[][] matrixBInput() {
        int[][] matrix = new int[rowsB][colsB];
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrix[i][j] = constB;
            }
        }
        return matrix;
    }
    public static void matrixOut(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        String str = "|\t";

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                str += matrix[i][j] + "\t";
            }

            System.out.println(str + "|");
            str = "|\t";
        }
    }

    public static class Thread1 extends Thread {

        @Override
        public void run() {
            int m = a.length;
            int n = b[0].length;
            int k = (a.length) / 4;



            for (int i = 0; i <= k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < b.length; l++) {
                        c[i][j] = c[i][j] + a[i][l] * b[l][j];

                    }

                }

            }
        }
    }

    public static class Thread2 extends Thread {

        @Override
        public void run() {
            int m = a.length;
            int n = b[0].length;
            int k = (a.length) / 2+1;
            int s = ((a.length) /4)+1;



            for (int i = s ; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < b.length; l++) {
                        c[i][j] = c[i][j] + a[i][l] * b[l][j];

                    }

                }

            }
        }
    }
    public static class Thread3 extends Thread {

        @Override
        public void run() {
            int m = a.length;
            int n = b[0].length;
            int k = ((3*(a.length))/4)+ 1;
            int s = (a.length) / 2 + 1;



            for (int i = s ; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < b.length; l++) {
                        c[i][j] = c[i][j] + a[i][l] * b[l][j];

                    }

                }

            }
        }
    }
    public static class Thread4 extends Thread {

        @Override
        public void run() {
            int m = a.length;
            int n = b[0].length;
            int k = ((3*(a.length))/4)+ 1;



            for (int i = k ; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < b.length; l++) {
                        c[i][j] = c[i][j] + a[i][l] * b[l][j];

                    }

                }

            }
        }
    }


}