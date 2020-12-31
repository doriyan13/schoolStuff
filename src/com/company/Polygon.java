package com.company;
/**
 *  Represents a Polygon by an array of vertices of the Polygon by their order and the amount of vertices in the Polygon.
 * @author Doriyan Esterin/206765844.
 * @version 28/11/2020.
 */
public class Polygon {
    // Define variables of this class -
    private Point[] _vertices; // Array of the Points in the Polygon.
    private int _noOfVertices; // The number of Points in the Polygon.
    private int MAX_NUM_OF_VERTICES = 10; // The maximum number of Points in the Polygon.

    /**
     * Constructor for objects of class Polygon. Construct a new polygon with an empty array of Points with the maximum size of points the Polygon can have (10).
     */
    public Polygon(){
        _vertices = new Point[MAX_NUM_OF_VERTICES]; // The size of the array must be the max size from the start (10).
        _noOfVertices = 0; // At the start you don't have any points in the polygon.
    }

    /**
     * A method that add a Point to the Polygon. The method get 2 real numbers x,y and add a new Point into the Polygon in the first spot available in the array.
     * @param x The x coordinate
     * @param y The y coordinate
     * @return Return true if the addition of the new point was successful, return false if the array is full (have 10 points already!)
     */
    public boolean addVertex(double x, double y){
        // Assumptions:
        // The new point will not break the polygon (keep the degree angle under 180).
        // The point don't exist in the array already.
        // The use of addVertex method will always be by there showing order.
       if(_noOfVertices != MAX_NUM_OF_VERTICES){
           _vertices[_noOfVertices] = new Point(x,y); // Take the first empty spot and fill it with a new point.
           _noOfVertices++; // Up the amount of points by +1.
           return true;
       }
        return false; // return false if the array is full (have 10 points already!)
    }

    /**
     * Returning A copy of the the highest Point in my array, if the array is empty the method will return null.
     * @return - Returning A copy of the highest Point in my array, if the array is empty the method will return null.
     */
    public Point highestVertex(){
        int highest_Point_Spot = -1; // Index that will keep track which spot have the highest point in the array.
        for(int i=0;i<_noOfVertices;i++){ // loop through the array:
            if(highest_Point_Spot == -1){ //If this is the first point that i check:
                highest_Point_Spot = 0; // If i have any Points in the array then i will start by comparing with the first Point to the other Points in the array if i have any.
            }
            else if(_vertices[highest_Point_Spot].getY() < _vertices[i].getY()){ // The check for all the points after first point:
                highest_Point_Spot = i;
            }
        }
        if(highest_Point_Spot != -1) { // If the array isn't empty return the highest point:
            return new Point(_vertices[highest_Point_Spot]);
        }
        else { // If the array is empty return null:
            return null;
        }
    }

    /**
     * Returning a string representation of Polygon in the format: ((x,y),(x,y),...)
     * @return A string representation of Polygon in the format: ((x,y),(x,y),...)
     */
    public String toString(){
        String finished_Display_Of_Polygon = "";
        if(_noOfVertices == 0){
            finished_Display_Of_Polygon = "The polygon has 0 vertices.";
        }
        else{
            String first_Line_Message = "The polygon has "+ _noOfVertices + " vertices:";
            String display_Of_Polygon_Points = "(";

            for(int i = 0; i < _noOfVertices;i++){
                // Adding to the final String the display of the current point -
                display_Of_Polygon_Points = display_Of_Polygon_Points + _vertices[i].toString();
                // Creating index to keep track where i'm currently -
                int next_Spot = i+1;
                // If i have another point next then add "," to the final String that display the array of Points -
                if( next_Spot < _noOfVertices){
                    display_Of_Polygon_Points = display_Of_Polygon_Points + ",";
                }
                // If i'm in the last spot (next_Spot equals to the amount of the points) then close the final String that represent an array of points -
                if(next_Spot == _noOfVertices){
                    display_Of_Polygon_Points = display_Of_Polygon_Points + ")";
                }
            }
            // Building the finished String for display -
            finished_Display_Of_Polygon = first_Line_Message + "\n" + display_Of_Polygon_Points;
        }
        // Returning the finished String for display -
        return finished_Display_Of_Polygon;
    }

    /**
     * Returning the perimeter of the Polygon.
     * @return the perimeter of the Polygon.
     */
    public double calcPerimeter(){
        // If there are only 1 Point or 0 points - return 0;
        if(_noOfVertices == 0 || _noOfVertices == 1){
            return 0;
        }
        // If there are only 2 Points - return the distance between them -
        else if(_noOfVertices == 2){
            return _vertices[0].distance(_vertices[1]);
        }
        else{
            double polygon_Perimeter=0;
            for(int i = 0;i < _noOfVertices;i++){
                // Creating index to check keep track where i'm currently -
                int next_Spot = i+1;
                // Check if this isn't the last Point - if it doesn't then calculate the distance between the current Point and the next one.
                // And add it to the final Perimeter;
                if(next_Spot != _noOfVertices){
                    polygon_Perimeter += _vertices[i].distance(_vertices[next_Spot]);
                }
                // If this is the last Point then calculate the distance between the last Point and the first one.
                // And add it to the final Perimeter;
                else{
                    polygon_Perimeter += _vertices[i].distance(_vertices[0]);
                }
            }
            // Return the final Polygon  Perimeter
            return polygon_Perimeter;
        }
    }

