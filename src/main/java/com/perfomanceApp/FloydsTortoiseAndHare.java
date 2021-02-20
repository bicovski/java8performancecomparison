package com.perfomanceApp;


public class FloydsTortoiseAndHare {

     public static void main(String[] args){
    int[] list = new int[] {3,1,3,4,2};
    System.out.println( findDuplicate(list));
     }

     //Floyd's Tortoise and Hare Algorithm example
     public static int findDuplicate(int[] list){
         int tortoise = list[0];
         int hare = list[0];
         while(true){
             tortoise = list[tortoise];
             hare = list[list[hare]];
             if(tortoise == hare){
                 break;
             }
         }
         int  ptr1 = list[0];
         int  ptr2 = tortoise;
         while (ptr1 != ptr2){
             ptr1 = list[ptr1];
             ptr2 = list[ptr2];
         }
        return ptr1;
     }
}
