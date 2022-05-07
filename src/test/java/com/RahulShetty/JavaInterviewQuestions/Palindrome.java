package com.RahulShetty.JavaInterviewQuestions;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.util.Objects;

public class Palindrome {
    //Write a method to check if input String is Palindrome?
    @Test  //method1
    public void PalindromeCheck1(){
        boolean flag = true;
        String s= "nitin";
        int j = s.length()-1;
        int i = 0;

        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                flag= false;
                System.out.println("String "+s+" is not palindrome");
                break;
            }
            i++;
            j--;
        }
        if(flag){
            System.out.println("String "+s +" is palindrome");
        }
    }

    @Test  //method 2
    public void PalindromeCheck2(){
        String s = "nitin";
       StringBuilder sb = new StringBuilder(s).reverse();
        if (s.equals(sb.toString())){
            System.out.println(" its palindrome");
        }
        else{
            System.out.println("its not palindrome");
        }
    }
}
