// 322209289 Hodaya Ben Yashar
package Objects;
/**
 * @author Hodaya Ben Yashar
 * The type Point.
 */
public class Point {
    private static final double THRESHOLD = 0.00001;
    // Fields
    private double x;
    private double y;
    /**
     * Constructs a new object-point with given x, y.
     * <p></p>
     * @param x ,the x coordinate of the point .
     * @param y ,the y coordinate of the point .
     */
    // constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;

    }
    /**
     * Calculates the distance of this point to the other point.
     * <p></p>
     * @param other ,another point for the calculates .
     * @return return the distance between the points.
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.getX()) * (this.x - other.getX()))
                + ((this.y - other.getY()) * (this.y - other.getY())));
    }
    /**
     * Checking if the point are equal.
     * <p></p>
     * @param other ,another point for the check .
     * @return return true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        return (Math.abs(this.x - other.getX()) < THRESHOLD)
                && (Math.abs(this.y - other.getY()) < THRESHOLD);
    }
    /**
     * gets the x coordinate of the point.
     * <p></p>
     * @return return the x value of this point.
     */
    public double getX() {
        return this.x;

    }
    /**
     * gets the y coordinate of the point.
     * <p></p>
     * @return return the y value of this point.
     */
    public double getY() {
        return this.y;
    }
}

