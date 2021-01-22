 package com.company;
/**
 *  Represents a int NodeList that will represent a number with large amounts of figures.
 * @author Doriyan Esterin/206765844.
 * @version 12/01/2021.
 */
public class BigNumber {

    //TODO: go over all of my Time and Place complexity explanations to be sure! ~

    //Assumptions -
    // This method will get only non-negative numbers, which means only positive and zero.
    // The NodeList must be only one-way.
    // We can't add any class variables.
    // We can add private methods.
    // We can use the class IntNode yet we cannot use any other methods or classes in this class.
    // All the mathematics methods will not change the original BigNumbers.
    // In all the methods in this class you can't switch the NodeList to a number and edit him and then return it to a NodeList in the end.

    // Define class variables -
    private IntNode _head; // Will always point to the last figure in my BigNumber.

    /**
     * Empty Constructor - create new BigNumber that hold only 0 as default.
     * Time complexity - O(1), because you only do 1 action. (don't have any dependency on the input of the client)
     * Place complexity - O(1), because you only create 1 instance which don't have any dependency on the input of the client.
     */
    public BigNumber(){
        _head = new IntNode(0);
    }

    /**
     * This method is getting a long number, and create a new NodeList that will represent this number.
     * Time complexity - O(n), because you have to run through all the figures of the number you get (and the size of num different the amount of loops you will do).
     * Place complexity - O(n), because you have to run through all the figures of the number you get and create new IntNode for each one (and the size of num different the amount of loops you will do).
     * @param num A long number.
     */
    public BigNumber(long num){
        if(num == 0){
            _head = new IntNode(0);
        }
        else{
            // First i define the last number as the head of my NodeList -
            _head = new IntNode((int) num % 10);
            IntNode curr_Node = _head;

            // Now i'm going to loop throughout the rest of the number and connect the rest of the number figures -
            while((num / 10) >0){
                num = num / 10;
                curr_Node.setNext(new IntNode((int) num % 10));
                curr_Node = curr_Node.getNext();
            }
        }
    }

    /**
     * This method get a BigNumber and create a new copy of this NodeList.
     * Time complexity - O(n), because you have to run through all the figures of the BigNumber you get (and the size of big_Num different the amount of loops you will do).
     * Place complexity - O(n), because you have to run through all the figures of the BigNumber you get and create new IntNode for each one (and the size of big_Num different the amount of loops you will do).
     * @param big_Num a BigNumber instance, which is a NodeList that represent a very long number.
     */
    public BigNumber(BigNumber big_Num){
        if(big_Num._head == null){
            _head = new IntNode(0);
        }
        else{
            // First i define the last number as the head of my NodeList -
            _head = new IntNode(big_Num._head.getValue());
            IntNode curr_Node_New = _head;
            IntNode big_Num_Index = big_Num._head.getNext();

            // Now i'm going to loop throughout the rest of the list and copy the rest of the number -
            while(big_Num_Index != null){
                curr_Node_New.setNext(new IntNode(big_Num_Index.getValue()));
                curr_Node_New = curr_Node_New.getNext();
                big_Num_Index = big_Num_Index.getNext();
            }
        }
    }

    /**
     * This method return a String that represents a BigNumber.
     * Time complexity - O(n), because you have to run through all the figures of the current BigNumber you have once (and the size of the BigNumber different the amount of loops you will do).
     * Place complexity - O(1), because you only create 2 instances which don't have any dependency on the input of the client thus it will be O(1).
     * @return A String that represents a BigNumber.
     */
    public String toString(){
        // Define variables -
        String result = "" + this._head.getValue(); // The String that will hold the final result.
        IntNode curr_Node = _head.getNext(); // An Index that will let me go through my NodeList.

        while(curr_Node != null){
            if(curr_Node.getValue() != 0 || curr_Node.getNext() != null){
                result = curr_Node.getValue() + result; // Take the current figure and cast it to a string and add it as the first char in the result String.
            }
            // Getting the next figure in the number -
            curr_Node = curr_Node.getNext();
        }
        // Return the final String -
        return result;
    }

