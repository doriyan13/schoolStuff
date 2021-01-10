package com.company;

/**
 *  This class hold all the methods for Maman 14.
 * @author Doriyan Esterin/206765844.
 * @version 31/12/2020.
 */
public class Ex14 {
    //TODO: Write API for all the methods.
    //TODO: write the complex runTime as part of the API
    //TODO: all the methods must be in this class!
    //TODO: varify that i worte all the class names correctly and test the class in BlueJ!

    /**
     * This method that get an Array that each number in the array will appear twice in a row (one after the another), except one.
     * The method return the number that appears only once.
     * The run-time complexity of this program is O(log n) - because i find the middle of the array each time and choose which half i need to continue testing and ignore the second part each time (it's like a binary search therefore it's log n)
     * @param a Array that each number in the array will appear twice, except one.
     * @return Return the number that appears only once.
     */
    public static int findSingle (int[] a){
        // Assumptions:
        // a isn't empty - each number in the array will appear twice in a row (one after the another), except one.
        // a indeed follow the definition of the Array needed in this method.

        // Variables:
        int single_Number; // Will hold the single number in the array a.
        int start_Of_Array = 0; // Index that point to the first spot in the a.
        int end_Of_Array = (a.length - 1); // Index that point to the last spot in the a.
        int possibilities = (a.length + 1) / 2; // The amount of option the single number can be in (will always be the length of the array +1 divide by 2).

        if(possibilities % 2 == 0){
            // Calling a private method i created for an arr that have even amount of possibilities:
            single_Number = findSingleEvenPossibilitiesArray(a,start_Of_Array,end_Of_Array);
        }
        else{
            // Calling a private method i created for an arr that don't have even amount of possibilities:
            single_Number = findSingleNotEvenPossibilitiesArray(a,start_Of_Array,end_Of_Array);
        }
        return single_Number; // Returning the single number in a.
    }

    /**
     * This method get an Array and return the minimal sub-array that will be bigger then x.
     * The run-time complexity of this program is O(n) - because at the worst case in my method is 2n meaning the minimal
     * sub-array will be the 2 last spots in my array so i haded scanned the entire array (n) with my index_Start and another scan
     * with my index_End in the testing minimizing the sub-array but the index_Start will stop at last spot where pointing index_End
     * in conclusion the run-time complexity of 2n is O(n).
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
                // If single spot is bigger then the sum then that's mean the minimal sub-array will be 1 -
                if (arr[index_End] > x) {
                    return 1;
                }
                else {
                    // Try adding another spot to the total sum to test if now you have a sum that bigger then x -
                    sum += arr[index_End];
                    index_End++;

                    if (sum > x) {
                        // If you got a sum that is bigger then x, try trim spots from the start to see if you still can get smaller sub-array -
                        while (index_Start != index_End && (sum - arr[index_Start]) > x) {
                            index_Start++;
                            sum -= arr[index_Start];
                        }
                        if (index_End - index_Start != 0) {
                            if (min_Size_Of_Sub_Arr == -1) { // If this is the first time i fill min_Size_Of_Sub_Arr -
                                min_Size_Of_Sub_Arr = index_End - index_Start;
                            } else {
                                // Keep track of the smallest sub-array i find -
                                min_Size_Of_Sub_Arr = Math.min(min_Size_Of_Sub_Arr, (index_End - index_Start));
                            }
                        }
                    }
                }
            }
        }
        return min_Size_Of_Sub_Arr; // Return the smallest sub-array number of spots that i find.
    }

    /**
     * This method gets a whole positive number and return amount of solutions for this equation - x1 + x2 + x3 = num,
     * and this method also print each solution in separate line.
     * @param num The number this method going to calculate all the amount of solutions for this equation - x1 + x2 + x3 = num.
     * @return return amount of solutions for this equation - x1 + x2 + x3 = num,
     * and this method also print each solution in separate line.
     * if num < 3 or num > 30 the method will return 0.
     */
    public static int solutions (int num){
        // Assumptions:
        // x1,x2,x3 - are whole positive numbers between 1 - 10 (including 1 and 10).
        // The order of the lines being printed don't matter.
        // I can't use any kind of loops!
        // I can use overloading.

        // If the num is lower then 3 or bigger then 30 the method will return 0.
        if(num < 3 || num > 30){
            return 0;
        }
        // Define variables:
        int x1 =1, x2 = 1, x3 = 1; // Set x1,x2 and x3 as 1 and going up each possibility in recursion to find all the possible solutions.
        int[] arr_All_Combinations = new int[228]; // Setting an array that will store each combination that i find to avoid printing doubles (through the recursion you may end up through the same possibility few times).

        // Calling my private recursion method to run through all the possibilities.
        return solutions(x1,x2,x3,num,arr_All_Combinations);
    }

