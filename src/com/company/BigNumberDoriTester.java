package com.company;

public class BigNumberDoriTester {

    public static void main(String[] args){

        System.out.println("Starting to test your BigNumber.java Class:");
        int mistakeCounter = 0;

        //GOOD
        BigNumber bn1 = new BigNumber();
        System.out.println("Empty constructor -");
        System.out.println(bn1.toString());
        //GOOD
        System.out.println("Long BigNumber constructor -");
        long l = 1313131313;
        BigNumber bn2 = new BigNumber(l);
        System.out.println(bn2);
        //GOOD
        System.out.println("Copy constructor -");
        BigNumber bn3 = new BigNumber(bn2);
        System.out.println(bn3);

        System.out.println("is bn2 equals to bn3 (Yes): " + bn2.compareTo(bn3));
        System.out.println("is bn3 equals to bn2 (Yes): " + bn3.compareTo(bn2));
        BigNumber c1 = new BigNumber(18475529);
        BigNumber c2 = new BigNumber(18475539);
        System.out.println("c1 -> c2 ,(-1): "+c1.compareTo(c2));
        System.out.println("c2 -> c1 ,(1): "+c2.compareTo(c1));

        BigNumber bn4 = new BigNumber(bn2.addBigNumber(bn3));
        System.out.println("bn4: "+ bn4.toString());
        System.out.println("suppose to be - 2626262626");

        BigNumber bn5 = bn4.addLong(1111111111);
        System.out.println("after add long method: " + bn5.toString());

        BigNumber bn6 = bn5.subtractBigNumber(bn2);
        System.out.println("after subtract: " + bn6.toString());

        BigNumber bn7 = bn6.subtractBigNumber(bn2);
        System.out.println("after subtract #2: " + bn7.toString());


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Amount of mistakes in your code: "+mistakeCounter);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
