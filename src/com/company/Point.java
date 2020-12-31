package com.company;
/**
 * Represents 2 dimensional points.
 * @author Doriyan Esterin/206765844.
 * @version 14/11/2020.
 */

public class Point {
    // Define variables of this class -
    private double _radius;
    private double _alpha;
    private final double MINIMAL_X_SIZE = 0; // The minimal value of x
    private final double MINIMAL_Y_SIZE = 0; // The minimal value of y
    private final double TRANSFORMER_OF_DEGREES_TO_RADIAN =  Math.PI / 180; // The value needed to multiply degree to get a radian
    private final double TRANSFORMER_OF_RADIAN_TO_DEGREES =  180 / Math.PI; // The value needed to multiply radian to get a degree
    private final double ROUNDER = 10000.0; // The value we use to round my calculation

    /**
     * Constructor for objects of class Point. Construct a new point with the specified x y coordinates. If the x coordinate is negative it is set to zero. If the y coordinate is negative it is set to zero.
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Point(double x, double y){
        updateAlphaAndRadius(x,y);
    }

    /**
     * Constructor for objects of class Point. Copy constructor, construct a point using another point.
     * @param other The point from which to construct the new object
     */
    public Point(Point other){
        if(other != null){
            this._radius = other._radius;
            this._alpha = other._alpha;
        }
    }

    /**
     * This method returns the x coordinate of the point.
     * @return The x coordinate of the point
     */
    public double getX(){
        // To calculate the value of x i will use the formula: cos(_alpah) = (length_of_x / _radius)
        // Need to remember to convert _alpha back to raidan because Math.cos need radian
        double currRadian = _alpha * TRANSFORMER_OF_DEGREES_TO_RADIAN;
        return Math.round((Math.cos(currRadian) * _radius)*ROUNDER)/ROUNDER ; //rounding the number to be able to test propely the code
    }

    /**
     * This method returns the y coordinate of the point.
     * @return The y coordinate of the point
     */
    public double getY(){
        // To calculate the value of x i will use the formula: sin(_alpah) = (length_of_y / _radius)
        // Need to remember to convert _alpha back to raidan because Math.cos need radian
        double currRadian = _alpha * TRANSFORMER_OF_DEGREES_TO_RADIAN;
        return Math.round((Math.sin(currRadian) * _radius)*ROUNDER)/ROUNDER ; //rounding the number to be able to test propely the code
    }

    /**
     * This method sets the x coordinate of the point. If the new x coordinate is negative the old x coordinate will remain unchanged.
     * @param x The new x coordinate
     */
    public void setX(double x){
        if(x > MINIMAL_X_SIZE){
       updateAlphaAndRadius(x,this.getY());
        }
    }

    /**
     * This method sets the y coordinate of the point. If the new y coordinate is negative the old y coordinate will remain unchanged.
     * @param y The new y coordinate
     */
    public void setY(double y){
        if(y > MINIMAL_Y_SIZE) {
            updateAlphaAndRadius(this.getX(), y);
        }
    }

    /**
     * Returns a string representation of Point in the format (x,y).
     * @return A String representation of the Point
     */
    public String toString(){
        // The round must be only in the toString -
        double length_Of_X = Math.round(getX()*ROUNDER)/ROUNDER; // Using .0 to cast to double the calculation instead using (double).
        double length_Of_Y = Math.round(getY()*ROUNDER)/ROUNDER; // Using .0 to cast to double the calculation instead using (double).
        return "(" + length_Of_X + "," + length_Of_Y + ")";
    }

    /**
     * Check if the given point is equal to this point.
     * @param other The point to check equality with
     * @return True if the given point is equal to this point
     */
    public boolean equals(Point other){
        return (_alpha == other._alpha && _radius == other._radius);
    }

    /**
     * Check if this point is above a received point.
     * @param other The point to check if this point is above
     * @return True if this point is above the other point
     */
    public boolean isAbove(Point other){
        return (this.getY() > other.getY());
    }

    /**
     * Check if this point is below a received point.
     * @param other The point to check if this point is below
     * @return True if this point is below the other point
     */
    public boolean isUnder (Point other){
        return other.isAbove(this);
    }

    /**
     * Check if this point is left of a received point.
     * @param other The point to check if this point is left of
     * @return True if this point is left of the other point
     */
    public boolean isLeft (Point other){
        return (this.getX() < other.getX());
    }

    /**
     * Check if this point is right of a received point.
     * @param other The point to check if this point is right of
     * @return True if this point is right of the other point
     */
    public boolean isRight (Point other){
        return (other.isLeft(this));
    }

    /**
     * Check the distance between this point and a given point.
     * @param other The point to check the distance from
     * @return The distance
     */
    public double distance (Point other){
        return Math.sqrt(Math.pow(other.getY() - this.getY(),2) + Math.pow(other.getX() - this.getX(),2));
    }

    /**
     * Moves a point. If either coordinate becomes negative the point remains unchanged.
     * @param dx The difference to add to x
     * @param dy The difference to add to y
     */
    public void move (double dx, double dy){
        if((this.getX()+dx >= MINIMAL_X_SIZE) && (this.getY()+dy >= MINIMAL_Y_SIZE)) {
            updateAlphaAndRadius(this.getX() + dx, this.getY() + dy);
        }
    }


    // This method is getting x and y of a Point and update the value of the _alpha degree and the value of _radius.
    // x - The x coordinate of the point.
    // y - The y coordinate of the point.
    private void updateAlphaAndRadius(double x, double y){
        // Define variables -
        double length_Of_X = MINIMAL_X_SIZE;
        double length_Of_Y = MINIMAL_Y_SIZE;
        final double DEFAULT_DEGREE_FOR_ZERO_VALUE = 90; // if x = 0 || x=0 && y=0 , then _alpha is 90 degrees.
        // Then test if any of them is bigger then 0, if they are then i will update the value to the current number -
        if(y > MINIMAL_Y_SIZE){
            length_Of_Y = y;
        }
        if(x > MINIMAL_X_SIZE){ // If x = 0 , _alpha = DEFAULT_DEGREE_FOR_ZERO_VALUE
            length_Of_X = x;
            // Calculating the degree of _alpha -
            double currRadian = Math.atan(length_Of_Y /length_Of_X); // Math.atan return the Radian value of my degree.
            _alpha = currRadian * TRANSFORMER_OF_RADIAN_TO_DEGREES; // (Radian * 180 / Pie) = the wanted degree.
        }
        else { // x must be in the first quarter then the only x that cannot be x > MINIMAL_X_SIZE is 0 -
            // If x equal to 0 then _alpha = 90 degrees.
            // If x equal to 0 and y also equal to 0, then _alpha = 90 degrees.
            _alpha =DEFAULT_DEGREE_FOR_ZERO_VALUE;
        }
        // Calculating the Radius of my degree (_alpha), using pythagoras sentence -
        // _radius = the size of the square of the addition of the power of the length of x leg and the power of the length of y leg.
        _radius = Math.sqrt((Math.pow(length_Of_X,2) + Math.pow(length_Of_Y,2)));
    }

}
