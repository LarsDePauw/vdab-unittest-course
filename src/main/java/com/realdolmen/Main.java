package com.realdolmen;


public class Main {
    public static void main(String[] args) {

        double x = 100 * Math.random();
        for (int i = 1; i < x; i++) {
            System.out.println(i);
            double letters = Math.random() * 26;
            letters = (int) letters;
            System.out.println(letters);
        }



    }

}