    /**
     * This method get a boolean square matrix and return the amount of true different regions.
     * @param mat A boolean square matrix.
     * @return Return the amount of true different regions.
     */
    public static int cntTrueReg (boolean[][] mat){
        // Assumptions:
        // the matrix array is a square matrix - amount of rows == amount of columns.
        // A true region is at least 1 spot in the matrix.

        // Define variables -
        int row = 0;
        int column = 0;

        // Call the recursion method that calculate the amount of true regions -
        return cntTrueReg(mat,row,column);
    }

    //----------------------------------------------------------------------------------------------------------------------------------
    // ***************************************************************************
    // Private methods i wrote in this Maman (14) to build cleaner public methods:
    // ***************************************************************************

    // This method get an Array that each number in the array will appear twice in a row (one after the another), except one.
    // the array have even amount of possibilities the single number can be in.
    // a - an Array that each number in the array will appear twice in a row (one after the another), except one.
    // start_Of_Array - index of the start of the array.
    // end_Of_Array - index of the ent of the array.
    // Return - the single number.
    private static int findSingleEvenPossibilitiesArray(int[] a, int start_Of_Array, int end_Of_Array){
        // Define variables -
        int middle;
        // Will look through the array until my starting index pass my ending index of the array -
        while (start_Of_Array < end_Of_Array){
            if(a[start_Of_Array] != a[start_Of_Array + 1]){
                return a[start_Of_Array];
            }
            if(a[end_Of_Array] != a[end_Of_Array - 1]){
                return a[end_Of_Array];
            }
            // Finding the middle spot of the array -
            middle = (end_Of_Array + start_Of_Array) / 2;
            // When i have only 3 or less spots to check then i can divide the possibilities to 3 -
            if((end_Of_Array - 2) - (start_Of_Array + 2) < 3){ // I do -2 because in the 2 if's before i tested the 2 spots of the start and 2 spots in the end -
                if((start_Of_Array + 1) == (middle - 1) && (end_Of_Array - 1) == (middle + 1)){ // In this scenario you will be left only with the final middle spot.
                    return a[middle];
                }
                if(a[middle - 1] != a[middle]){ // In this scenario it will be the left spot to the middle -
                    return a[middle - 1];
                }
                else { // Finally if it's not the middle spot or the left spot it must be the right spot of the trio -
                    return a[middle +1];
                }
            }
            if(a[middle - 1] != a[middle]){ // Continue only on the left half -
                end_Of_Array =middle - 1;
                start_Of_Array+=2;
            }
            else { // Continue only on the right half -
                start_Of_Array = middle+1;
                end_Of_Array-=2;
            }
        }
        return a[start_Of_Array]; // Will get here if start_Of_Array == end_Of_Array , and in this scenario that's mean the single number is the final spot left (it's doesn't matter if you choose the start index or the end index because in this scenario they are equals).
    }

    // This method get an Array that each number in the array will appear twice in a row (one after the another), except one.
    // the array don't have even amount of possibilities the single number can be in.
    // a - an Array that each number in the array will appear twice in a row (one after the another), except one.
    // start_Of_Array - index of the start of the array.
    // end_Of_Array - index of the ent of the array.
    // Return - the single number.
    private static int findSingleNotEvenPossibilitiesArray(int[] a, int start_Of_Array, int end_Of_Array){
        // Define variables -
        int middle;

        while (start_Of_Array < end_Of_Array){
            if(a[start_Of_Array] != a[start_Of_Array + 1]){
                return a[start_Of_Array];
            }
            if(a[end_Of_Array] != a[end_Of_Array - 1]){
                return a[end_Of_Array];
            }

            middle = (end_Of_Array + start_Of_Array) / 2;

            if((end_Of_Array - 2) - (start_Of_Array + 2) < 3){
                // In this scenario you will be left only with the final middle spot -
                if((start_Of_Array + 1) == (middle - 1) && (end_Of_Array - 1) == (middle + 1)){
                    return a[middle];
                }
                if(a[middle - 1] != a[middle]){ // In this scenario it will be the left spot to the middle -
                    return a[middle - 1];
                }
                else {
                    return a[middle +1]; // Finally if it's not the middle spot or the left spot it must be the right spot of the trio -
                }
            }
            if(a[middle - 1] == a[middle]){ // Continue only on the left half -
                end_Of_Array =middle - 2;
                start_Of_Array+=2;
            }
            else { // Continue only on the right half -
                start_Of_Array = middle+2;
                end_Of_Array-=2;
            }
        }
        return a[start_Of_Array];  // Will get here if start_Of_Array == end_Of_Array , and in this scenario that's mean the single number is the final spot left (it's doesn't matter if you choose the start index or the end index because in this scenario they are equals).
    }
//TODO: finish to go over this part and you done! (@DoriyanEsterin) -

