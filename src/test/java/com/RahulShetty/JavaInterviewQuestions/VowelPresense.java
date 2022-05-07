package com.RahulShetty.JavaInterviewQuestions;

import org.testng.annotations.Test;

public class VowelPresense {
    String s = "Tester";

    @Test
    public void checkVowel(){
        System.out.println(s.toLowerCase().matches(".*[aeiou].*"));
    }
}
