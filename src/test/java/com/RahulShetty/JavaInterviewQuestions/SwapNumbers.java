package com.RahulShetty.JavaInterviewQuestions;

import org.testng.annotations.Test;

public class SwapNumbers {
     int a = 20;
     int b = 30;

     @Test
    public void swap(){
        b = a+b; //50
        a= b-a; // 30
        b = b-a;
        System.out.println("a >"+a);
        System.out.println("b >"+b);

    }
}