    /**
     * Returning the area of the Polygon.
     * @return The area of the Polygon.
     */
    public double calcArea(){
        if(_noOfVertices < 3){ // If the Polygon have less then 3 Points then return 0.
            return 0;
        }
        else{
            // My for loop don't continue if you don't have 2 points a head and not 1 because the amount of triangle areas i need to calculate is always 2 less then the size of the number of points.
            // For example for 3 points - you have 1 Area to calculate, for 5 points you have 3 Areas to calculate...
            double sum_Triangle_Areas = 0;
            for(int i=0; (i + 2)< _noOfVertices;i++){
                    sum_Triangle_Areas += calcTriangleArea(_vertices[0], _vertices[i + 1], _vertices[i + 2]);
                    
            }
            return sum_Triangle_Areas;
        }
    }

    /**
     * This method get another Polygon, and return true if my Polygon have bigger area then the other Polygon, if not it will return false.
     * @param other another Polygon.
     * @return True if my Polygon have bigger area then the other Polygon, if not it will return false.
     */
    public boolean isBigger(Polygon other){
        // Assumptions:
        // The Polygon other will not be null!
        return this.calcArea() > other.calcArea();
    }

    /**
     * This method get a Point, if the point exist in the array the method  will return the spot of the point, if not then it will return -1.
     * @param p The point i want to see her spot in the array.
     * @return if the point exist in the array the method  will return the spot of the point, if not then it will return -1.
     */
    public int findVertex(Point p){
        // Assumptions:
        // The Point p will not be null!
        for(int i = 0; i<_noOfVertices;i++){
            if(p.equals(_vertices[i])){
                return i; // If i find a point that equals to the point p i will return the spot in the array.
            }
        }
        return -1; // If i don't have a matching point in the array then i will return -1.
    }

    /**
     * This method get a Point, return a copy of the Point that represent the next Point after her in the Polygon.
     * @param p - the Point i want to get the next after her.
     * @return - Returning the next Point in the array or act accordingly:
     *      * if the point have a point after her - it will return the a copy of the next point.
     *      * if the point doesn't exist in my array - return null.
     *      * if the point is the last point in the array - return a copy of the first point.
     *      * if the point is the only point in the array - return a copy of herself.
     */
    public Point getNextVertex(Point p){
        // Assumptions:
        // The Point p will not be null!
        for(int i = 0; i < _noOfVertices; i++){
            if(p.equals(_vertices[i])){
                // Creating index to check keep track where i'm currently -
                int next_Spot = i+1;
                // Verify that i have another point ahead -
                if(next_Spot < _noOfVertices){
                    return new Point(_vertices[next_Spot]);
                }
                // If this is the last Point or the only Point i will return the first Point -
                else{
                    return new Point(_vertices[0]);
                }
            }
        }
        // If this Point isn't in the array or i don't have any Points in the array -
        return null;
    }

    /**
     * Returning the bounding box of the Polygon.
     * @return The bounding box of the Polygon.
     */
    public Polygon getBoundingBox(){
        if(_noOfVertices >= 3){
            // Define variables to keep track the Min/Max of the X and Y to be able to calculate the final Box -
            // (I'm restarting them all with -1 which is out of the defining areas)
            double left_Side = -1;
            double right_Side = -1;
            double bottom_Side = -1;
            double top_Side = -1;

            for( int i = 0; i< _noOfVertices; i++){
                // If this is the first run i will put all the values of the first point as the start:
                if(i == 0){
                    left_Side = _vertices[0].getX();
                    right_Side = _vertices[0].getX();
                    top_Side = _vertices[0].getY();
                    bottom_Side = _vertices[0].getY();
                }
                // If this is not the first run -
                else {
                    // Keeping always the lowest x -
                    if (left_Side > _vertices[i].getX()) {
                        left_Side = _vertices[i].getX();
                    }
                    // Keeping always the highest x -
                    if (right_Side < _vertices[i].getX()) {
                        right_Side = _vertices[i].getX();
                    }
                    // Keeping always the lowest y -
                    if (bottom_Side > _vertices[i].getY()) {
                        bottom_Side = _vertices[i].getY();
                    }
                    // Keeping always the highest y -
                    if (top_Side < _vertices[i].getY()) {
                        top_Side = _vertices[i].getY();
                    }
                }
            }
            // After i got the 4 values (left,right,up and down) i can calculate the 4 points of the Box:
            Polygon box_Polygon = new Polygon();
            // First Point - (Left Bottom)
            box_Polygon.addVertex(left_Side,bottom_Side);
            // Second Point - (Right Bottom)
            box_Polygon.addVertex(right_Side,bottom_Side);
            // Third Point - (Right Top)
            box_Polygon.addVertex(right_Side,top_Side);
            // Fourth Point - (Left Top)
            box_Polygon.addVertex(left_Side,top_Side);

            // Returning an Array that will hold the box vertexes:
            return box_Polygon;
        }
        // If i have less then 4 Points return null -
        else{
            return null;
        }
    }

    // This method is getting 3 Points and calculates the Area of the Triangle.
    // p1 - First point of the Triangle.
    // p2 - Second point of the Triangle.
    // p3 - Third point of the Triangle.
    private double calcTriangleArea(Point p1, Point p2, Point p3){
        // Define the sides of the triangle:
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);

        double triangle_Half_Perimeter = (a+b+c)/2; // Half the triangle perimeter.

        // Heron Formula to calculate triangle Area: sqrt(s(s-a)(s-b)(s-c))
        return Math.sqrt(triangle_Half_Perimeter * (triangle_Half_Perimeter - a) * (triangle_Half_Perimeter - b) * (triangle_Half_Perimeter - c));
    }
}