    // Recursion method to calculate all the possibilities. return the amount of options.
    // x1 - The first number in the equation.
    // x2 - The second number in the equation.
    // x3 - The third number in the equation.
    // num - The number this method going to calculate all the amount of solutions for this equation - x1 + x2 + x3 = num.
    // arr_All_Combinations - an array that will store each combination that i find to avoid printing doubles (through the recursion you end up through the same possibility few times).
    // Return - The amount of solutions for this equation - x1 + x2 + x3 = num,
    //          and this method also print each solution in separate line.
    //          if num < 3 or num > 30 the method will return 0.
    public static int solutions(int x1, int x2, int x3, int num, int[] arr_All_Combinations){
        // The recursion stop point - when all the 3 numbers x1,x2,x3 got to 10;
        if(x1 == 10 && x2 == 10 && x3 == 10){
            return 0;
        }
        // Define an index that let me know where am i at in the array that hold all the possibilities.
        // A way to improve the code and make it way faster is to use a map and index the keys of each combination and thus reduces the run time.
        // also the fact i can't use loops make me use recursion to loop through the array i create in recursion.
        int index = openSpot(arr_All_Combinations,0); // openSpot is a private method i created to loop through my array of combinations and see if  i'm already have this combination.

        // Checking if the sum of x1,x2 and x3 is equals to num and i don't have this combination yet or maximized the possibilities that exist (if i did index == -1)
        if(x1 + x2 + x3 == num && index != -1 && !isExistInArr(x1,x2,x3,arr_All_Combinations,0, index)) {
            // Printing the current solution -
            System.out.println(x1 + " + " + x2 + " + " + x3);
            // Adding the new combination to my array -
            arr_All_Combinations[index] = x1;
            arr_All_Combinations[index + 1] = x2;
            arr_All_Combinations[index + 2] = x3;
            // Calling the recursion method again and adding +1 to the return for the amount of solutions -
            return solutions(x1,x2,x3,num,arr_All_Combinations) + 1;
        }
        // My recursion will loop (recursively) through the options : (and do the tests for each option)
        if(x1>=10){
            if(x2>=10){
                x3++;
                x2=1;
            }
            else {
                x2++;
            }
            x1=1;
        }
        else{
            x1++;
        }
        // Calling the recursion method again with the new x1,x2,x3 values accordingly -
        return solutions(x1,x2,x3,num,arr_All_Combinations);
    }

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
        // Also testing that stop_Point isn't -1 because i give the index that i calculate in openSpot method which can return -1 as an stop_Point
        if(index == stop_Point || arr[index] == 0 || stop_Point == -1)
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

    // This method get a boolean square matrix and return the amount of true different regions.
    // mat - a boolean matrix.
    // row - the current row in the matrix.
    // column - the current column in the matrix.
    // Return - return the amount of true different regions.
    private static int cntTrueReg (boolean[][] mat,int row, int column){
        if(row == mat.length){
            return 0;
        }

        if(column == mat[0].length){
            return cntTrueReg(mat,(row + 1),0);
        }

        if(mat[row][column] == true){
            findAllRegion(mat,row,column); // Calling the method that find all the related true spot of the current region and change them to false (to prevent count them twice).
            return cntTrueReg(mat,row,(column + 1)) + 1;
        }
        else{
            return cntTrueReg(mat,row,(column + 1));
        }
    }

    // This method get a boolean square matrix and find all the related true spots of this region and switch them to false.
    // mat - a boolean matrix.
    // row - the current row in the matrix.
    // column - the current column in the matrix.
    private static void findAllRegion (boolean[][] mat,int row, int column){
        if(column == mat[0].length || column < 0 || row == mat.length || row == -1 || mat[row][column] == false)
            return;

        // If it didn't got into the first if then it must be 'True' -
        mat[row][column] = false;

        if(row + 1 < mat[0].length)
            findAllRegion(mat,(row + 1),column); // Continue check one row under.

        findAllRegion(mat,row,(column + 1)); // Continue check to the right.
        findAllRegion(mat,row,(column - 1)); // Continue check to the left.
        findAllRegion(mat,(row - 1),column); // Continue check to Up.
    }
    //----------------------------------------------------------------------------------------------------------------------------------
}
