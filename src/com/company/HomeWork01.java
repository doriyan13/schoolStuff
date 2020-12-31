package com.company;
import java.util.Scanner;

public class HomeWork01 {

    public static void main(String[] args){
        HomeWork01.Example01();
        HomeWork01.Example02();
    }

    public static void Example01(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a 4 digit number :");
        int num = input.nextInt();
        System.out.println("The digits total - " + (num / 1000 + num / 100 + num / 10));
        System.out.println("First Num - "+ num%1000);
        System.out.println("Second Num - " + num/1000 + num%10);
    }

    public static void Example02(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 2 sizes of a rectangle :");
        System.out.print("length -");
        int length = input.nextInt();
        System.out.print("width -");
        int width = input.nextInt();
        if (length > 0 && width > 0){
            if (length == width){
                System.out.println("The rectangle is a square!");
            }
            else{
                System.out.println("The rectangle isn't a square");
            }
        }
        else{
            if (length <= 0){ //zero is also not legal!
                System.out.println("The length size is not legal size!");
            }
            if (width <= 0){ //i put another if because both of them can be not legal!
                System.out.println("The width size is not legal size!");
            }
        }
    }
}
