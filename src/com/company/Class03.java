package com.company;
import java.util.Scanner;

public class Class03 {

    public static void main(String[] args){
        int x =10,y=11;

        if(x%2>y) //not recommended
            System.out.println("yes");
        Scanner input = new Scanner(System.in);
        int test = input.nextInt();
        String nuller = null;
        //System.out.println(nuller.length()); //null pointerException in run time

    }
}
