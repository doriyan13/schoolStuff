package com.company;
/**
 * Segment1 represents a line (parallel to the x-axis) using two Points.
 * @author Doriyan Esterin/206765844.
 * @version 14/11/2020.
 */
public class Segment1 {
    // Define variables of this class -
    private Point _poLeft; // The left point of the Section.
    private Point _poRight; // The right point of the Section.
    private final double NO_CHANGE_IN_VALUE = 0;
    private final double DEFAULT_RETURN_VALUE = 0;
    private final double MINIMAL_X_SIZE = 0;
    private final double MINIMAL_Y_SIZE = 0;

    /**
     * Constructs a new segment using two Points. If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     * @param left  - the left point of the segment
     * @param right - the right point of the segment
     */
    public Segment1(Point left, Point right) {
        // We can assume that we get 2 points that are not null
        // Setting the left point of Segment -
        _poLeft = new Point(left.getX(), left.getY());

        // You can save this if and else and always put the y value of x in _poRight because if they equal
        // the left.getY() == right.getY() and if they are not equal then i use the left.getX() value
        // Setting the right point of Segment -
        if (left.getY() > right.getY() || left.getY() < right.getY()) {
            _poRight = new Point(right.getX(), left.getY()); // Create _poRight with left point Y value
        } else {
            _poRight = new Point(right.getX(), left.getY());
        }
    }

    /**
     * Constructs a new segment using 4 specified x y coordinates: Two coordinates for the left point and two coordinates for the right point. If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     * @param leftX  - X value of left point
     * @param leftY  - Y value of left point
     * @param rightX - X value of right point
     * @param rightY - Y value of right point
     */
    public Segment1(double leftX, double leftY, double rightX, double rightY) {
        if(leftX >= MINIMAL_X_SIZE && leftY >= MINIMAL_Y_SIZE && rightX >= MINIMAL_X_SIZE && rightY >=MINIMAL_Y_SIZE) {
            // Setting the left point of Segment -
            _poLeft = new Point(leftX, leftY);

            if (leftY > rightY || leftY < rightY) {
                _poRight = new Point(rightX, leftY); // Create _poRight with left point Y value
            } else {
                _poRight = new Point(rightX, rightY);
            }
        }
    }

    /**
     * Copy Constructor. Construct a segment using a reference segment.
     * @param other - the reference segment
     */
    public Segment1(Segment1 other) {
        _poLeft = new Point(other._poLeft.getX(), other._poLeft.getY());
        _poRight = new Point(other._poRight.getX(), other._poRight.getY());
    }

    /**
     * Returns the left point of the segment.
     * @return The left point of the segment
     */
    public Point getPoLeft() {
        return new Point(_poLeft.getX(), _poLeft.getY());
    }

    /**
     * Returns the right point of the segment.
     * @return The right point of the segment
     */
    public Point getPoRight() {
        return new Point(_poRight.getX(), _poRight.getY());
    }

    /**
     * Returns the segment length.
     * @return The segment length
     */
    public double getLength() {
        return _poRight.getX() - _poLeft.getX();
    }

    /**
     * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
     * @return String representation of this segment
     */
    public String toString() {
        return _poLeft.toString() + "---" + _poRight.toString();
    }

    /**
     * Check if the reference segment is equal to this segment.
     * @param other - the reference segment
     * @return True if the reference segment is equal to this segment
     */
    public boolean equals(Segment1 other) {
        return _poLeft.equals(other._poLeft) && _poRight.equals(other._poRight);
    }

    /**
     * Check if this segment is above a reference segment.
     * @param other - the reference segment
     * @return True if this segment is above the reference segment
     */
    public boolean isAbove(Segment1 other) {
        return _poLeft.isAbove(other._poLeft);
    }

    /**
     * Check if this segment is under a reference segment.
     * @param other - the reference segment
     * @return True if this segment is under the reference segment
     */
    public boolean isUnder(Segment1 other) {
        return other.isAbove(this);
    }

    /**
     * Check if this segment is left of a received segment.
     * @param other - the reference segment
     * @return True if this segment is left to the reference segment
     */
    public boolean isLeft(Segment1 other) {
        return _poRight.getX() < other._poLeft.getX();
    }

    /**
     * Check if this segment is right of a received segment.
     * @param other - the reference segment
     * @return True if this segment is right to the reference segment
     */
    public boolean isRight(Segment1 other) {
        return other.isLeft(this);
    }

    /**
     * Move the segment horizontally by delta.
     * @param delta - the displacement size
     */
    public void moveHorizontal(double delta) {
        if (delta != NO_CHANGE_IN_VALUE && (_poLeft.getX() + delta >= MINIMAL_X_SIZE)) {
            _poLeft.move(delta, NO_CHANGE_IN_VALUE);
            _poRight.move(delta, NO_CHANGE_IN_VALUE);
        }
    }

    /**
     * Move the segment vertically by delta.
     * @param delta - the displacement size
     */
    public void moveVertical(double delta) {
        if (delta != NO_CHANGE_IN_VALUE && (_poLeft.getY() + delta >= MINIMAL_Y_SIZE)) {
            _poLeft.move(NO_CHANGE_IN_VALUE, delta);
            _poRight.move(NO_CHANGE_IN_VALUE, delta);
        }
    }

    /**
     * Change the segment size by moving the right point by delta. Will be implemented only for a valid delta: only if the new right point remains the right point.
     * @param delta - the length change
     */
    public void changeSize(double delta) {
        if (delta != NO_CHANGE_IN_VALUE && _poRight.getX() + delta > _poLeft.getX()) {
            _poRight.setX(_poRight.getX() + delta);
        }
    }

    /**
     * Check if a point is located on the segment.
     * @param p - a point to be checked
     * @return True if p is on this segment
     */
    public boolean pointOnSegment(Point p) {
        boolean is_On_Segment = false;
        if(p.getY() == this._poLeft.getY()) {
            if (p.isRight(this._poLeft) && p.isLeft(this._poRight)) {
                is_On_Segment = true;
            }
            else if(p.getX() == this._poLeft.getX()){
                is_On_Segment = true;
            }
            else if(p.getX() == this._poRight.getX()){
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
    public boolean isBigger(Segment1 other){
        return this.getLength() > other.getLength();
    }

    /**
     * Returns the overlap size of this segment and a reference segment.
     * @param other - the reference segment
     * @return The overlap size
     */
    public double overlap(Segment1 other){
        double overlapSize = DEFAULT_RETURN_VALUE;
        // If my left point is left to the left point of other-
        if(this._poLeft.isLeft(other._poLeft)){
            if(this._poRight.isRight(other._poLeft)){
                if(this._poRight.isLeft(other._poRight)){
                    overlapSize = this._poRight.getX() - other._poLeft.getX();
                }
                else{
                    overlapSize = other.getLength();
                }
            }
        }
        // If my left point is right to the left point of other-
        else if(this._poLeft.isRight(other._poLeft) && this._poLeft.isLeft(other._poRight)){
            if(this._poRight.isRight(other._poRight)){
                overlapSize = other._poRight.getX() - this._poLeft.getX();
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
     * Compute the trapeze perimeter, which is constructed by this segment and a reference segment.
     * @param other - the reference segment
     * @return The trapeze perimeter
     */
    public double trapezePerimeter(Segment1 other){
        // Some of the calculations may be close but not the exact number because i added to Point.getX() / Point.getY() round to make the other tests work!
        double leftSide = this._poLeft.distance(other._poLeft);
        double rightSide = other._poRight.distance(this._poRight);
        return this.getLength() + other.getLength() + leftSide + rightSide;
    }
}