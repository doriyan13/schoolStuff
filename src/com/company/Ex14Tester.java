package com.company;

public class Ex14Tester {

    public static void main(String[] args){
        int[] a = {1,1,3,3,2,2,5,5,2,2,1,1,3,3,5,3,3,1,1,2,2,7,7,6,6,3,3,4,4,5,5,6,6};
        System.out.println("arr size: "+a.length);
        System.out.println("the single number- " +Ex14.findSingle(a));
    }
}