    /**
     * This method comparing between 2 BigNumbers and will return a integer value that represent which one is bigger.
     * Time complexity - O(n), because in the worst scenario you have to reverse the figures of both of the BigNumbers (which is O(n)) and run through all the figures of the bigger BigNumber
     * you have once (and the size of the BigNumber different the amount of loops you will do but still keep you in O(n)) thus the time complexity will remain O(n).
     * Place complexity - O(n), because you create a one copy of each BigNumber to reverse them and then start comparing them therefore the place complexity is depends on the size of the BigNumbers you get
     * so it must be O(n), and it's only O(n) and not O(n^2) because you create each copy once and only once thus it will remain O(n).
     * @param other a BigNumber instance, which is a NodeList that represent a very long number.
     * @return if the BigNumber that the method was used on is smaller then the other BigNumber then
     * the return value will be -1 if it was bigger then it will return 1 and if they are equal the method will return 0.
     */
    public int compareTo(BigNumber other){
        // Define variables -
        // I chose long because logically the BigNumber can be very very long number and i don't want to limit my method.
        // If we could i would use even bigger type to let my method handle any size of BigNumber but long is the biggest primitive type we learned in this course.
        long curr_Amount_Of_Figures = this.length(); // Will hold the number of figures my Current BigNumber have.
        long other_Amount_Of_Figures = other.length(); // Will hold the number of figures my Other BigNumber have.

        // If the Current BigNumber have more figures then Other then he must be bigger -
        if(curr_Amount_Of_Figures > other_Amount_Of_Figures){
            return 1;
        }
        // If the Current BigNumber have less figures then Other then he must be smaller -
        if(curr_Amount_Of_Figures < other_Amount_Of_Figures){
            return -1;
        }
        // If both of them have only 1 figure -
        if(curr_Amount_Of_Figures == 1 && other_Amount_Of_Figures == 1){
            // If they are equal -
            if(this._head.getValue() == other._head.getValue()){
                return 0;
            }
            // If the Current BigNumber bigger then Other -
            else if(this._head.getValue() > other._head.getValue()){
                return 1;
            }
            // If not then the Current BigNumber is smaller then Other -
            else{
                return -1;
            }
        }
        // If both the BigNumbers have equal amount of figures -
        // Create a copy of each Big Number and reverse their pointers - (to start comparing from the biggest figure to the smallest)
        BigNumber rev_Curr_Big_Number = new BigNumber(this);
        BigNumber rev_Other_Big_Number = new BigNumber(other);
        // Reversing the BigNumbers copy -
        rev_Curr_Big_Number.reverse();
        rev_Other_Big_Number.reverse();
        // Create an Index for each BigNumber copy -
        IntNode curr_Index = rev_Curr_Big_Number._head;
        IntNode other_Index = rev_Other_Big_Number._head;
        // Will enter this loop only when both of them are equal in size therefore you need to watch only one of them -
        while(curr_Index != null){
            // Current BigNumber is bigger then other -
            if(curr_Index.getValue() > other_Index.getValue()){
                return 1;
            }
            // Current BigNumber is smaller then other -
            if(curr_Index.getValue() < other_Index.getValue()){
                return -1;
            }
            // If both of them are still equal continue to the next one -
            curr_Index = curr_Index.getNext();
            other_Index = other_Index.getNext();
        }
        // If they are equal then return 0 -
        return 0;
    }

    /**
     * This method is getting 1 BigNumber and return a new BigNumber which is the addition of the current BigNumber and the one you get.
     * Time complexity - O(n), because in the worst scenario you firstly have to run n + m times to compare between them once and then run n times which represent the amount of figures the Bigger BigNumber have between the both of them.
     * Therefore the Time complexity will remain O(n).
     * Place complexity - O(n), because i create a new BigNumber that represent the addition of 2 BigNumbers and i must create a copy so for each final figure i must create a new IntNode once.
     * Therefore i will have in the worst scenario n+1 new figures that i must create so the place complexity will be O(n).
     * @param other a BigNumber instance, which is a NodeList that represent a very long number that i will add to my current number.
     * @return Return a new BigNumber which is the addition of the current BigNumber and the one you get.
     */
    public BigNumber addBigNumber (BigNumber other){
        // Will hold my result -
        BigNumber result = new BigNumber();

        // If This BigNumber is bigger then other -
        if(this.compareTo(other) == 1){
            return addTwoBigNumbers(this,other,result);
        }
        // If this not bigger then other is bigger or equal to him -
        else{
            return addTwoBigNumbers(other,this,result);
        }
    }

