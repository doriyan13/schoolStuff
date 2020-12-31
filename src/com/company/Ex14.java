package com.company;
/**
 *  This class hold all the methods for maman 14.
 * @author Doriyan Esterin/206765844.
 * @version 31/12/2020.
 */
public class Ex14 {
    //TODO: Write API for all the methods.
    //TODO: write the complex runTime as part of the API
    //TODO: all the methods must be in this class!

    /**
     * This method that get an Array that each number in the array will appear twice in a row (one after the another), except one.
     * The method return the number that appears only once.
     * *****
     * not sure that my program is O(n), i still need to think if this is the most efficent way?!
     * The run-time complexity of this program is O(n) - because even though i only loop trough the array n/4 times it's still O(n).
     * *****
     * @param a Array that each number in the array will appear twice, except one.
     * @return Return the number that appears only once.
     */
    public static int findSingle (int[] a){
        // Assumptions:
        // a isn't empty.
        // a indeed follow the definition of the Array needed in this method.

        // Variables:
        int single_Number; // Will hold the single number in the array a.
        int start_Of_Array = 0; // Index that point to the first spot in the a.
        int end_Of_Array = (a.length - 1); // Index that point to the last spot in the a.
        int possibilities = (a.length + 1) / 2; // The amount of option the single number can be in.

        if(possibilities%2 == 0){
            // Calling a private method i created for an arr that have even amount of possibilities:
            single_Number = findSingleEvenPossibilitiesArray(a,start_Of_Array,end_Of_Array,possibilities);
        }
        else{
            // Calling a private method i created for an arr that don't have even amount of possibilities:
            single_Number = findSingleNotEvenPossibilitiesArray(a,start_Of_Array,end_Of_Array,possibilities);
        }
        return single_Number; // Returning the single number in a.
    }

    /**
     * This method that get an Array and return the minimal sub-array that will be bigger then x.
     * *****
     * not sure that my program is O(n)
     * The run-time complexity of this program is O(n) - because //TODO!!!
     * *****
     * @param arr An array of whole and positive numbers.
     * @param x A whole positive number that we need to find the minimal sub-array bigger then him.
     * @return Return the minimal sub-array that will be bigger then x.
     */
    public static int smallestSubSum (int arr[], int x){
        // Define variables:
        int index_Start = 0;
        int index_End = 0;
        int sum = 0;
        int min_Size_Of_Sub_Arr = -1;

        while(index_End != arr.length){
            if(arr[index_End] > x){
                return 1;
            }
            else if (arr[index_End] < x){

                sum+=arr[index_End];
                index_End++;

                if(sum > x){
                    while (index_Start != index_End && (sum - arr[index_Start]) > x ){
                        index_Start ++;
                        sum -= arr[index_Start];
                    }
                    if(index_End - index_Start != 0) {
                        if(min_Size_Of_Sub_Arr == -1){
                            min_Size_Of_Sub_Arr = index_End - index_Start;
                        }
                        else{
                            min_Size_Of_Sub_Arr = Math.min(min_Size_Of_Sub_Arr, (index_End - index_Start));
                        }
                    }
                }
            }
        }
        return min_Size_Of_Sub_Arr;
    }

    // This method get an Array that each number in the array will appear twice in a row (one after the another), except one.
    // the array have even amount of possibilities the single number can be in.
    // a - an Array that each number in the array will appear twice in a row (one after the another), except one.
    // start_Of_Array - index of the start of the array.
    // end_Of_Array - index of the ent of the array.
    // possibilities - the amount of possibilities the single number can be in.
    // Return - the single number.
    private static int findSingleEvenPossibilitiesArray(int[] a, int start_Of_Array, int end_Of_Array, int possibilities){
        int tries  = 0;
        while (tries != (possibilities / 2)){
            if(a[start_Of_Array] != a[start_Of_Array + 1]){
                return a[start_Of_Array];
            }
            if(a[end_Of_Array] != a[end_Of_Array - 1]){
                return a[end_Of_Array];
            }
            start_Of_Array+=2;
            end_Of_Array-=2;
            tries++;
        }
        return 404; // to prevent syntax, the method shouldn't return it because the assumption is that i will get an array that will hold a 1 different number.
    }

    // This method get an Array that each number in the array will appear twice in a row (one after the another), except one.
    // the array don't have even amount of possibilities the single number can be in.
    // a - an Array that each number in the array will appear twice in a row (one after the another), except one.
    // start_Of_Array - index of the start of the array.
    // end_Of_Array - index of the ent of the array.
    // possibilities - the amount of possibilities the single number can be in.
    // Return - the single number.
    private static int findSingleNotEvenPossibilitiesArray(int[] a, int start_Of_Array, int end_Of_Array, int possibilities){
        int tries  = 0;
        while (tries != (possibilities / 2)){
            if(a[start_Of_Array] != a[start_Of_Array + 1]){
                return a[start_Of_Array];
            }
            if(a[end_Of_Array] != a[end_Of_Array - 1]){
                return a[end_Of_Array];
            }
            start_Of_Array+=2;
            end_Of_Array-=2;
            tries++;
        }
        return a[tries-1]; // when you don't have an even amount of possibilities the middle spot also can be the single number.
    }
}
