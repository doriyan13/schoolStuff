package com.company;

public class Polymorphism02 extends Polymorphism01 implements DoriInterface {

    protected int _son_protected_Field;
    private int _son_private_Field;

    public Polymorphism02(){
        _son_protected_Field = 1;
        _son_private_Field = 1;
    }

    // Will it give the son or the dad?
    protected int getProtectedValue(){
        return this._son_protected_Field;
    }

    protected void testThisIsSon(){
        System.out.println("this is for sure the son!");
    }

    public void dadMethod() {
        System.out.println("this is son!");
        // Because this field is protected in the dad and i'm in the same package i can get it here!
        System.out.println("this is my dad protected value: " + _protected_Field);
        //notice that can't access the dad private field!
        System.out.println("this is my private value: " + _son_private_Field);
    }

    public void dadMethTestOverride(int b){
        System.out.println("I'm now f*cking son");
    }

    public boolean equals(Polymorphism01 p1){
        return false;
    }

    public boolean equals(Polymorphism02 p2){
        return true;
    }

    public boolean equals(Object obj){
        if(obj instanceof Polymorphism02 && this.getPrivateValue() == ((Polymorphism02)obj).getPrivateValue() && this.getProtectedValue() == ((Polymorphism02)obj).getProtectedValue())
        return true;

        return false;
    }

    public void interfaceTester(Object b){
        System.out.println("an interface just created a pointer to Polymorphism02 Object! it does work");
    }
}
