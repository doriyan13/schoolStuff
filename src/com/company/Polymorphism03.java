package com.company;

public class Polymorphism03 extends Polymorphism02 {
    private String _test;

    public Polymorphism03(){
        _protected_Field = 5;
        _test = "ty";
    }

    public static void main(String args[]){
        Polymorphism03 p3 = new Polymorphism03();
        Polymorphism01 p1 = p3;
        Polymorphism02 p2 = (Polymorphism02) p3;
        System.out.println(p2);
    }
}
