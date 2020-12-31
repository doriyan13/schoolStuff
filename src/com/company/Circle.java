package com.company;
import java.util.Scanner;
/* Name of the Class -  Circle.java
   Name of the writer - Doriyan Esterin.
   Date -               29/10/20.
   The purpose of this class - get the input of 2 points (getting the x and the y of each point separately)
                               and return  the radius, area and perimeter of the Incircle and the Excircle
                               that created by the Rectangle that can be created by these points.
   ground rules for this program -
    1.)all the inputs that i get from the user are legal.
    2.)leftUpX < rightDownX.
    3.)LeftUpY > rightDownY.
    4.) (rightDownX - leftUpX) > (leftUpY - rightDownY).
*/
public class Circle {

    public static void main(String[] args) {
        final double PIE_VALUE = Math.PI; // Keep the value of pie in a final for easier understanding
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program calculates the areas " +
                "and the perimeters of the excircle and the incircle " +
                "of a given rectangle ");
        System.out.print ("Please enter the two coordinates of the " +
                "left-upper point of the rectangle");
        // First point -
        int leftUpX = scan.nextInt(); // Input the x of the left-up point.
        int leftUpY = scan.nextInt(); // Input the y of the left-up point.
        System.out.print ("Please enter the two coordinates of the " +
                "right-down point of the rectangle");
        // Second point -
        int rightDownX = scan.nextInt(); // Input the x of the right-down point.
        int rightDownY = scan.nextInt(); // Input the y of the right-down point.
        // Calculate the incircle -
        double incircle_radius = (leftUpY - rightDownY) / 2.0; // Radius = Half the size of the distance between the y of the points. i'm dividing with 2.0 to cast the calculation to a double value
        double incircle_area = PIE_VALUE * Math.pow(incircle_radius, 2); // Area = Pie * Radius^2.
        double incircle_perimeter = incircle_radius * PIE_VALUE * 2; // Perimeter = 2 * Pie * Radius.
        // Calculate the excircle -
        double excircle_radius = (Math.sqrt(Math.pow((leftUpX - rightDownX),2) + Math.pow((leftUpY - rightDownY),2))) / 2; // Excircle Radius = Half the size of the square of the addition of the power of the distance between x (of the 2 points) and the power of the distance between y (of the 2 points).
        double excircle_area = PIE_VALUE * Math.pow(excircle_radius, 2); // Area = Pie * Radius^2.
        double excircle_perimeter = excircle_radius * PIE_VALUE * 2; // Perimeter = 2 * Pie * Radius.
        // Printing the final out put -
        System.out.println("Incircle: radius = "+ incircle_radius +", "+"area = " + incircle_area + ", " + "perimeter = " + incircle_perimeter);
        System.out.println("Excircle: radius = "+ excircle_radius +", "+"area = " + excircle_area + ", " + "perimeter = " + excircle_perimeter);
    }
}
