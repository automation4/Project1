package com.RahulShetty.JavaInterviewQuestions.DSA;

import org.testng.annotations.Test;

class Node {
    int data;
    Node next;
}

public class PracticeLinkedList {
    @Test
    public void creatingNode(){
        Node head, middle, last;

        head = new Node();
            middle  = new Node();
            last = new Node();

            head.data= 20;
            middle.data = 40;
            last.data = 50;

            head.next =middle;
            middle.next = last;
            last.next=null;

            printNode(head);
        }


        public void printNode(Node head){
        Node temp= head;

        while (temp!=null){
            System.out.print(temp.data + ",");
            temp=temp.next;
        }
        }

        @Test
        public void insertFrist(){
        int n=10;
        int[] n1 = {20,10};
        Node head =null;

    for(int val : n1){
    Node newnode = new Node();
    newnode.data =val;
    newnode.next=head;

    head =newnode;
            }
        printNode(head);
        }

        @Test
        public void insertLast() {
            int[] n1 = {20, 10,4,5,6,7,8,8};
            Node head =null;
            for (int val : n1) {
                Node newNode = new Node();
                newNode.data = val;
                newNode.next = null;

                if (head==null){
                    head= newNode;
                }
                else{
                    Node lastNode = head;
                    while(lastNode.next!=null){
                        lastNode=lastNode.next;
                    }
                    lastNode.next=newNode;
                }
            }
            printNode(head);

        }
@Test
        public void deleteNodeSingleLinkedlist(){
        int key = 10;
        int[] a = {1,2,10,3};
             Node head =null;
             for(int x:a){
                 Node newNode = new Node();
                 newNode.data=x;
                 newNode.next=null;

                 if(head==null){
                     head =newNode;
                 }
                 else {
                     Node temp = head;
                     while (temp.next != null) {
                         temp = temp.next;
                     }
                     temp.next = newNode;
                 }
             }
             Node temp = head;
        while(temp.next!=null){
            if(temp.next.data==key){
                temp.next = temp.next.next;
            }
            else {
                temp =temp.next;
            }

        }
    printNode(head);
        }


}