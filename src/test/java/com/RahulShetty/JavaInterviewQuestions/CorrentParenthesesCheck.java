package com.RahulShetty.JavaInterviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CorrentParenthesesCheck {

    public boolean correctness(String para){
        char[] arry = para.toCharArray();
        List<Character> specialsymbol = new ArrayList<>();
        Stack<Character> soc = new Stack<>();


        for(int i=0;i<arry.length;i++){
            if( Character.isAlphabetic(arry[i])||Character.isDigit(arry[i])){
                continue;
            }
            else{
                specialsymbol.add(arry[i]);
            }
        }
        for(char c :specialsymbol)
        {
           if(c=='{'||c=='('||c=='['){
               soc.add(c);
           }
           else{
               if(soc.isEmpty()){
                   return false;
               }
               if(c==']' && soc.peek()!='[') return false;
               if(c=='}' && soc.peek()!='{') return false;
               if(c==')' && soc.peek()!='(') return false;

               soc.pop();
           }
        }
    return soc.isEmpty();
    }

    public static void main(String [] args){
        String para = "[t{es(f)a3dad}sd2fs]";
        CorrentParenthesesCheck c = new CorrentParenthesesCheck();
        boolean check = c.correctness(para);
        if(check){
            System.out.println("sync");
        }
        else {
            System.out.println("not a balance sync");

        }
    }
}
