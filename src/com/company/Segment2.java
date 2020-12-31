package com.company;
/**
 * Segment2 represents a line (parallel to the x-axis) using a center point and length.
 * @author Doriyan Esterin/206765844.
 * @version 14/11/2020.
 */
public class Segment2 {
    // Define variables of this class -
    private Point _poCenter; // The center point of the Section.
    private double _length; // The length of the Section.
    private final double NO_CHANGE_IN_VALUE = 0;
    private final double DEFAULT_RETURN_VALUE = 0;
    private final double MINIMAL_X_SIZE = 0;
    private final double MINIMAL_Y_SIZE = 0;

    /**
     * Constructs a new segment using a center point and the segment length.
     * @param poCenter - the Center Point
     * @param length - the segment length
     */
    public Segment2(Point poCenter, double length) {
        // Normally i will test if the value isn't null / indeed in the defined area but i know the points must be good
        // and only need to verify the length -
        _poCenter = new Point(poCenter);
        if(length >= DEFAULT_RETURN_VALUE){
            _length = length;
        }
        else{
            _length = DEFAULT_RETURN_VALUE;
        }
    }

    /**
     * Constructs a new segment using two Points. If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     * @param left - the left point of the segment
     * @param right - the right point of the segment
     */
    public Segment2(Point left, Point right){
        //TODO: verify the value of points is going to be vaild???
        double mid_X_Value = (right.getX() + left.getX()) / 2;
        double mid_Y_Value = left.getY(); // Either way the y value of left point is valid
        _poCenter = new Point(mid_X_Value,mid_Y_Value);
        _length = right.getX() - left.getX();
    }

    /**
     * Constructs a new segment using 4 specified x y coordinates: two coordinates for the left point and two coordinates for the right point. If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     * @param leftX - X value of left point
     * @param leftY - Y value of left point
     * @param rightX - X value of right point
     * @param rightY - Y value of right point
     */
    public Segment2(double leftX, double leftY, double rightX, double rightY) {
        if (leftX >= MINIMAL_X_SIZE && leftY >= MINIMAL_Y_SIZE && rightX >= MINIMAL_X_SIZE && rightY >= MINIMAL_Y_SIZE) {
            double mid_X_Value = (leftX + rightX) / 2;
            double mid_Y_Value = leftY; // Either way the y value of left point is valid
            _poCenter = new Point(mid_X_Value,mid_Y_Value);
            _length = rightX - leftX;
        }
    }

    /**
     * Copy Constructor. Construct a segment using a reference segment.
     * @param other - the reference segment
     */
    public Segment2(Segment2 other){
        _poCenter = new Point(other._poCenter);
        _length = other._length;
    }

    /**
     * Returns the left point of the segment.
     * @return The left point of the segment
     */
    public Point getPoLeft(){
        double mid_X_Value = _poCenter.getX() - (_length/2);
        double mid_Y_Value = _poCenter.getY();
        if(mid_X_Value<MINIMAL_X_SIZE){
            mid_X_Value = MINIMAL_X_SIZE;
        }
        return new Point(mid_X_Value,mid_Y_Value);
    }

    /**
     * Returns the right point of the segment.
     * @return The right point of the segment
     */
    public Point getPoRight(){
        double mid_X_Value = _poCenter.getX() + (_length/2);
        double mid_Y_Value = _poCenter.getY();
        if(mid_X_Value<MINIMAL_X_SIZE){
            mid_X_Value = MINIMAL_X_SIZE;
        }
        return new Point(mid_X_Value,mid_Y_Value);
    }

    /**
     * Returns the segment length.
     * @return The segment length
     */
    public double getLength(){
        return _length;
    }

    /**
     * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
     * @return String representation of this segment
     */
    public String toString() {
        return getPoLeft().toString() + "---" + getPoRight().toString();
    }

    /**
     * Check if the reference segment is equal to this segment.
     * @param other - the reference segment
     * @return True if the reference segment is equal to this segment
     */
    public boolean equals(Segment2 other){
        return _poCenter.equals(other._poCenter) && _length == other._length;
    }

    /**
     * Check if this segment is above a reference segment.
     * @param other - the reference segment
     * @return True if this segment is above the reference segment
     */
    public boolean isAbove(Segment2 other) {
       return _poCenter.isAbove(other._poCenter);
    }

    /**
     * Check if this segment is under a reference segment.
     * @param other - the reference segment
     * @return True if this segment is under the reference segment
     */
    public boolean isUnder(Segment2 other) {
        return other.isAbove(this);
    }

    /**
     * Check if this segment is left of a received segment.
     * @param other - the reference segment
     * @return True if this segment is left to the reference segment
     */
    public boolean isLeft(Segment2 other) {
        return this.getPoRight().getX() < other.getPoLeft().getX();
    }

