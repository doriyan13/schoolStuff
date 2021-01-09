package com.company;

import java.util.LinkedList;

public class Class09 {
//Test and Error for mamah02:

    public double myFunc(double x, double y){
        return 1.0;
    }
    // Not legal overloading because you can't change type!
//    public int myFunc(double y, double x){
//        return 1;
//    }
    // Not legal overloading because you didn't change anything initiatly:
//    public double myFunc(double a, double b){
//        return 2.0;
//    }
    // ***
    // That's legal overloading:
    public double myFunc(double a){
        return 2.0;
    }

    public static void main(String[] args){

        //System.out.println(Student.f()); abstruct class cannot create an object thus if the method will not be static i won't be able to call her here!
        //System.out.println(Student.f(1.0));
        String a = "a";
        String b = "b";
        System.out.println(a.compareTo(b));

        LinkedList<Integer> test = new LinkedList<Integer>();

//        Scanner input = new Scanner(System.in);
//
//        int size = input.nextInt();
//
//        Mmh02[] test = new Mmh02[size];
//
//        for (int i = 0; i< size; i++){
//            test[i] = new Mmh02();
//            test[i].printNow();
//        }
//        for (int i = 0; i< size; i++){
//            System.out.print("spot "+(i+1)+": ");
//            test[i].printNow();
//
//        }

    }
}