    /**
     * This method is getting 1 Long and return a new BigNumber which is the addition of the current BigNumber and the long you get.
     * Time complexity - O(n), because in the worst scenario you firstly have to run n + m times to compare between them once and then run n times which represent the amount of figures the Bigger BigNumber have between the both of them.
     * Therefore the Time complexity will remain O(n).
     * Place complexity - O(n), because i create a new BigNumber that represent the addition of 2 BigNumbers and i must create a copy so for each final figure i must create a new IntNode once.
     * Therefore i will have in the worst scenario n+1 new figures that i must create so the place complexity will be O(n).
     * @param num - a Long instance, which i will add to my current number.
     * @return Return a new BigNumber which is the addition of the current BigNumber and the long you get.
     */
    public BigNumber addLong (long num){
        // Create a BigNumber that will represent the num you get -
        BigNumber num_Big_Number = new BigNumber(num);
        // Return a new BigNumber that represents the addition of the 2 BigNumbers -
        return this.addBigNumber(num_Big_Number);
    }

    /**
     * This method is getting 1 BigNumber and return a new BigNumber which is the subtract of the bigger number then the other BigNumber.
     * Time complexity - O(n), because in the worst scenario you firstly have to run n + m times to compare between them 4 times and then run n times which represent the amount of figures the Bigger BigNumber have between the both of them.
     * Therefore the Time complexity will remain O(n).
     * Place complexity - O(n), because i create a new BigNumber that represent the subtract of 2 BigNumbers and i must create a copy so for each final figure i must create a new IntNode once.
     * Therefore i will have in the worst scenario n new figures that i must create so the place complexity will be O(n). (the subtract make the bigger BigNumber keep the amount of figures he started with).
     * @param other a BigNumber instance, which is a NodeList that represent a very long number.
     * @return Return a new BigNumber which is the subtract of the bigger number then the other BigNumber.
     */
    public BigNumber subtractBigNumber(BigNumber other){
        // Will hold my result -
        BigNumber result = new BigNumber(0); // Because this is subtract action i will copy the original number and then edit it!

        // If they are equal -
        if(this.compareTo(other) == 0){
            return new BigNumber(0);
        }
        // If the Current BigNumber equal to 0 -
        if(this.compareTo(result) == 0){
            return new BigNumber(other);
        }
        // If the other BigNumber equal to 0 -
        if(other.compareTo(result) == 0){
            return new BigNumber(this);
        }
        // If This BigNumber is bigger then other -
        else if(this.compareTo(other) == 1){
            return subtractTwoBigNumbers2(this,other,new BigNumber(this));
        }
        // If this not equal to other and the other BigNumber is bigger then him, he must be smaller then him -
        else{
            return subtractTwoBigNumbers2(other,this,new BigNumber(other));
        }
    }

