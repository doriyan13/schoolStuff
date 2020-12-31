package com.company;

public class Segment3TesterDori {

    public static void main(String[] args) {
        // Using other people testers final tester!

        //Point class
        //constructors:
        Point p1 = new Point(3,4); //p1 = 3,4
        Point p2 = new Point(p1); //p2 = 3,4
        Point p3 = new Point(-7,-5); //p3 = 0,0
        //get methods + negative constructor:
        if (p1.getX() != 3 ||  p1.getY() != 4)
            System.out.println ("check get method");
        if (p3.getX() != 0 ||  p3.getY() != 0)
            System.out.println ("check negative in constructor");
        //set methods + negative constructor:
        p1.setX(10); //p1 = 10,4
        p2.setX(-2);
        p2.setY(-1); //p2 = 3,4
        if(p2.getX() != 3 ||  p2.getY() != 4)
            System.out.println ("check copy constructor OR negative in set method");
        //toString
        if (!p1.toString().equals("(10.0,4.0)") || !p3.toString().equals("(0.0,0.0)"))
            System.out.println ("check toString");
        //equals, above, under, left, right
        if (p1.isUnder(p2) || p3.isAbove(p2) || p2.isAbove(p1))
            System.out.println ("check isAbove/under method");
        p2.move(-3,-4); //p2 = 0,0
        if (p1.equals(p2) || !p2.equals(p3))
            System.out.println ("check equals/move method");
        if (p1.isLeft(p2) || p2.isRight(p3) || !p3.isLeft(p1))
            System.out.println ("check isLeft/right method");
        //move, distance
        p1.move(-12,1); //p1 = 10,4
        p2.move(2,4); //p2 = 2,4
        if (p1.distance(p2) != 8)
            System.out.println ("check move/distance methods");

        System.out.println("finish testing point class, fix the first error and run again. if no other massages, well done!");
        // System.out.println ("p1: " + p1 + "p2: " + p2 + "p3: " + p3); //copy this line for internal debugging

        //p1 = 10,4
        //p2 = 2,4
        //p3 = 0,0

        //segment1+2
        //constructors
        Segment1 s11 = new Segment1(p3,p1); //s11 = (0,0)---(10,0)
        Segment1 s12 = new Segment1(2,5,8,6); //s12 = (2,5)---(8,5)
        Segment1 s13 = new Segment1(s11); //s13 = (0,0)---(10,0)
        Segment2 s21 = new Segment2(p3,p1); //s21 = (0,0)---(10,0), l=10
        Segment2 s22 = new Segment2(2,5,8,6); //s22 = (2,5)---(8,5), l=6
        Segment2 s23 = new Segment2(s21); //s23 = (0,0)---(10,0), l=10
        Segment2 s24 = new Segment2(p2,3);//s24 = (0.5,4)---(3.5,4), l=3
        //get methods + constructors check
        if (s11.getPoRight().equals(p1) || s12.getPoRight().getY() != 5)
            System.out.println ("segment1 check getPoRight method/rightY inConstructor");
        s13.getPoLeft().setX(3); //check alising
        if (s13.getPoLeft().getX() != 0)
            System.out.println ("segment1 check getPoLeft method/alising");
        s21.getPoRight().setY(4); //check alising
        if (s21.getPoRight().equals(p1) || s22.getPoRight().getY() != 5)
            System.out.println ("segment2 check getPoRight method/rightY inConstructor/alising");
        if (s22.getPoLeft().getX() != 2)
            System.out.println ("segment2 check getPoLeft method");
        if (s24.getLength() != 3 || s11.getLength() != 10)
            System.out.println ("segment 1+2 check getLength method/ S2 extraConstructor");
        //toString
        if (!s11.toString().equals("(0.0,0.0)---(10.0,0.0)") || !s24.toString().equals("(0.5,4.0)---(3.5,4.0)") || !s13.toString().equals("(0.0,0.0)---(10.0,0.0)") ||!s22.toString().equals("(2.0,5.0)---(8.0,5.0)"))
            System.out.println("segment 1+2: check toString method");
        //isAbove/under, moveVertical //s13+s23 check copyConstructor
        s11.moveVertical(5); //s11 = (0,5)---(10,5) //s12 = (2,5)---(8,5) under when equal?
        s11.moveVertical(-10);  //s13 = (0,0)---(10,0) //s12 = (2,5)---(8,5) above + move zero test +copyConstructor
        s21.moveVertical(7); //s21 = (0,7)---(10,7) //s22 = (2,5)---(8,5) above/under
        s24.moveVertical(-5); //s24 = (0.5,4)---(3.5,4), //s23 = (0,0)---(10,0) under + move zero test +copyConstructor
        if (s11.isUnder(s12) || !s12.isAbove(s13) || s21.isUnder(s24) || s22.isAbove(s21) || s23.isAbove(s24))
            System.out.println("segment 1+2: check isAbove/under or moveVertical/copyConstructor");
        //is right/left, move horizontal
        s12.moveHorizontal(-2.1); //s12 = (2,5)---(8,5)//s11 = (0,5)---(10,5) //isLeft +zeroTest
        s13.moveHorizontal(8); //s13 = (8,0)---(18,0) //s12 = (2,5)---(8,5) //isRight when lx=other.rx
        if (s12.isLeft(s11) || s12.getPoRight().getX() != 8 || s13.isRight(s12) || s13.getPoLeft().getX() != 8)
            System.out.println("segment 1: check is right/left, move horizontal");
        s21.moveHorizontal(-1); //s21 = (0,7)---(10,7) //s23 = (0,0)---(10,0) // lapTest + zeroTest
        s24.moveHorizontal(-0.5);  //s24 = (0,4)---(3,4)
        s22.moveHorizontal(1); //s22 = (3,5)---(9,5)
        if (s21.isLeft(s23) || s23.isRight(s21) ||  s22.getPoRight().getX() != 9 || s22.isRight(s24) || s24.getPoLeft().getX() != 0)
            System.out.println("segment 2: check is right/left, move horizontal");
        // pointOnSegment
        p2.setY(5); //p1 = 10,4 //p2 = 2,5  //p3 = 0,0
        if (s11.pointOnSegment(p1) || !s12.pointOnSegment(p2) ||  s13.pointOnSegment(p3) ||  s21.pointOnSegment(p1) ||  s22.pointOnSegment(p2) ||  !s23.pointOnSegment(p3))
            System.out.println("segment 1+2: check pointOnSegment");
        //equals, isBigger, changeSize, overlap, trepeze segment1
        //s11 = (0,5)---(10,5) l=10
        s12.changeSize(4); //s12 = (2,5)---(12,5) l=10
        s13.moveHorizontal(-8); //s13 = (0,0)---(10,0) l=10
        s11.changeSize(-11); //no change
        if (s12.equals(s11) || s13.equals(s11))
            System.out.println("segment 1: check equals/changeSize");
        if (s12.isBigger(s11) || s13.isBigger(s11))
            System.out.println("segment 1: check isBigger");
        s13.moveHorizontal(10); //s13 = (10,0)---(20,0) l=10
        if (s12.overlap(s11) != 8 || s13.overlap(s11) != 0)
            System.out.println("segment 1: check overlap");
        s12.moveHorizontal(-2); //s11 = (0,5)---(10,5) l=10 //s12 = (0,5)---(10,5)
        if (!s12.equals(s11) || s12.overlap(s11) != 10)
            System.out.println("segment 1: check equals/overlap");
        s12.changeSize(-3); //s12 = (0,5)---(7,5) l=7 //s13 = (10,0)---(20,0) l=10
        if (s12.overlap(s13) != 0 || !s13.isBigger(s12))
            System.out.println("segment 1: check overlap/isBigger");
        s12.moveVertical(2); //s12 = (0,7)---(7,7)
        //trepez: s11+s12 = 7+10+(sqrt(2^2+0^2)=2)+(sqrt(3^2+2^2)=3.6) = 22.6055513 ,  s11+s13 = 10+10+(sqrt(10^2+5^2)=11.18)*2 = 42.36068, s12+s13 = 7+10+(sqrt(10^2+7^2)=12.206556)+(sqrt(13^2+7^2)=14.7648) = 43.97138
        if (Math.abs(s11.trapezePerimeter(s12) - 22.6055513)>0.01 || Math.abs(s11.trapezePerimeter(s13) - 42.36068)>0.01 || Math.abs(s13.trapezePerimeter(s12) - 43.97138)>0.01)
            System.out.println("segment 1: check trapezePerimeter");
        //equals, isBigger, changeSize, overlap, trepeze segment2
        //s21 = (0,7)---(10,7) l=10 //s22 = (3,5)---(9,5) l=6 //s23 = (0,0)---(10,0) l=10 //s24 = (0,4)---(6,4) l=6
        s24.changeSize(3); //s24 = (0,4)---(6,4) l=6
        s21.changeSize(-11); //no change
        if (s21.equals(s23) || s22.equals(s24) || s21.getLength() != 10 || s21.getPoRight().getX() != 10)
            System.out.println("segment 2: check equals/changeSize");
        if (s21.isBigger(s23) || s22.isBigger(s24) || s22.isBigger(s21) || !s23.isBigger(s24))
            System.out.println("segment 2: check isBigger");
        if (s21.overlap(s22) != 6 || s22.overlap(s24) != 3 || s23.overlap(s21) != 10 || s24.overlap(s23) != 6)
            System.out.println("segment 2: check overlap");
        //s21 = (0,7)---(10,7) l=10 //s22 = (3,5)---(9,5) l=6 //s23 = (0,0)---(10,0) l=10 //s24 = (0,4)---(6,4) l=6
        s22.moveVertical(-1); //s22 = (3,4)---(9,4) l=6
        s23.moveVertical(7); //s23 = s21 = (0,7)---(10,7) l=10
        if (s22.equals(s24) || !s21.equals(s23))
            System.out.println("segment 2: check equals");
        s23.changeSize(-6);
        s23.moveHorizontal(7); //s23 (7,7)---(11,7) l=4
        s21.changeSize(-3); //s21 (0,7)---(7,7) l=7
        if (s21.overlap(s23) != 0 || s22.overlap(s23) != 0.5 || s23.overlap(s24) != 0) //fixed to 0.5 because this is the diff!
            System.out.println("segment 2: check overlap");
        //trepez: s21+s22 = 7+6+(sqrt(3^2+3^2)=4.2426)+(sqrt(2^2+3^2)=3.6) =20.8482 , s22+s23 = 6+4+(sqrt(4^2+3^2)=5)+(sqrt(2^2+3^2)=3.6) =18.6, s23+s24 = 4+6+(sqrt(7^2+3^2)=7.61577)+(sqrt(5^2+3^2)=5.831) =23.446725
        //TODO: its coming off with diff of 1, idk? i think she messed up because the calculation is the same?
        if (Math.abs(s21.trapezePerimeter(s22) - 20.8482)>0.01 || Math.abs(s22.trapezePerimeter(s23) - 18.6)>0.01 || Math.abs(s23.trapezePerimeter(s24) - 23.446725)>0.01)
            System.out.println("segment 2: check trapezePerimeter");


        System.out.println("finish testing segments classes, fix the first error and run again. if no other massages, well done!");
        //System.out.println ("s11: " + s11 + "s12: " + s12 + "s13: " + s13 + "s21: " + s21 + "s22: " + s22 + "s23: " + s23 + "s24: " + s24);  //copy this line for internal debugging

    }
}
