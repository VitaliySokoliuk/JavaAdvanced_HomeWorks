package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        Calculation calculation = new Calculation(10, 40, 2, 2, 1, 50);
        int result = calculation.summary();
        System.out.println(result);
    }
}
