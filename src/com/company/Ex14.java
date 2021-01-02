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
     * The run-time complexity of this program is O(n) - because at the worst case in my method is 2n meaning the minimal
     * sub-array will be the 2 last spots in my array so i haded scanned the entire array (n) with my index_Start and another scan
     * with my index_End in the testing minimizing the sub-array but the index_Start will stop at last spot where pointing index_End
     * thus the run-time complexity of 2n is O(n).
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

        if(arr != null) { // In case you get an un-initialize array.
            while (index_End != arr.length) {
                if (arr[index_End] > x) {
                    return 1;
                } else {

                    sum += arr[index_End];
                    index_End++;

                    if (sum > x) {
                        while (index_Start != index_End && (sum - arr[index_Start]) > x) {
                            index_Start++;
                            sum -= arr[index_Start];
                        }
                        if (index_End - index_Start != 0) {
                            if (min_Size_Of_Sub_Arr == -1) {
                                min_Size_Of_Sub_Arr = index_End - index_Start;
                            } else {
                                min_Size_Of_Sub_Arr = Math.min(min_Size_Of_Sub_Arr, (index_End - index_Start));
                            }
                        }
                    }
                }
            }
        }
        return min_Size_Of_Sub_Arr;
    }

    /**
     * This method gets a whole positive number and return amount of solutions for this equation - x1 + x2 + x3 = num,
     * and this method also print each solution in separate line.
     * if num < 3 or num > 30 the method will return 0.
     * @param num The number this method going to calculate all the amount of solutions for this equation - x1 + x2 + x3 = num.
     * @return return amount of solutions for this equation - x1 + x2 + x3 = num,
     * and this method also print each solution in separate line.
     * if num < 3 or num > 30 the method will return 0.
     */
    public static int solutions (int num){
        // Assumptions:
        // x1,x2,x3 - are whole positive numbers between 1 - 10.
        // The order of the lines being printed don't matter.
        // I can't use any kind of loops!
        // I can use overloading.
        //TODO: fix my code and comment on everything! and make it pretty!!
        //TODO: if i pass 23 or 24 i get into infinate loop, and i don't understand why? - figure it out!!

        // If the num is lower then 3 or bigger then 30 the method will return 0.
        if(num < 3 || num > 30){
            return 0;
        }
        // Define variables:
        int x1 =1, x2 = 1, x3 = 1; // Set x1,x2 and x3 as 1 and going up each possibility in recursion to find all the possible solutions.
        int[] arr_All_Combinations = new int[228]; // Setting an array that will store each combination that i find to avoid printing doubles (through the recursion you end up through the same possibility few times).
        return solutions(x1,x2,x3,num,arr_All_Combinations); // Calling my private recursion method to run through all the possibilities.
    }

    /**
     *
     * @param mat
     * @return
     */
    public static int cntTrueReg (boolean[][] mat){

        int row = 0;
        int column = 0;


        return 0;
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

    // Requrstion method to calculate all the possibilities. return the amount of options.
    // x1 - The first number in the equation.
    // x2 - The second number in the equation.
    // x3 - The third number in the equation.
    // num - The number this method going to calculate all the amount of solutions for this equation - x1 + x2 + x3 = num.
    // arr_All_Combinations - an array that will store each combination that i find to avoid printing doubles (through the recursion you end up through the same possibility few times).
    // Return - The amount of solutions for this equation - x1 + x2 + x3 = num,
    //          and this method also print each solution in separate line.
    //          if num < 3 or num > 30 the method will return 0.
    public static int solutions(int x1, int x2, int x3, int num, int[] arr_All_Combinations){
        // The recursion stop point - if the sum is bigger then the wanted num then there is no point continue this up this direction.
        // Notice that x3 always will be = 1 because this is the minimal number he can be and yet must be considered,
        // also i want the recursion stop to be only depends on x1 and x2 as they the only indexes that i raise by 1 each time, i adjust x3 accordingly
        // so keep the temp value will break the recursion prematurely.
        // Also capping the size of each the numbers x1,x2,x3 to not go above 10 (as defined in the question).
        if(x1 + x2 + x3 > num || x1 > 10 || x2 > 10){
            return 0;
        }
        // Define an index that let me know where am i at in the array that hold all the possibilities.
        // A way to improve the code and make it way faster is to use a map and index the keys of each combination and thus reduces the run time.
        // also the fact i can't use loops make me use recursion to loop through the array i create in recursion.
        int index = openSpot(arr_All_Combinations,0); // openSpot is a private method i created to loop through my array of combinations and see if  i'm already have this combination.

        // To avoid infinite loops and 3^n run-time complexity i realized that x3 is the total of (num - x1 - x2)
        // therefore you don't need to run each of his possibilities and only run through x1 and x2 and see if there is a correct x3 for the combo -
        int temp_X3= num - x1 - x2;

        // Checking if the sum of x1,x2 and temp_X3 is equals to num and i don't have this combination yet or maximized the possibilities that exist (if i did index == -1)
        if(temp_X3 < 11 && x1 + x2 + temp_X3 == num && index != -1 && !isExistInArr(x1,x2,temp_X3,arr_All_Combinations,0, index)) {
            // Printing the current solution -
            System.out.println(x1 + " + " + x2 + " + " + temp_X3);
            // Adding the new combination to my array -
            arr_All_Combinations[index] = x1;
            arr_All_Combinations[index + 1] = x2;
            arr_All_Combinations[index + 2] = temp_X3;
            // Calling the recursion method again for each possibility and adding +1 to the return for the amount of solutions -
            return solutions((x1 + 1),x2, x3, num,arr_All_Combinations) + solutions(x1,(x2 + 1), x3, num,arr_All_Combinations) +1;
        }
        // Calling the recursion method again for the next possibility -
        return solutions((x1 + 1),x2, x3, num,arr_All_Combinations) + solutions(x1,(x2 + 1), x3, num,arr_All_Combinations);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //TODO: Remove in the end!
//    private static int solutions (int x1, int x2, int x3, int num, int[] arr_All_Combinations){
//        // The recursion stop point - if the sum is bigger then the wanted num then there is no point continue this up this direction.
//        // Also capping the size of each the numbers x1,x2,x3 to not go above 10 (as defined in the question).
//        if(x1 + x2 + x3 > num || x1 > 10 || x2 > 10 || x3 > 10){
//            return 0;
//        }
//        // Define an index that let me know where am i at in the array that hold all the possibilities.
//        // A way to improve the code and make it way faster is to use a map and index the keys of each combination and thus reduces the run time.
//        // also the fact i can't use loops make me use recursion to loop through the array i create in recursion.
//        int index = openSpot(arr_All_Combinations,0); // openSpot is a private method i created to loop through my array of combinations and see if  i'm already have this combination.
//
//        // Checking if the sum of x1,x2 and x3 is equals to num and i don't have this combination yet or maximized the possibilities that exist (if i did index == -1)
//        if(x1 + x2 + x3 == num && index != -1 && !isExistInArr(x1,x2,x3,arr_All_Combinations,0, index)){
//            // Printing the current solution -
//            System.out.println(x1 + " + " + x2 + " + " + x3);
//            // Adding the new combination to my array -
//            arr_All_Combinations[index] = x1;
//            arr_All_Combinations[index + 1] = x2;
//            arr_All_Combinations[index + 2] = x3;
//            // Calling the recursion method again for each possibility and adding +1 to the return for the amount of solutions -
//            return (solutions((x1 + 1),x2,x3,num,arr_All_Combinations) + solutions(x1,(x2 + 1),x3,num,arr_All_Combinations) + solutions(x1,x2,(x3 + 1),num,arr_All_Combinations)) + 1;
//        }
//        // Calling the recursion method again for each possibility -
//        return solutions((x1 + 1), x2, x3, num,arr_All_Combinations) + solutions(x1, (x2 + 1), x3, num,arr_All_Combinations) + solutions(x1, x2, (x3 + 1), num,arr_All_Combinations);
//    }
    //TODO: till here!@!
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    // This method get 3 numbers, arr, start point (index - start at zero always) and a stop_Point and return if the combination of x1,x2,x3 is exist in arr.
    // x1 - The first number in the equation.
    // x2 - The second number in the equation.
    // x3 - The third number in the equation.
    // num - The number this method going to calculate all the amount of solutions for this equation - x1 + x2 + x3 = num.
    // arr - an array that will store each combination that i find to avoid printing doubles (through the recursion you end up through the same possibility few times).
    // index - the pointer where i'm in the array, needed to keep track and continuously scan my arr, start at zero.
    // stop_Point - the last point that needed to be checked in the array to decide if this combination is in the array or not.
    // Return - True if the combination is already exist, False if it doesn't.
    private static boolean isExistInArr(int x1, int x2, int x3, int[] arr, int index, int stop_Point){
        // If i reached the end of spots fill with data or reached to an empty spot i will return false.
        //TODO - i think maybe the value zero test is unneccery but i need to verifiy this!
        if(index == stop_Point || arr[index] == 0)
            return false;

        // If i found my combination in this array i will return true (does exist) -
        if(x1 == arr[index] && x2 == arr[index+1] && x3 == arr[index+2])
            return true;

        // Recursion call to the next trio -
        return isExistInArr(x1,x2,x3,arr,index + 3, stop_Point);
    }

    // This method get an arr and a integer - spot (always start at zero), and will return the first open spot in the arr, if the arr is full the method will return -1.
    // arr - An array that will store each combination that i find to avoid printing doubles (through the recursion you end up through the same possibility few times).
    // spot - The pointer where i'm in the array, needed to keep track and continuously scan my arr, start at zero.
    // Return - The first open spot in the arr, if the arr is full the method will return -1.
    private static int openSpot(int[] arr,int spot){
        // If i got to the end of my arr then i will return -1.
        if(spot + 3 == arr.length)
            return -1;

        // If i got to an empty spot i will return this spot (the array can only hold integers between 1-10 included).
        if(arr[spot] == 0) {
            return spot;
        }
        // Recursion call to the next trio -
        return openSpot(arr,spot + 3);

    }
}
