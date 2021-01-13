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
            while((num / 10) >0){
                num = num / 10;
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
     * This method return a String that represents a BigNumber.
     * @return A String that represents a BigNumber.
     */
    public String toString(){
        //TODO: this method must be in O(n) -

        String result = "" + this._head.getValue();
        IntNode curr_Node = _head.getNext();

        while(curr_Node != null){
            if(curr_Node.getValue() != 0){
                result = curr_Node.getValue() + result;
            }
            else if(curr_Node.getNext() != null){
                result = curr_Node.getValue() + result;
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

        for(int i = 0;i < curr_Big_Number.length();i++){
            if(curr_Big_Number.charAt(i) > other_Big_Number.charAt(i)){
                return 1;
            }
            if(curr_Big_Number.charAt(i) < other_Big_Number.charAt(i)){
                return -1;
            }
        }
        return 0;

    }

    /**
     * This method is getting a Big number and add it to my current BigNumber and return a new BigNumber which is the addition of both of them.
     * @param other
     * @return
     */
    //TODO: refactor this function as i did in the substrack funciton!!!
    public BigNumber addBigNumber (BigNumber other){
        // Will hold my result -
        BigNumber result = new BigNumber();

        // If This BigNumber is bigger then other -
        if(this.compareTo(other) == 1){
            return addTwoBigNumbers(this,other,result);
        }
        // If this not equal to other and the other BigNumber is bigger then him, he must be smaller then him -
        else{
            return addTwoBigNumbers(other,this,result);
        }
    }

    /**
     *
     * @param num
     * @return
     */
    public BigNumber addLong (long num){

        BigNumber num_Big_Number = new BigNumber(num);

        BigNumber result = this.addBigNumber(num_Big_Number);

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
        // If This BigNumber is bigger then other -
        else if(this.compareTo(other) == 1){
            return subtractTwoBigNumbers(this,other,result);
        }
        // If this not equal to other and the other BigNumber is bigger then him, he must be smaller then him -
        else{
            return subtractTwoBigNumbers(other,this,result);
        }
    }

    public BigNumber multBigNumber (BigNumber other){
        // Will hold my result -
        BigNumber result = new BigNumber();

        if(this.compareTo(result)==0 || other.compareTo(result)== 0){
            return result;
        }
        // If This BigNumber is bigger then other -
        if(this.compareTo(other) == 1){
            return multiplyTwoBigNumbers(this,other,result);
        }
        // If this not equal to other and the other BigNumber is bigger then him, he must be smaller then him -
        else{
            return multiplyTwoBigNumbers(other,this,result);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
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
            //if(curr_Index != null && temp_Sum != 0) {
                result_Index.setValue(result_Index.getValue() + (temp_Sum % 10));
           // }
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

    // Private Methods of this class -
    //TODO: Private Method that i need to add API!!!
    private BigNumber subtractTwoBigNumbers(BigNumber bigger_Big_Number , BigNumber other, BigNumber result){
        IntNode curr_Index = bigger_Big_Number._head;
        IntNode other_Index = other._head;
        boolean flag = true;

        // I think that for this one i need to copy the full BiggerBigNumber and then start edit the big num! (as of right now it's doesn't rembmber the changes thats why its wrong!


        int temp_Sum = 0;
        IntNode result_Index = result._head;

        while (curr_Index != null){
            //TODO: see what happen when you try to add null with val?
            temp_Sum = curr_Index.getValue() - other_Index.getValue();

            if(curr_Index.getNext() != null && result_Index.getNext() == null) {
                result_Index.setNext(new IntNode(0));
            }

            if(temp_Sum < 0){

                if(result_Index.getNext() == null) {
                    // Create the next spot and going to point it -
                    result_Index.setNext(new IntNode(0));
                }

                // moving the bigger number -1 :
                result_Index.getNext().setValue(curr_Index.getValue() - 1);
                temp_Sum = 10 + temp_Sum + result_Index.getValue(); // temp_Sum is negetive!!
            }
            //Setting the finale result of this figure -
            result_Index.setValue(temp_Sum);
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
            result_Index = result_Index.getNext();
        }
        return result;
    }

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
}