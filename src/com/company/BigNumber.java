package com.company;
/**
 *  Represents a int NodeList that will represent a number with large amounts of figures.
 * @author Doriyan Esterin/206765844.
 * @version 12/01/2021.
 */
public class BigNumber {

    //TODO: fill all the api!

    // Define class variables -
    private IntNode _head;

    /**
     * Empty Constructor
     */
    public BigNumber(){
        _head = new IntNode(0);
    }

    /**
     * This method is getting a long number, and create a new NodeList that will represent this number.
     * @param num - A long number.
     */
    public BigNumber(long num){
        if(num == 0){
            _head = new IntNode(0);
        }
        else{
            // First i define the last number as the head of my NodeList -
            _head = new IntNode((int) num % 10);
            IntNode curr_Node = _head;

            // Now i'm going to loop throughtout the rest of the number and conntect the rest of the number -
            while(num >0){
                curr_Node.setNext(new IntNode((int) num % 10));
                curr_Node = curr_Node.getNext();
            }
        }
    }

    /**
     * This method get a BigNumber and create a new copy of this NodeList.
     * @param big_Num - a BigNumber instance, which is a NodeList that represent a very long number.
     */
    public BigNumber(BigNumber big_Num){
        if(big_Num._head.getNext() == null){
            _head = new IntNode(0);
        }
        else{
            // First i define the last number as the head of my NodeList -
            _head = new IntNode(big_Num._head.getValue());
            IntNode curr_Node_New = _head;
            IntNode big_Num_Index = big_Num._head.getNext();

            // Now i'm going to loop throughtout the rest of the list and copy the rest of the number -
            while(big_Num_Index != null){
                curr_Node_New.setNext(big_Num_Index);
                curr_Node_New = curr_Node_New.getNext();
                big_Num_Index = big_Num_Index.getNext();
            }
        }
    }

    /**
     * This method return the
     * @return
     */
    public String toString(){
        //TODO: this method must be in O(n) -

        String result = "";
        IntNode curr_Node = _head;

        while(curr_Node != null){
            if(curr_Node.getNext() != null && curr_Node.getValue() != 0){
                result = this._head.getValue() + result;
            }
            // Getting the next figure in the number -
            curr_Node = curr_Node.getNext();
        }
        // Return the final String -
        return result;
    }

    /**
     *
     * @param other
     * @return
     */
    public int compareTo (BigNumber other){
        String curr_Big_Number = this.toString();
        String other_Big_Number = other.toString();
        if(curr_Big_Number.length() > other_Big_Number.length()){
            return 1;
        }
        if(curr_Big_Number.length() < other_Big_Number.length()){
            return -1;
        }
        else {
            //TODO: need to ask if i can use compareTo ofString? if not then i must count my self and test!!!
            return curr_Big_Number.compareTo(other_Big_Number);
        }
    }

    /**
     * This method is getting a Big number and add it to my current BigNumber and return a new BigNumber which is the addition of both of them.
     * @param other
     * @return
     */
    public BigNumber addBigNumber (BigNumber other){
        IntNode curr_Index = this._head;
        IntNode other_Index = other._head;

        int temp_Sum = 0, single_Num_Of_Sum = 0;
        // First i will start by creating the new BigNumber that will have a defined _head.
        BigNumber result = new BigNumber();
        IntNode result_Index = result._head;

        while (other_Index != null){
            //TODO: see what happen when you try to add null with val?
            temp_Sum += curr_Index.getValue() + other_Index.getValue();
            single_Num_Of_Sum = temp_Sum % 10;
            // Sending an integer to a method that expect Long, yet it's fine because in the compilation and run time java know how to handle it automaticly!
            result_Index.setValue(single_Num_Of_Sum);
            // Maintain the extra that left -
            temp_Sum -= single_Num_Of_Sum;

            if(other_Index.getNext() != null) {
                // Create the next spot and going to point it -
                result_Index.setNext(new IntNode(0));
                result_Index = result_Index.getNext();
            }
            // Go to the next spot in each BigNumber -
            if(curr_Index != null) {
                curr_Index = curr_Index.getNext();
            }
            other_Index = other_Index.getNext();
        }

        if(temp_Sum > 0){
            while (curr_Index != null){

                temp_Sum += curr_Index.getValue();
                single_Num_Of_Sum = temp_Sum % 10;
                // Sending an integer to a method that expect Long, yet it's fine because in the compilation and run time java know how to handle it automaticly!
                result_Index.setValue(single_Num_Of_Sum);
                // Maintain the extra that left -
                temp_Sum -= single_Num_Of_Sum;

                if(curr_Index.getNext() != null) {
                    // Create the next spot and going to point it -
                    result_Index.setNext(new IntNode(0));
                    result_Index = result_Index.getNext();
                }
            }

            while (temp_Sum > 0){
                single_Num_Of_Sum = temp_Sum % 10;
                // Sending an integer to a method that expect Long, yet it's fine because in the compilation and run time java know how to handle it automaticly!
                result_Index.setValue(single_Num_Of_Sum);
                // Maintain the extra that left -
                temp_Sum -= single_Num_Of_Sum;

                if(temp_Sum > 0) {
                    // Create the next spot and going to point it -
                    result_Index.setNext(new IntNode(0));
                    result_Index = result_Index.getNext();
                }
            }
        }
        return result;
    }

    /**
     *
     * @param other
     * @return
     */
    public BigNumber subtractBigNumber(BigNumber other){
        // Will hold my result -
        BigNumber result = new BigNumber();

        // If they are equal -
        if(this.compareTo(other) == 0){
            return result;
        }
        if(other == null){
            return new BigNumber(this);
        }
        // If This BigNumber is bigger then other -
        else if(this.compareTo(other) == 1){
            return substractTwoBigNumbers(this,other,result);
        }
        // If this not equal to other and the other BigNumber is bigger then him, he must be smaller then him -
        else{
            return substractTwoBigNumbers(other,this,result);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    // Private Methods of this class -
    //TODO: Private Method that i need to add API!!!
    private BigNumber substractTwoBigNumbers(BigNumber bigger_Big_Number , BigNumber other, BigNumber result){
        IntNode curr_Index = this._head;
        IntNode other_Index = other._head;

        int temp_Sum = 0, single_Num_Of_Sum = 0;
        IntNode result_Index = result._head;

        while (curr_Index != null){
            //TODO: see what happen when you try to add null with val?
            temp_Sum = curr_Index.getValue() - other_Index.getValue();

            if(temp_Sum < 0){
                // moving the bigger number -1 :
                result_Index.getNext().setValue(result_Index.getValue() - 1);
                temp_Sum = 10 - temp_Sum;
            }
            //Setting the finale result of this figure -
            result_Index.setValue(temp_Sum);
            // Resetting the sum after filling him -
            temp_Sum = 0;

            if(other_Index.getNext() != null) {
                // Create the next spot and going to point it -
                result_Index.setNext(new IntNode(0));
                result_Index = result_Index.getNext();
            }
            // Go to the next spot in each BigNumber -
            if(other_Index != null) {
                other_Index = other_Index.getNext();
            }
            else if(other_Index == null){
                other_Index = new IntNode(0);
            }
            curr_Index = curr_Index.getNext();
        }
        return result;
    }
}