    /**
     * This method is getting 1 BigNumber and return a new BigNumber which is the multiplication of the BigNumber i get and the current BigNumber i have.
     * Time complexity - O(n^2), because in the worst scenario you firstly have to run n + m times to compare between them 2 times and then run n^2 times because you have to multiply each
     * figure of the first BigNumber with each figure of the other BigNumber, therefore the time complexity will be O(n^2).
     * Place complexity - O(n), because i create a new BigNumber that represent the multiply of 2 BigNumbers and i must create a copy so for each final figure i must create a new IntNode once.
     * Therefore i will have in the worst scenario n new figures plus k figures which will be add as the result of the multiplication but this still remain O(n).
     * @param other a Long instance, which i will multiply with my current number.
     * @return Return a new BigNumber which is the multiplication of the BigNumber i get and the current BigNumber i have.
     */
    public BigNumber multBigNumber (BigNumber other){
        // Will hold my result -
        BigNumber result = new BigNumber();

        // If one of the 2 BigNumber is 0 i will return 0 -
        if(this.compareTo(result)==0 || other.compareTo(result)== 0){
            return result;
        }
        // If This BigNumber is bigger then other -
        if(this.compareTo(other) == 1){
            return multiplyTwoBigNumbers(this,other,result); // Return a new BigNumber which is the multiplication of the BigNumber i get and the current BigNumber i have.
        }
        // If my current BigNumber is not bigger then the other BigNumber then other is bigger or equal to my current BigNumber -
        else{
            return multiplyTwoBigNumbers(other,this,result); // Return a new BigNumber which is the multiplication of the BigNumber i get and the current BigNumber i have.
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    // ***************************************************************************
    // Private methods i wrote in this Maman (15) to build cleaner public methods:
    // ***************************************************************************

    //
    private BigNumber addTwoBigNumbers(BigNumber bigger_Big_Number , BigNumber other, BigNumber result){
        IntNode curr_Index = bigger_Big_Number._head;
        IntNode other_Index =other._head;
        boolean flag = true;

        int temp_Sum = 0;
        IntNode result_Index = result._head;

        while (curr_Index != null){

            temp_Sum = curr_Index.getValue() + other_Index.getValue();

            if(curr_Index.getNext() != null && result_Index.getNext() == null) {
                result_Index.setNext(new IntNode(0));
            }

            if(temp_Sum >= 10){
                if(result_Index.getNext() == null) {
                    // Create the next spot and going to point it -
                    result_Index.setNext(new IntNode(0));
                }

                if(curr_Index.getNext() != null) {
                    result_Index.getNext().setValue(temp_Sum / 10);
                }
                else{
                    result_Index.getNext().setValue(result_Index.getNext().getValue() + (temp_Sum / 10));
                }
            }
            result_Index.setValue(result_Index.getValue() + (temp_Sum % 10));
            temp_Sum = 0;

            if(other_Index.getNext() != null && flag == true){
                other_Index = other_Index.getNext();
            }
            else if(other_Index.getNext() == null && other_Index.getValue() != 0){
                other_Index = new IntNode(0);
                flag = false;
            }

            // Getting the next figure
            curr_Index = curr_Index.getNext();
            result_Index = result_Index.getNext();
        }
        return result;
    }

    //
    private BigNumber subtractTwoBigNumbers2(BigNumber bigger_Big_Number , BigNumber other, BigNumber result){
        IntNode curr_Index = result._head;
        IntNode other_Index = other._head;
        boolean flag = true;

        // I think that for this one i need to copy the full BiggerBigNumber and then start edit the big num! (as of right now it's doesn't rembmber the changes thats why its wrong!


        int temp_Sum = 0;
        //IntNode result_Index = result._head;

        while (curr_Index != null){
            //TODO: see what happen when you try to add null with val?
            temp_Sum = curr_Index.getValue() - other_Index.getValue();

            if(temp_Sum < 0 && curr_Index.getNext() != null){

                // moving the bigger number -1 :
                curr_Index.getNext().setValue(curr_Index.getNext().getValue() - 1);
                temp_Sum = 10 + temp_Sum; // temp_Sum is negetive!!
            }
            //Setting the finale result of this figure -
            curr_Index.setValue(temp_Sum);
            // Resetting the sum after filling him -
            temp_Sum = 0;

            // Go to the next spot in each BigNumber -
            if(other_Index.getNext() != null && flag == true){
                other_Index = other_Index.getNext();
            }
            else if(other_Index.getNext() == null && other_Index.getValue() != 0){
                other_Index = new IntNode(0);
                flag = false;
            }
            curr_Index = curr_Index.getNext();
        }
        return result;
    }

    //
    private BigNumber multiplyTwoBigNumbers(BigNumber bigger_Big_Number , BigNumber other, BigNumber result){
        IntNode curr_Index = bigger_Big_Number._head;
        IntNode other_Index;
        IntNode result_Index;
        int pow_Counter = 1;

        int temp_Sum = 0;

        while (curr_Index != null){

            result_Index = result._head;
            for(int i = 1; i < pow_Counter; i++){
                result_Index = result_Index.getNext();
            }
            other_Index = other._head;

            while(other_Index != null){

                if(result_Index.getNext() == null) {
                    result_Index.setNext(new IntNode(0));
                }

                temp_Sum = ((curr_Index.getValue()) * other_Index.getValue()) + result_Index.getValue();

                if(temp_Sum >= 10){
                    if(result_Index.getNext() == null) {
                        // Create the next spot and going to point it -
                        result_Index.setNext(new IntNode(0));
                    }
                    result_Index.getNext().setValue(result_Index.getNext().getValue() +(temp_Sum / 10));
                }

                //if(curr_Index.getNext() != null && temp_Sum != 0) {
                    result_Index.setValue((temp_Sum % 10));
                //}
                temp_Sum = 0;

                result_Index = result_Index.getNext();
                other_Index = other_Index.getNext();
            }
            // Getting the next figure
            curr_Index = curr_Index.getNext();
            pow_Counter++;
        }
        return result;
    }

    // This method reversing the order of my BigNumber -
    // Return - a new BigNumber that is the reverse of curr_Big_Number.
    private void reverse(){
        // Define variables -
        IntNode new_Head = null;
        IntNode p;

        // Reverse my Node List order -
        while (this._head != null){
            p = this._head;
            this._head =  this._head.getNext();
            p.setNext(new_Head);
            new_Head = p;
        }

        this._head = new_Head;
    }

    // This function get a BigNumber and return the amount of figures the number have.
    // Return - the amount of figures the BigNumber have.
    private long length(){
        int counter = 0;
        IntNode index = this._head;

        while (index != null){
            counter++;
            index = index.getNext();
        }
        return counter;
    }
}