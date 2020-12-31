package com.company;

public class Segment1TesterDori {

    public static void main(String[] args){
        // Doriyan Esterin final tester!
        int mistakeCounter = 0;
        System.out.println("Starting to test your Segment1.java Class:");
        System.out.println("1.)constructors:");

        System.out.println("building with 4 values: seg1[(-1,5),(5,-6)]");
        Segment1 seg1 = new Segment1(1,5,5,6);
        if(Math.round(seg1.getPoLeft().getX())!=1)mistakeCounter++;
        if(Math.round(seg1.getPoRight().getY())!=5)mistakeCounter++;
        System.out.println(seg1.toString());
        System.out.println("building with 2 Points: seg2[(1,0),(4,6)]");
        Point p1 = new Point(1,0);
        Point p2 = new Point(4,6);
        Segment1 seg2 = new Segment1(p1,p2);
        System.out.println(seg2.toString());
        if(Math.round(seg2.getPoRight().getY())!=0)mistakeCounter++;
        System.out.println(seg2.getPoRight().getY());
        System.out.println("building Copy: seg3[seg2]");
        Segment1 seg3 = new Segment1(seg2);
        System.out.println(seg3.toString());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Amount of mistakes in your constractors: "+mistakeCounter);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("testing alssing:");
        seg2.changeSize(2);
        System.out.println("new seg2: "+seg2.toString());
        System.out.println("seg3: "+seg3.toString());
        if(Math.round(Math.round(seg3.getPoRight().getX())) != 4){
            mistakeCounter++;
            System.out.println("Error! ");
        };
        seg3.moveVertical(1);
        seg3.moveHorizontal(1);
        System.out.println("new seg3: "+seg3.toString());
        if(Math.round(seg3.getPoLeft().getX()) !=2 || Math.round(seg3.getPoRight().getX()) != 5){
            mistakeCounter++;
            System.out.println("Error: "+ Math.round(seg2.getPoLeft().getX()) +" not 2, or "+ Math.round(seg3.getPoRight().getX())+" not 5?");
        };
        if(Math.round(seg3.getPoLeft().getY()) !=1 || Math.round(seg3.getPoRight().getY())!=1 ){
            mistakeCounter++;
            System.out.println("Error: "+ Math.round(seg2.getPoLeft().getY()) +" not 2, or "+ Math.round(seg3.getPoRight().getY())+" not 5?");
        }
        if(Math.round(seg3.getLength()) != 3)mistakeCounter++;
        if(!seg3.isAbove(seg2))mistakeCounter++;
        if(seg2.isAbove(seg3))mistakeCounter++;
        if(seg3.isUnder(seg2))mistakeCounter++;
        if(!seg2.isUnder(seg3))mistakeCounter++;

        System.out.println("seg2: "+seg2.toString());
        System.out.println("seg3: "+seg3.toString());
        if(seg2.isLeft(seg3))mistakeCounter++;
        if(seg2.isRight(seg3))mistakeCounter++;

        if(Math.round(seg2.overlap(seg3)) !=3)mistakeCounter++;
        if(Math.round(seg3.overlap(seg2)) !=3)mistakeCounter++;

        seg3.moveHorizontal(10);

        System.out.println("new seg2: "+seg2.toString());
        System.out.println("new seg3: "+seg3.toString());
        if(!seg2.isLeft(seg3))mistakeCounter++;
        if(seg2.isRight(seg3))mistakeCounter++;

        Point pOnSeg = new Point(13,0);
        if(seg3.pointOnSegment(pOnSeg)){
            mistakeCounter++;
            System.out.println("Error!! point not on segment!!");
        }
        System.out.println(pOnSeg.toString());
        pOnSeg.setY(1);
        System.out.println(pOnSeg.toString());
        if(!seg3.pointOnSegment(pOnSeg)){
            mistakeCounter++;
            System.out.println("Error!! point is on segment!!");
        }


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Amount of mistakes in your code: "+mistakeCounter);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        /*
         Scanner input = new Scanner(System.in);
        System.out.println("Point1:");
        System.out.println("enter x");
        double length_of_x = input.nextDouble(); // The length of the 'x' leg of the right triangle.
        System.out.println("enter y");
        double length_of_y = input.nextDouble(); // The length of the 'y' leg of the right triangle.
        Point firstPoint = new Point(length_of_x,length_of_y);

        System.out.println("Point 2:");
        System.out.println("enter x");
        double length_of_x2 = input.nextDouble(); // The length of the 'x' leg of the right triangle.
        System.out.println("enter y");
        double length_of_y2 = input.nextDouble(); // The length of the 'y' leg of the right triangle.
        Point secPoint = new Point(length_of_x2,length_of_y2);
        //First segment -
        Segment1 firstSeg = new Segment1(firstPoint,secPoint);
        //------------------------------------------------------------------------------------------
        System.out.println("Point3:");
        System.out.println("enter x");
        double length_of_x3 = input.nextDouble(); // The length of the 'x' leg of the right triangle.
        System.out.println("enter y");
        double length_of_y3 = input.nextDouble(); // The length of the 'y' leg of the right triangle.
        Point thirdPoint = new Point(length_of_x3,length_of_y3);

        System.out.println("Point 4:");
        System.out.println("enter x");
        double length_of_x4 = input.nextDouble(); // The length of the 'x' leg of the right triangle.
        System.out.println("enter y");
        double length_of_y4 = input.nextDouble(); // The length of the 'y' leg of the right triangle.
        Point forthPoint = new Point(length_of_x4,length_of_y4);

        //Test Trapez -
        Segment1 secSeg = new Segment1(thirdPoint,forthPoint);
        System.out.println("first "+firstSeg.toString() + " ,length: "+firstSeg.getLength());
        System.out.println("sec "+secSeg.toString() + " ,length: "+secSeg.getLength());
        System.out.println("");
        System.out.println("dLeft- my->other "+firstSeg.getPoLeft().distance(secSeg.getPoLeft()));
        System.out.println("dLeft- other->my "+secSeg.getPoLeft().distance(firstSeg.getPoLeft()));
        System.out.println("");
        System.out.println("dRight- my->other "+firstSeg.getPoRight().distance(secSeg.getPoRight()));
        System.out.println("dRight- other->my "+secSeg.getPoRight().distance(firstSeg.getPoRight()));
        System.out.println("");
        System.out.println("trapeze 1 to 2: "+firstSeg.trapezePerimeter(secSeg));
        System.out.println("trapeze 2 to 1: "+secSeg.trapezePerimeter(firstSeg));
        */
        //Test overlap -
        /*
        Segment1 secSeg = new Segment1(thirdPoint,forthPoint);
        System.out.println("first "+firstSeg.toString() + " ,length: "+firstSeg.getLength());
        System.out.println("sec "+secSeg.toString() + " ,length: "+secSeg.getLength());
        System.out.println("overlap - 1 to 2: "+ firstSeg.overlap(secSeg));
        System.out.println("overlap - 2 to 1: "+ secSeg.overlap(firstSeg));
        System.out.println("trapeze 1 to 2: "+firstSeg.trapezePerimeter(secSeg));
        System.out.println("trapeze 2 to 1: "+secSeg.trapezePerimeter(firstSeg));
        */
        /*
        System.out.println("enter x delta");
        double deltaX = input.nextDouble();

        System.out.println("enter y delta");
        double deltaY = input.nextDouble();

        Point secondPoint = new Point(firstPoint);
        secondPoint.setX(firstPoint.getX()+deltaX);
        secondPoint.setY(firstPoint.getY()+deltaY);

        System.out.println("this is my point's:");
        System.out.println("first: "+firstPoint.toString());
        System.out.println("second: "+secondPoint.toString());

        //TODO: testing first constractor -
        Segment1 firstSeg = new Segment1(firstPoint,secondPoint);
        //TODO: testing second constractor - (and diff y values - need to fix them automaticly
        Segment1 secondSeg = new Segment1(0.0,3.0,2.0,0.5);
        //TODO: testing third constractor - copy
        Segment1 thirdSeg = new Segment1(secondSeg);

        //TODO: testing getPoLeft / getPoRight / getLength -
        System.out.println("First Seg data: " +
                "\n poLeft: "+firstSeg.getPoLeft() +
                "\n poRight: "+firstSeg.getPoRight() +
                "\n length: "+ firstSeg.getLength());
        System.out.println("");
        //TODO: testing toString -
        System.out.println("second Seg: "+secondSeg.toString()+",length: "+secondSeg.getLength());
        System.out.println("");
        //TODO: testing equals -
        System.out.println("is first equals to sec? "+ firstSeg.equals(secondSeg)+"(false)"); //suppose to return false!
        System.out.println("is second euqals to thrid? "+secondSeg.equals(thirdSeg)+"(true)"); //suppose to return true!
        System.out.println("");
        //TODO:: testing isAbove / isUnder / isLeft / isRight -
        System.out.println("first: "+firstSeg.toString()+",sec: "+secondSeg.toString());
        System.out.println("first above sec? "+firstSeg.isAbove(secondSeg));
        System.out.println("sec above first? "+secondSeg.isAbove(firstSeg));
        System.out.println("");
        System.out.println("first under sec? "+firstSeg.isUnder(secondSeg));
        System.out.println("sec under first? "+secondSeg.isUnder(firstSeg));
        System.out.println("");
        System.out.println("first left sec? "+firstSeg.isLeft(secondSeg));
        System.out.println("sec left first? "+secondSeg.isLeft(firstSeg));
        System.out.println("");
        System.out.println("first right sec? "+firstSeg.isRight(secondSeg));
        System.out.println("sec right first? "+secondSeg.isRight(firstSeg));
        System.out.println("");
        //TODO: moveHorizontal / moveVertical -
        System.out.println("sec "+secondSeg.toString() + " ,length: "+secondSeg.getLength());
        System.out.println("third "+thirdSeg.toString() + " ,length: "+thirdSeg.getLength());
        thirdSeg.moveHorizontal(3);
        thirdSeg.moveVertical(3);
        System.out.println("after changes: ");
        System.out.println("sec "+secondSeg.toString() + " ,length: "+secondSeg.getLength());
        System.out.println("third "+thirdSeg.toString() + " ,length: "+thirdSeg.getLength());
        System.out.println("");
        //TODO: changeSize -
        thirdSeg.changeSize(2);
        System.out.println("change size: ");
        System.out.println("third "+thirdSeg.toString() + " ,length: "+thirdSeg.getLength());
        System.out.println("");
        //TODO: pointOnSegment
        System.out.println("sec "+secondSeg.toString());
        Point onSegTest = new Point(1.0,3.0);
        System.out.println("is (1.0,3.0) on this seg? "+ secondSeg.pointOnSegment(onSegTest)+"(true)"); //suppose to return true
        System.out.println("third "+thirdSeg.toString());
        System.out.println("is (1.0,3.0) on this seg? "+ thirdSeg.pointOnSegment(onSegTest)+"(false)"); //suppose to return false
       onSegTest.setX(5.0);
        System.out.println("is (5.0,3.0) on this seg? "+ thirdSeg.pointOnSegment(onSegTest)+"(false)"); //suppose to return false
        System.out.println("");
        //TODO: isBigger?
        System.out.println("first: "+firstSeg.toString());
        System.out.println("sec: "+secondSeg.toString());
        System.out.println("third: "+thirdSeg.toString());
        System.out.println("is first bigger then first? "+firstSeg.isBigger(firstSeg));
        System.out.println("is first bigger then sec? "+firstSeg.isBigger(secondSeg));
        System.out.println("is first bigger then third? "+firstSeg.isBigger(thirdSeg));
        System.out.println("is sec bigger then first? "+secondSeg.isBigger(firstSeg));
        System.out.println("is sec bigger then third? "+secondSeg.isBigger(thirdSeg));
        System.out.println("is third bigger then sec? "+thirdSeg.isBigger(secondSeg));
        System.out.println("is third bigger then first? "+thirdSeg.isBigger(firstSeg));
        System.out.println("");
        //TODO: overlap:
        System.out.println("first: "+firstSeg.toString());
        System.out.println("sec: "+secondSeg.toString());
        System.out.println("third: "+thirdSeg.toString());
        System.out.println("is first overlap first? "+firstSeg.overlap(firstSeg));
        System.out.println("is first overlap sec? "+firstSeg.overlap(secondSeg));
        System.out.println("is sec overlap first? "+secondSeg.overlap(firstSeg));
        System.out.println("is sec overlap third? "+secondSeg.overlap(thirdSeg));
        System.out.println("is third overlap sec? "+thirdSeg.overlap(secondSeg));
        System.out.println("is first overlap third? "+firstSeg.overlap(thirdSeg));
        System.out.println("is third overlap first? "+thirdSeg.overlap(firstSeg));
        System.out.println("");
        //TODO: trapeze Perimeter:
        System.out.println("first: "+firstSeg.toString());
        System.out.println("sec: "+secondSeg.toString());
        System.out.println("third: "+thirdSeg.toString());
        //don't neeed to verifiy this possibility -
        //System.out.println("trapze first to first? "+firstSeg.trapezePerimeter(firstSeg));
        //TODO: write the final values becuase it's hard to test as of right now!
        System.out.println("trapze first to sec? "+firstSeg.trapezePerimeter(secondSeg));
        System.out.println("trapze sec to first? "+secondSeg.trapezePerimeter(firstSeg));
        System.out.println("trapze sec to third? "+secondSeg.trapezePerimeter(thirdSeg));
        System.out.println("trapze third to sec? "+thirdSeg.trapezePerimeter(secondSeg));
        System.out.println("trapze first to third? "+firstSeg.trapezePerimeter(thirdSeg));
        System.out.println("trapze third to first? "+thirdSeg.trapezePerimeter(firstSeg));
    */



    }
}
