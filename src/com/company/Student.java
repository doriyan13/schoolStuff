package com.company;

public class Student extends Person {

    //as you can see i didn't created isMust and yet its okay, yet the trade off is that you must make the son class
    //to be a abstarct class also..
    public boolean f(int x){
        return x==2;
    }
    //overloading !
    private void f (double num){
        System.out.println("overLoading?");
    }

    public void isMust(){
        System.out.println("hello");
    }
}
