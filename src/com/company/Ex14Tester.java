package com.company;

public class Ex14Tester {

    public static void main(String[] args){

        int[] a = {1,1,3,3,2,2,5,5,2,2,2,1,1,3,3};
        System.out.println("arr size: "+a.length);
        System.out.println("the single number- " +Ex14.findSingle(a));
        System.out.println("the correct answer is 2~");

        int[] a4 = {1,1,3,3,2,2,9,5,5,2,2,2,2,1,1,3,3};
        System.out.println("arr size: "+a4.length);
        System.out.println("the single number- " +Ex14.findSingle(a4));
        System.out.println("the correct answer is 9~");

        int[] a1 = {1,1,3,3,2,2,5,5,9,5,5,2,2,2,2,1,1,3,3};
        System.out.println("arr size: "+a1.length);
        System.out.println("the single number- " +Ex14.findSingle(a1));
        System.out.println("the correct answer is 9~");

        int[] a2 = {1,1,3,3,7,2,2,5,5,9,9,5,5,2,2,2,2,1,1,3,3};
        System.out.println("arr size: "+a2.length);
        System.out.println("the single number- " +Ex14.findSingle(a2));
        System.out.println("the correct answer is 7~");

        int[] a3 = {1,1,3,3,7,7,2,2,5,5,8,9,9,5,5,2,2,2,2,1,1,3,3};
        System.out.println("arr size: " + a3.length);
        System.out.println("the single number- " +Ex14.findSingle(a3));
        System.out.println("the correct answer is 8~");

        System.out.println();

        int[] arr1 = {1,4,45,6,0,19};
        System.out.println(Ex14.smallestSubSum(arr1,51));

        int[] arr2 = {1,10,5,2,7};
        System.out.println(Ex14.smallestSubSum(arr2,9));

        int[] arr3 = {1,11,100,1,0,200,3,2,1,250};
        System.out.println(Ex14.smallestSubSum(arr3,280));

        int[] arr4 = {45,6,0};
        System.out.println(Ex14.smallestSubSum(arr4,51));

        System.out.println(Ex14.smallestSubSum(null,51));

//        long start = System.nanoTime();
//
//        for(int i=0;i<31;i++)
//        System.out.println("question 2 answer, for "+i+ ": " + Ex14.solutions(i));
//
//        long finish = System.nanoTime();
//
//        System.out.println("Total time: " + (finish - start));


        boolean[][] mat = { { false, true, false, true },
                            { true, true, true, false },
                            { false, false, true, false},
                            { true, false, true, false}};

        System.out.println("the amount of regions is: " + Ex14.cntTrueReg(mat));

    }
}
