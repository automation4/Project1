package com.RahulShetty.JavaInterviewQuestions.DSA;

import org.testng.annotations.Test;

public class PracticedoublyLinkedList {

    class Node{
        Node prev;
        int data;
        Node next;
    }

    @Test
    public void dublyLnkedList(){
        int[] a = {1,2,3,4,5};
        Node head = null;
        Node newNode = new Node();

        for(int x :a){
            newNode.data = x;
            if(head==null){
                newNode.prev = null;
                newNode.next=null;
                head =newNode;
            }
            else{
                Node lastn = head;
                while(lastn.next!=null){
                    lastn = lastn.next;
                }
                lastn.next= newNode;
                newNode.prev = lastn;
                newNode.next = null;
            }
        }

        printNode(head);
    }


    public void printNode(Node head){
        Node temp= head;
        while (temp!=null){
            System.out.print(temp.data + ",");
            temp=temp.next;
        }
    }
}
