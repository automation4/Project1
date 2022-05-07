package com.RahulShetty.JavaInterviewQuestions;

import org.testng.annotations.Test;

public class ReverseString {

    //1. How to reverse a String in Java?
    @Test   //method 1:
    public void reversemethod1() {
        String sample = "Testing";
        StringBuffer br = new StringBuffer(sample);
        System.out.println("1 " + br.reverse());
    }

    @Test   //method 2:
    public void reversemethod2() {
        String sample = "Testing";
        StringBuilder bd = new StringBuilder(sample);
        System.out.println("2 " + bd.reverse());
    }

    @Test         //method 3:
    public void reversemethod3() {
        String sample = "Testing";
        String reversed = "";
        char[] c = sample.toCharArray();
        for (int i = sample.length() - 1; i >= 0; i--) {
            reversed = reversed + sample.charAt(i);
        }
        System.out.println("3 " + reversed.trim());
    }

    @Test    //method 4:
    public void reversemethod4() {
        String sample = "Testing";
        char[] c = sample.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        for (int i = c.length - 1; i >= 0; i--) {
            sb1.append(c[i]);
        }
        System.out.println("4 " + sb1);
    }
}
