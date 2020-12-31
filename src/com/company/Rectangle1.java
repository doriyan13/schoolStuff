package com.company;
import java.util.Scanner;
public class Rectangle1 {
    /*
    * Caculate perimeter of rectangle
     */
    public static void test(){
        int length = 20, width = 10; //width and length of rectangle
        int total = 2*(length + width); // calculate perimeter
        System.out.println("the Total is: " +total);
    }

    public static void main(String[] args){
        //System.out.println("testing 2nd Main");
        /*
        int a = 3, b = 5;
        System.out.println("the Total is: "+ a+b);
        System.out.println("the Total is: " + (a+b));
        System.out.println("the Total is: " + "a+b");
        System.out.println("the Total is: " + 'a' + 'b');
         */

        System.out.println(/* 4 + 7 */ - 5 + 9/*8*//2);
        int a = 10;
        System.out.println(a++);
        System.out.println(a);

       //Rectangle1.Example16();
        int num1 = 1, num2 = 2;
        System.out.print("bla " + num1 + "bla2 " + num2 + "\n"); // You can add "\n" to a print cmd to make in go down a line!
        System.out.println("test 2nd line");

        //Rectangle1.Example18();
        //Rectangle1.Example19();
        Rectangle1.Example20();
    }

    public static void Example16 (){
        Scanner input = new Scanner(System.in);
        int num = 0;
        while(num != -1) {
            num = input.nextInt();
            int a = num % 100 / 10;
            int b = (num - num / 100 * 100) / 10;
            int c = num / 10 % 10;
            int d = num % 1000 / 100;
            System.out.println("a= " + a + ", b= " + b + ", c= " + c + ", d= " + d);
        }
    }

    public static void Example18 (){
        int a =11 ,b= 15 ,c = 33;
        double avg = 0.0;

        avg = (double) ((a+b+c)/3);
        System.out.println(avg);
        avg= (double)(a+b+c)/3;
        System.out.println(avg);
    }

    public static void Example19(){
        int a =1 ,b= 2;
        char x='x', y='A';

        if(x != y || a != 1) {
            System.out.println("1 - true");
        }
        if(!(true && false)) {
            System.out.println("2 - true");
        }
        if(a>b || x=='A'||y!='A') {
            System.out.println("3 - true");
        }
    }

    public static void Example20(){
        int a=1,b=2,c=2;
        if (a==b)
             if (b==c)
            System.out.println ("All three are the same.");
        else
         System.out.println ("a and b are the same.");
         else
         if (b==c)
             System.out.println ("b and c are the same.");
         else
         if (a==c)
             System.out.println ("a and c are the same.");
         else
         System.out.println ("3 different values.");
    }
}
