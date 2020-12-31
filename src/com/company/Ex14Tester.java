package com.company;

public class Ex14Tester {

    public static void main(String[] args){
        int[] a = {1,1,3,3,2,2,5,5,2,2,1,1,3,3,5,3,3,1,1,2,2,7,7,6,6,3,3,4,4,5,5,6,6};
        System.out.println("arr size: "+a.length);
        System.out.println("the single number- " +Ex14.findSingle(a));

        System.out.println();

        int[] arr1 = {1,4,45,6,0,19};
        System.out.println(Ex14.smallestSubSum(arr1,51));

        int[] arr2 = {1,10,5,2,7};
        System.out.println(Ex14.smallestSubSum(arr2,9));

        int[] arr3 = {1,11,100,1,0,200,3,2,1,250};
        System.out.println(Ex14.smallestSubSum(arr3,280));

        int[] arr4 = {45,6,0};
        System.out.println(Ex14.smallestSubSum(arr4,51));
    }
}
