package com.company;

import org.w3c.dom.ls.LSOutput;

public class PolymorphismMainTesting {

    public void testerName(){
        System.out.println("testing a double name");
    }

    public static void main(String[] args) {
        Polymorphism01 p1 = new Polymorphism01();
        Polymorphism02 p2 = new Polymorphism02();
        System.out.println("so even in main class of the project it's still the same package so i can access the Fields: " +p2._protected_Field);
        System.out.println();
        System.out.println("p1 getProtectedValue: " + p1.getProtectedValue());
        System.out.println("p2 getProtectedValue: " + p2.getProtectedValue());
        System.out.println("p2 dadMethod: ");
        p2.dadMethod();
        System.out.println("p1 dadMethod? ");
        p1.dadMethod();
        System.out.println();
        System.out.println("p1 getPrivateValue: " + p1.getPrivateValue());
        System.out.println("p2 getPrivateValues that is from p1:(not defined in my class!) " + p2.getPrivateValue());

        Polymorphism01 p3 = new Polymorphism02();
        System.out.println("this is private "+ p3.getPrivateValue());
        if(p3.getPrivateValue() == 0){
            System.out.println("this type is Polymorphism01"); // Will enter this one!
        }
        else{
            System.out.println("this type is Polymorphism02");
        }
        p3.dadMethod();
        System.out.println("`                                *`                                ~");
        System.out.println("the actual protected value is: " + p3.getProtectedValue()+", 0- means Polymorphism01 and 1- means Polymorphism02"); // if it's 0 then it's Polymorphism01 || 1 - Polymorphism02
        System.out.println("`                                *`                                ~");
        //p2.testThisIsSon(); //a method that only the son have
        //p3.testThisIsSon(); - even tho this object is a Polymorphism02, the pointer is Polymorphism01 thats why i
        // don't have access to Polymorphism02 methods of the object!
        //Testing overriding:
//        p1.dadMethTestOverride(1);
//        p2.dadMethTestOverride(1);
        Polymorphism01 try1to2 = new Polymorphism02();
        Object obj = try1to2;
        Polymorphism01 try1 = try1to2;
        //Polymorphism02 try2 = try1to2;
        // ^^ will not work without proper casting because the compiler will not consider this as a Polymorphism02 Object till run time!!!
        //does the same default objects will be equals ? (from object class). -> no.
//        Polymorphism01 e1 = new Polymorphism01();
//        Polymorphism01 e2 = new Polymorphism01();
//        System.out.println(e1.equals(e2));
        Polymorphism01 a4 = new Polymorphism02();
        Polymorphism01 a2 = new Polymorphism02();
        Polymorphism02 b1 = new Polymorphism02();
        //Polymorphism02 try2to1 = new Polymorphism01(); -> because try2to1 will have function that the Object will not have!
        System.out.println(a4.equals(a2));
        System.out.println(a2.equals(b1));
        System.out.println(b1.equals(a4));

        DoriInterface interfaceObject = new Polymorphism02();
        interfaceObject.interfaceTester(1);
        ((Polymorphism02)interfaceObject).dadMethod();

        //Polymorphism01 tester = new Polymorphism02();

        int testerName = 1;
        //testerName();
        //Polymorphism01 canIuseClassNameInParams = new Polymorphism01(testerName); - you can !
    }
}
