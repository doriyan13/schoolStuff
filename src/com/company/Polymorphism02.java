package com.company;

public class Polymorphism02 extends Polymorphism01 implements DoriInterface {

    protected int _son_protected_Field;
    private int _son_private_Field;

    public Polymorphism02(){
        _son_protected_Field = 1;
        _son_private_Field = 1;
    }

    public Polymorphism02(int x ){
        _son_protected_Field = 2;
        _son_private_Field = 2;
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
        System.out.println("this is Poly2 - pol2 overloading");
        return _son_private_Field == p2._son_private_Field;
    }

    public boolean equals(Object obj){
        System.out.println(_son_protected_Field);
        System.out.println("this is Poly2 - obj override");
        if(obj instanceof Polymorphism02 && this.getPrivateValue() == ((Polymorphism02)obj).getPrivateValue() && this.getProtectedValue() == ((Polymorphism02)obj).getProtectedValue())
        return true;

        return false;
    }

    public void interfaceTester(Object b){
        System.out.println("an interface just created a pointer to Polymorphism02 Object! it does work");
    }

    public void testComplationProb(Polymorphism02 pol2){
        Object obj = new Polymorphism02(15);
        Polymorphism02 poly2 = new Polymorphism02();
    }

    public static void main(String args[]){
        Object obj1 = new Polymorphism02();
        Object obj2 = new Polymorphism02();
        Polymorphism02 pol2 = new Polymorphism02();
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.equals(pol2));
        System.out.println(pol2.equals(obj1));
        char g = 'G';
        char m = 'M';
        System.out.println(g + "," + m);
        System.out.println(g>m);
        System.out.println(m>g);
    }
}
