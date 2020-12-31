package com.company;

public class Polymorphism01 {

    protected int _protected_Field;
    private int _private_Field;

    public Polymorphism01(){
        _private_Field = 0;
        _protected_Field = 0;
    }

    protected int getProtectedValue(){
        return this._protected_Field;
    }

    public int getPrivateValue(){
        return this._private_Field;
    }

    public void dadMethod(){}

    public void dadMethTestOverride(int a){
        System.out.println("I'm F*cking dad");
    }
}
