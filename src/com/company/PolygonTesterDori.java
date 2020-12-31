package com.company;

public class PolygonTesterDori {

    public static void main(String[] args) {
        // Doriyan Esterin final tester!
        int mistakeCounter = 0;
        System.out.println("Starting to test your Polygon.java Class:");
        System.out.println("Create a Polygon- ");
        Polygon pol1 = new Polygon();
        System.out.println(pol1.toString());
        pol1.addVertex(0,2);
        pol1.addVertex(1,1);
        pol1.addVertex(3,0);
        pol1.addVertex(4,1);
        pol1.addVertex(7,2);
        System.out.println();
        System.out.println("updated Polygon: ");
        System.out.println(pol1.toString());
        System.out.println("highest point: "+ pol1.highestVertex());
        System.out.println("Perimeter: "+ pol1.calcPerimeter());
        System.out.println("Area: "+ pol1.calcArea());
        Point p1 = new Point(1,1);
        System.out.println("the spot of Point (1,1) is: "+pol1.findVertex(p1)+", suppose to be 1");
        System.out.println("next Point of (1,1) is: "+pol1.getNextVertex(p1)+", if it's (3,0) Good!");
        System.out.println("Box: "+ pol1.getBoundingBox());

        Polygon pol2 = new Polygon();
        pol2.addVertex(0,0);
        System.out.println(pol2.getNextVertex(new Point(0,0)));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Amount of mistakes in your code: "+mistakeCounter);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
