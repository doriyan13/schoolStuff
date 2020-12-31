package com.company;

public class PointTesterDori {


    public static void main(String[] args){
        // Doriyan Esterin final tester!
        int mistakeCounter = 0;
        System.out.println("Starting to test your Point.java Class:");
        System.out.println("1.)constructors:");
        System.out.println("building with 2 values: p1(1,5)");
        Point p1 = new Point(1,5);
        boolean isP1x = (Math.round(p1.getX()) == 1);
        if(!isP1x) mistakeCounter++;
        boolean isP1y = (Math.round(p1.getY()) == 5);
        if(!isP1y) mistakeCounter++;
        System.out.println("is p1.x ==1? "+isP1x +", is p1.y ==5?"+isP1y);
        System.out.println(p1.toString());
        System.out.println();

        System.out.println("building with 2 values: p2(-1,5)");
        Point p2 = new Point(-1,5);
        boolean isP2x = (Math.round(p2.getX()) == 1 || Math.round(p2.getX()) == -1);
        if(isP2x) mistakeCounter++;
        boolean isP2y = (Math.round(p2.getY()) == -5 || Math.round(p2.getY()) == 0);
        if(isP2y) mistakeCounter++;
        System.out.println(p2.toString());
        System.out.println("is p2.x ==-1? "+isP2x +", is p2.y ==5?"+isP2y);
        System.out.println();

        System.out.println("building with 2 values: p3(-1,-5)");
        Point p3 = new Point(-1,-5);
        boolean isP3x = (Math.round(p3.getX()) == 1 || Math.round(p3.getX()) == -1);
        if(isP3x) mistakeCounter++;
        boolean isP3y = (Math.round(p3.getY()) == -5 || Math.round(p3.getY()) == 5);
        if(isP3y) mistakeCounter++;
        System.out.println(p3.toString());
        System.out.println("is p3.x ==-1? "+isP3x +", is p3.y ==-5?"+isP3y);
        System.out.println();

        System.out.println("building with point p3");
        Point p4 = new Point(p3);
        boolean isP4x = (Math.round(p3.getX()) == 1 || Math.round(p3.getX()) == -1);
        if(isP4x) mistakeCounter++;
        boolean isP4y = (Math.round(p3.getY()) == -5 || Math.round(p3.getY()) == 5);
        if(isP4y) mistakeCounter++;
        System.out.println(p3.toString());
        System.out.println("is p4.x ==-1? "+isP4x +", is p4.y ==-5?"+isP4y);
        System.out.println(p4.toString());
        System.out.println();

        System.out.println("constractor mistakes? "+mistakeCounter);
        System.out.println();

        System.out.println("Alising test: ");
        System.out.println("p3: "+p3.toString());
        p3.setX(1);
        p3.setY(1);
        System.out.println("p3 new: "+p3.toString());
        System.out.println("p4: "+p4.toString());
        p4.move(2,2);
        System.out.println("p4 new: "+p4.toString());
        if(Math.round(p3.getX()) == Math.round(p4.getX()) || Math.round(p3.getY()) == Math.round(p4.getY())) mistakeCounter++;

        System.out.println(p3.isLeft(p4));
        if(!p3.isLeft(p4))mistakeCounter++;
        System.out.println(p4.isRight(p3));
        if(!p4.isRight(p3))mistakeCounter++;
        System.out.println(p3.isUnder(p4));
        if(!p3.isUnder(p4))mistakeCounter++;
        System.out.println(p4.isAbove(p3));
        if(!p4.isAbove(p3))mistakeCounter++;

        p1.setX(-5);
        p2.setY(-5);
        if(Math.round(p1.getX())<0 || Math.round(p1.getY())<0) mistakeCounter++;
        System.out.println("p1 after -x -y test: "+p1.toString());

        System.out.println("p1 to p2 distance: "+p1.distance(p2));
        System.out.println("p2 to p1 distance: "+p2.distance(p1));
        if(p1.distance(p2) != p2.distance(p1)) mistakeCounter++;
        System.out.println("p3 to p4 distance: "+p3.distance(p4));
        System.out.println("p4 to p3 distance: "+p4.distance(p3));
        if(p3.distance(p4) != p3.distance(p4)) mistakeCounter++;

        p4.setX(1);
        p4.setY(1);

        System.out.println(p3.isLeft(p4));
        if(p3.isLeft(p4))mistakeCounter++;
        System.out.println(p4.isRight(p3));
        if(p4.isRight(p3))mistakeCounter++;
        System.out.println(p3.isUnder(p4));
        if(p3.isUnder(p4))mistakeCounter++;
        System.out.println(p4.isAbove(p3));
        if(p4.isAbove(p3))mistakeCounter++;

        System.out.println(p3.equals(p4));

        if(!p3.equals(p4))mistakeCounter++;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Amount of mistakes in your code: "+mistakeCounter);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        /*
        Scanner input = new Scanner(System.in);
        String answer = "";
        while (!answer.equals("no")) {
            System.out.println("enter x");
            double length_of_x = input.nextDouble(); // The length of the 'x' leg of the right triangle.
            System.out.println("enter y");
            double length_of_y = input.nextDouble(); // The length of the 'y' leg of the right triangle.

            //----------------------------------------------------------------------------------------------
            //TODO: Start testing my own point!
            Point myPoint = new Point(length_of_x,length_of_y);
            System.out.println("x value: " + myPoint.getX());
            System.out.println("y value: " +myPoint.getY());
            System.out.println("my point toString: " + myPoint.toString());
            System.out.println("Now changing x+1");
            myPoint.setX(myPoint.getX()+1);
            System.out.println(myPoint.toString());
            System.out.println("Now changing y+1");
            myPoint.setY(myPoint.getY()+1);
            System.out.println(myPoint.toString());

            System.out.println("Creating a copy - ");
            Point copyPoint = new Point(myPoint);
            System.out.println(copyPoint.toString());
            copyPoint.setX(copyPoint.getX()-1);
            System.out.println("old point -");
            System.out.println(myPoint.toString());
            System.out.println("new point -");
            System.out.println(copyPoint.toString());
            System.out.println("is first Point Above second Point? "+ myPoint.isAbove(copyPoint));
            System.out.println("is first Point Under second Point? "+ myPoint.isUnder(copyPoint));
            System.out.println("is first Point Left second Point? "+ myPoint.isLeft(copyPoint));
            System.out.println("is first Point Right second Point? "+ myPoint.isRight(copyPoint));

            System.out.println("is second Point Above first Point? "+ copyPoint.isAbove(myPoint));
            System.out.println("is second Point Under first Point? "+ copyPoint.isUnder(myPoint));
            System.out.println("is second Point Left first Point? "+ copyPoint.isLeft(myPoint));
            System.out.println("is second Point Right first Point? "+ copyPoint.isRight(myPoint));
            System.out.println("the distance between First to Second: " + myPoint.distance(copyPoint));
            System.out.println("the distance between Second to First: " + copyPoint.distance(myPoint));
            System.out.println("is they equal? "+ myPoint.equals(copyPoint));
            copyPoint.setX(copyPoint.getX()+1);
            System.out.println("Annnnnnd maybe now?> "+ myPoint.equals(copyPoint));
            copyPoint.setY(copyPoint.getY()+2);
            System.out.println("First Point: " + myPoint.toString());
            System.out.println("Sec Point: " + copyPoint.toString());
            System.out.println("is first Point Above second Point? "+ myPoint.isAbove(copyPoint));
            System.out.println("is first Point Under second Point? "+ myPoint.isUnder(copyPoint));
            System.out.println("is first Point Left second Point? "+ myPoint.isLeft(copyPoint));
            System.out.println("is first Point Right second Point? "+ myPoint.isRight(copyPoint));
            System.out.println("is second Point Above first Point? "+ copyPoint.isAbove(myPoint));
            System.out.println("is second Point Under first Point? "+ copyPoint.isUnder(myPoint));
            System.out.println("is second Point Left first Point? "+ copyPoint.isLeft(myPoint));
            System.out.println("is second Point Right first Point? "+ copyPoint.isRight(myPoint));
            System.out.println("the distance between First to Second: " + myPoint.distance(copyPoint));
            System.out.println("the distance between Second to First: " + copyPoint.distance(myPoint));
            System.out.println("my Point: " + myPoint.toString());
            System.out.println("change First with -10 to x?");
            myPoint.move(-10,0);
            System.out.println(myPoint.toString());
            System.out.println("my Point: " + myPoint.toString());
            System.out.println("change First with 3 to x?");
            myPoint.move(3,0);
            System.out.println(myPoint.toString());
            System.out.println("my Point: " + myPoint.toString());
            System.out.println("change First with -10 to y?");
            myPoint.move(0, -10);
            System.out.println(myPoint.toString());
            System.out.println("change First with 3 to y?");
            myPoint.move(0,3);
            System.out.println(myPoint.toString());
            //----------------------------------------------------------------------------------------------
            // Calculating the degree of _alpha -
            double currSum = length_of_y / length_of_x;
            //System.out.println("the size of dividing " +currSum);
            double currRadian = Math.atan(currSum); //Math.tan return the radian value of my degree.
            double retVal = (currRadian * 180 / Math.PI);

            //System.out.println("my rad is: " + currRadian + ", and my degree is: " + retVal);
            System.out.println("do you wanna to continue?");
            answer = input.next();
        }
        */
    }
}
