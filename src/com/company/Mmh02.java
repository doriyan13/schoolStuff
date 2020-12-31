package com.company;

public class Mmh02 {
    private  int _num;
    private static int _count= 0;

    public Mmh02(){
        _count++;
        _num = _count;
    }

    public void printNow(){
        System.out.println(_num + "" + _count);
    }
}
