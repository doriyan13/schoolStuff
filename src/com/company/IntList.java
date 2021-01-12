package com.company;

/**
 * Implementation of the basic class IntList which holds an array of IntNode.
 */
public class IntList {

    // Class variables -
    private IntNode _head;

    // Constructors-
    public IntList(){
        _head = null;
    }
    public IntList(IntNode node){
        _head = node;
    }

    public boolean empty(){
        return _head == null;
    }

    public IntNode nextElement (IntNode node){
        return node.getNext();
    }

    public int getValueOfNode(IntNode node){
        return node.getValue();
    }
}