    /**
     * Check if this segment is right of a received segment.
     * @param other - the reference segment
     * @return True if this segment is right to the reference segment
     */
    public boolean isRight(Segment2 other) {
        return other.isLeft(this);
    }

    /**
     * Move the segment horizontally by delta. Will be implemented only for a valid delta
     * @param delta - the displacement size
     */
    public void moveHorizontal(double delta) {
        if (delta != NO_CHANGE_IN_VALUE && (getPoLeft().getX() + delta >= MINIMAL_X_SIZE)) {
            _poCenter.move(delta, NO_CHANGE_IN_VALUE);
        }
    }

    /**
     * Move the segment vertically by delta. Will be implemented only for a valid delta
     * @param delta - the displacement size
     */
    public void moveVertical(double delta) {
        if (delta != NO_CHANGE_IN_VALUE && (getPoLeft().getY() + delta >= MINIMAL_Y_SIZE)) {
            _poCenter.move(NO_CHANGE_IN_VALUE, delta);
        }
    }

    /**
     * Change the segment size by moving the right point by delta. Will be implemented only for a valid delta: only if the new right point remains the right point.
     * @param delta - the length change
     */
    public void changeSize(double delta) {
        if (delta != NO_CHANGE_IN_VALUE && getPoRight().getX() + delta > getPoLeft().getX()) {
            double new_X_Value = ((getPoRight().getX() + delta) + getPoLeft().getX()) / 2;
            _poCenter.setX(new_X_Value);
            _length = (getPoRight().getX() + delta) - getPoLeft().getX();
        }
    }

    /**
     * Check if a point is located on the segment.
     * @param p - a point to be checked
     * @return True if p is on this segment
     */
    public boolean pointOnSegment(Point p) {
        boolean is_On_Segment = false;
        if(p.getY() == this.getPoLeft().getY()) {
            if (p.isRight(this.getPoLeft()) && p.isLeft(this.getPoRight())) {
                is_On_Segment = true;
            }
            else if(p.getX() == this.getPoLeft().getX()){
                is_On_Segment = true;
            }
            else if(p.getX() == this.getPoRight().getX()){
                is_On_Segment = true;
            }
        }
        return is_On_Segment;
    }

    /**
     * Check if this segment is bigger than a reference segment.
     * @param other - the reference segment
     * @return True if this segment is bigger than the reference segment
     */
    public boolean isBigger(Segment2 other){
        return this.getLength() > other.getLength();
    }

    /**
     * Returns the overlap size of this segment and a reference segment.
     * @param other - the reference segment
     * @return The overlap size
     */
    public double overlap(Segment2 other){
        double overlapSize = DEFAULT_RETURN_VALUE;
        // If my left point is left to the left point of other-
        if(this.getPoLeft().isLeft(other.getPoLeft())){
            if(this.getPoRight().isRight(other.getPoLeft())){
                if(this.getPoRight().isLeft(other.getPoRight())){
                    overlapSize = this.getPoRight().getX() - other.getPoLeft().getX();
                }
                else{
                    overlapSize = other.getLength();
                }
            }
        }
        // If my left point is right to the left point of other-
        else if(this.getPoLeft().isRight(other.getPoLeft()) && this.getPoLeft().isLeft(other.getPoRight())){
            if(this.getPoRight().isRight(other.getPoRight())){
                overlapSize = other.getPoRight().getX() - this.getPoLeft().getX();
            }
            else{
                overlapSize = this.getLength();
            }
        }
        else if(this.getPoLeft().getX() == other.getPoLeft().getX()){
            if(this.getPoRight().isRight(other.getPoRight())){
                overlapSize = other.getPoRight().getX() - this.getPoLeft().getX();
            }
            else if(this.getPoRight().isLeft(other.getPoRight())){
                overlapSize = this.getPoRight().getX() - this.getPoLeft().getX();
            }
            else{ // this._poRight == other._poRight
                overlapSize = this.getLength();
            }
        }
        return Math.abs(overlapSize);
    }

    /**
     * Compute the trapeze perimeter, which constructed by this segment and a reference segment.
     * @param other - the reference segment
     * @return The trapeze perimeter
     */
    public double trapezePerimeter(Segment2 other){
        // Some of the calculations may be close but not the exact number because i added to Point.getX() / Point.getY() round to make the other tests work!
        double leftSide = this.getPoLeft().distance(other.getPoLeft());
        double rightSide = other.getPoRight().distance(this.getPoRight());
        return this.getLength() + other.getLength() + leftSide + rightSide;
    }
}
