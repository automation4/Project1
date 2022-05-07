package com.RahulShetty.JavaInterviewQuestions;

import org.testng.annotations.Test;

public class PrimeNumber {

    @Test
    public void findPrime() {
        int number = 23;
        boolean f = false;
        for (int j = 2; j < number / 2; j++) {
            if (number % j == 0) {
                f = false;
                break;
            }
            else f=true;
            }
        if(f){
            System.out.println("its prime");
        }
        else
            System.out.println("its not prime");
    }

    @Test
    public void findPrimeNumbers() {
        int number = 20;
        int[] array1 = null;
        boolean f = false;
        for (int j = 2; j < number; j++) {
            if (number % j == 0) {
                f = false;
                array1 [j]= array1[j]+ j;
                break;
            }
            else f=true;
        }
        if(f){
            System.out.println("its prime");
        }
        else
            System.out.println("its not prime");
    }
}
