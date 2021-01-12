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
}
