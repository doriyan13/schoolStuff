package com.company;

public class PracticeForTest {
    public static int f(int[] array){
        return f(array,0,array.length-1);
    }

    private static int f(int[] array, int start, int end){
//        for(int i = start;i <end+1;i++){
//            System.out.print(array[i] +"\t");
//        }
//        System.out.println();
        if(start == end)
            return array[start];
        if(array[start] > array[start+1])
            return array[start];
        if(array[end] > array[end-1])
            return array[end];
        // Finding the middle spot in the sub-array -
        int middle;
        if((end - start) % 2 == 0)
            middle = (end - start) /2 +1;
        else
            middle = (end+1 - start)/2;
        // The middle item in the array is the peak -
        if(array[middle]> array[middle + 1] && array[middle] > array[middle -1] ){
            return array[middle];
        }
        // In the left side -
        if(array[middle] > array[middle + 1] ){
            return f(array, start, middle -1);
        }
        // In the right side -
        return f(array, (middle+ 1), end);
    }

    public static void crossSort(int[] arr){
        int e_Index = 0;
        int ne_Index = 1;
        boolean is_Done = false;
        while(is_Done == false){
            is_Done = true;
            while(e_Index +2 < arr.length-1 && ne_Index +2 < (arr.length)){

                if(arr[e_Index] > arr[e_Index+2]){
                    int temp = arr[e_Index];
                    arr[e_Index] = arr[e_Index+2];
                    arr[e_Index+2] = temp;
                    is_Done = false;
                }
                if(arr[ne_Index] < arr[ne_Index+2]){
                    int temp = arr[ne_Index];
                    arr[ne_Index] = arr[ne_Index+2];
                    arr[ne_Index+2] = temp;
                    is_Done = false;
                }
                e_Index+=2;
                ne_Index+=2;
            }
            e_Index = 0;
            ne_Index = 1;
        }
    }

    public static int countFriends(int n){
        int index = 1;
        int first_Sum = 0;
        int sec_Sum = 0;
        int pairs = 0;
        int number_skip = 0;

        while(index < n ){
            first_Sum = divideSum(index);
            sec_Sum = divideSum(first_Sum);
            if(sec_Sum == index && first_Sum != index && index !=number_skip) {
                number_skip = first_Sum;
                pairs++;
            }
            index++;
        }
        return pairs;
    }
    // getting all the dividers until integer end.
    private static int divideSum(int end){
        int start = 1;
        int sum = 0; // 1 divide in every number;
        while(start < end){
            if(end % start == 0) sum+=start;
            start++;
        }
        return sum;
    }

    public static int oneFiveSeven (int n){
        if(n <= 0) return 0;
        int counter1  = n+1, counter2  = n+1, counter3  = n+1;
        //test if +1:
        if(n>=1)
        counter1  =  1 + oneFiveSeven(n-1);
        //test if +5:
        if(n>=5)
        counter2  =  1 + oneFiveSeven(n-5);
        //test if +7:
        if(n>=7)
        counter3  = 1 + oneFiveSeven(n-7);

        //returning the fastest path:
        if(counter1 <= counter2 && counter1 <= counter3) return counter1;
        else if(counter2 <= counter1 && counter2 <= counter3) return counter2;
        return counter3;
    }

    public static int number (int g1, int g2){
        if( (g1 == 0) || (g2 == 0)){
            return 1;
        }
        int counter = 0;
        if(g1 > 0) counter += number(g1-1,g2);
        if(g2> 0) counter += number(g1,g2-1);
        return counter;
    }




    public static void main(String[] args){
        int x,y=15;
        int[] a1 = {1,2,3,4,5,999,5,4,3,2,1};
        int[] a2 = {1,999,6,5,4,3,2,1};
        int[] a3 = {1,2,3,999};
        int[] a4 = {999,6,5,4,3,2,1};
        int[] a5 = {1,999,6,5,4,3,2,1};
        int[] a6 = {1,2,999,6,5,4,3,2,1};
        int[] a7 = {1,2,3,999,6,5,4,3,2,1};
        int[] a8 = {1,2,3,4,999,6,5,4,3,2,1};
        int[] a9 = {1,2,3,4,5,999,5,4,3,2,1};
        int[] a11 = {1,2,3,4,5,6,999,3,2,1};

        System.out.println(f(a1));
        System.out.println(f(a2));
        System.out.println(f(a3));
        System.out.println(f(a4));
        System.out.println(f(a5));
        System.out.println(f(a6));
        System.out.println(f(a7));
        System.out.println(f(a8));
        System.out.println(f(a9));
        System.out.println(f(a11));

        int[] crossTest = {20,5,7,8,9,15,3,10,11,3};
        for(int i = 0;i <=crossTest.length-1;i++){
            System.out.print(crossTest[i] +"\t");
        }
        System.out.println();
        crossSort(crossTest);
        System.out.println("!!!!!!!!!!!!!!!!!!!!");
        System.out.println("this is the result: ");
            for(int i = 0;i <=crossTest.length-1;i++){
                System.out.print(crossTest[i] +"\t");
            }
        System.out.println();
        int countFriendsTest = countFriends(9000);
        System.out.println("the number is: " + countFriendsTest);

        System.out.println("the min amount of figures: " + oneFiveSeven( 10));

        System.out.println("this is number of paths: "+ number(3,2));
    }

}
