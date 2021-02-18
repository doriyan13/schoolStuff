package com.company;

public abstract class Student extends Person {

    //as you can see i didn't created isMust and yet its okay, yet the trade off is that you must make the son class
    //to be a abstarct class also..
    public boolean f(int x){
        return x==2;
    }
}
