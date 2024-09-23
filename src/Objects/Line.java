// 322209289 Hodaya Ben Yashar
package Objects;
/**
 * @author Hodaya Ben Yashar
 * The type Line.
 */

public class Line {
    private static final double THRESHOLD = 0.00001;
    private Point start;
    private Point end;
    private double x;
    private double y;
    /**
     * Constructs a new object-line build with given 2 points.
     * <p></p>
     * @param start ,the start point  .
     * @param end ,the end point .
     */
    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
    }
    /**
     * Constructs a new object-line build with given 4 coordinates of 2 points.
     * <p></p>
     * @param x1 ,the x coordinate of the first point.
     * @param y1 ,the y coordinate of the first point.
     * @param x2 ,the x coordinate of the second point.
     * @param y2 ,the y coordinate of the second point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    /**
     * Calculates the length of the line with the distance of 2 points.
     * <p></p>
     * @return returns the length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }
    /**
     * Calculates the middle point of the line.
     * <p></p>
     * @return returns the middle point of the line.
     */
    public Point middle() {
        return new Point((start.getX() + end.getX()) / 2,
                (start.getY() + end.getY()) / 2);
    }
    /**
     * Calculates the start point of the line.
     * <p></p>
     * @return returns the start point of the line.
     */
    public Point start() {
        return this.start;
    }
    /**
     * Calculates the end point of the line.
     * <p></p>
     * @return returns the end point of the line.
     */
    public Point end() {
        return this.end;
    }
    /**
     * Calculates the slope of the line.
     * <p></p>
     * @return returns the slop of the line and 0 if the x coordinates of both
     * point is the same
     */
    public double slope() {
        //checking if the x coordinate in both point is the same
        if ((Math.abs(this.end.getX() - this.start.getX()) < THRESHOLD)) {
            return 0;
        } else {
            return (this.end.getY() - this.start.getY())
                    /  (this.end.getX() - this.start.getX());
        }
    }
    /**
     * Checking if line is vertical.
     * <p></p>
     * @return returns true if the line is vertical, and false otherwise.
     */
    public boolean vertical() {
        return Math.abs(this.end.getX() - this.start.getX()) < THRESHOLD;
    }
    /**
     * Find the intersection between the line to the Y axis.
     * <p></p>
     * @return returns the y value of the intersection between the line to the
     * Y axis, and 0 if the line is vertical.
     */
    public double yMeeting() {
        //if line vertical
        if (this.vertical()) {
            return 0;
        } else {
            return this.start.getY() - this.slope() * this.start.getX();
        }
    }
    /**
     *  The function checking if the point is in the range of the line.
     *  <p></p>
     * @param pOther ,the point that we want to check.
     * @return true if the point is in the range of the line, false otherwise.
     */
    public boolean isInRange(Point pOther) {
        double minX = Math.min(start.getX(), end.getX());
        double maxX = Math.max(start.getX(), end.getX());
        double minY = Math.min(start.getY(), end.getY());
        double maxY = Math.max(start.getY(), end.getY());
        return (pOther.getX() >= minX
                || Math.abs(minX - pOther.getX()) < THRESHOLD)
                && (pOther.getX() <= maxX
                || Math.abs(maxX - pOther.getX()) < THRESHOLD)
                && (pOther.getY() >= minY
                || Math.abs(minY - pOther.getY()) < THRESHOLD)
                && (pOther.getY() <= maxY
                || Math.abs(maxY - pOther.getY()) < THRESHOLD);
    }
    /**
     *  The function find the intersection point between two lines.
     *  <p></p>
     * @param other ,the other line we are checking with.
     * @return Returns the intersection point if the lines intersect,and null
     * otherwise.
     */
    public Point intersectionWith(Line other) {
        double slope1 = this.slope();
        double yMeet1 = this.yMeeting();
        double slope2 = other.slope();
        double yMeet2 = other.yMeeting();
        Point intersection;
        Point realStart1 = this.start;
        Point realEnd1 = this.end;
        Point realStart2 = other.start;
        Point realEnd2 = other.end;
        //determined which point is bigger (in the y coordinate)
        if (Math.abs(this.start.getX() - this.end.getX()) < THRESHOLD) {
            if (this.start.getY() > this.end.getY()) {
                realStart1 = this.end;
                realEnd1 = this.start;
            }
        } else if (this.start.getX() > this.end.getX()) {
            realStart1 = this.end;
            realEnd1 = this.start;
        }
        //other line
        if (Math.abs(other.start.getX() - other.end.getX()) < THRESHOLD) {
            if (other.start.getY() > other.end.getY()) {
                realStart2 = other.end;
                realEnd2 = other.start;
            }
        } else if (other.start.getX() > other.end.getX()) {
            realStart2 = other.end;
            realEnd2 = other.start;
        }
        //if both line are vertical but not the same line
        if (this.vertical() && other.vertical()
                && this.start.getX() != other.start.getX()) {
            return null;
        }
        //if the two lines are parallel
        if ((Math.abs(slope1 - slope2) < THRESHOLD)
                && (yMeet1 != yMeet2 || yMeet2 == 0)) {
            // checking if the 2 lines are verticals to each other
            if (this.vertical() && !other.vertical()) {
                intersection = new Point(this.start.getX(), other.yMeeting());
                //checking if the point is in the range of the lines
                if ((!(this.isInRange(intersection)))
                        || (!(other.isInRange(intersection)))) {
                    return null;
                } else {
                    return intersection;
                }
                //return intersection;
            } else if (other.vertical() && !this.vertical()) {
                intersection = new Point(other.start.getX(), this.yMeeting());
                //checking if the point is in the range of the lines
                if ((!(this.isInRange(intersection)))
                        || (!(other.isInRange(intersection)))) {
                    return null;
                } else {
                    return intersection;
                }
                // return intersection;
            } else {
                if (realStart1.equals(realEnd2)) {
                    return realStart1;
                }
                if (realEnd1.equals(realStart2)) {
                    return realEnd1;
                } else {
                    return null;
                }
            }
        }
        if (this.vertical()) {
            // This line is vertical, so its x coordinate is constant
            double x = this.start.getX();
            double y = other.slope() * x + other.yMeeting();
            intersection = new Point(x, y);
        } else if (other.vertical()) {
            // The other line is vertical, so its x-coordinate is constant
            double x = other.start.getX();
            double y = this.slope() * x + this.yMeeting();
            intersection = new Point(x, y);
            // checking if the lines are horizontal
        } else if (Math.abs(slope1 - slope2) < THRESHOLD) {
            double x = 0;
            double y = this.slope() * x + this.yMeeting();
            intersection = new Point(x, y);
        } else {
            double x = (yMeet2 - yMeet1) / (slope1 - slope2);
            double y = slope1 * x + yMeet1;
            intersection = new Point(x, y);
        }
        //checking if the lines are the same lines
        if (((Math.abs(slope1 - slope2) < THRESHOLD)
                && (Math.abs(yMeet1 - yMeet2) < THRESHOLD))
                || (this.vertical() && other.vertical()
                &&  (Math.abs(this.start.getX() - other.start.getX())
                              < THRESHOLD))) {
            //check if the lines contain ech other
            if ((Math.abs(realStart1.getX() - realStart2.getX())
                    < THRESHOLD
                    || realStart1.getX() <= realStart2.getX())
                    && (Math.abs(realEnd1.getX() - realEnd2.getX())
                    < THRESHOLD
                    || realEnd1.getX() >= realEnd2.getX())
                    || (Math.abs(realStart2.getX() - realStart1.getX())
                    < THRESHOLD
                    || realStart2.getX() <= realStart1.getX())
                    && (Math.abs(realEnd2.getX() - realEnd1.getX())
                    < THRESHOLD
                    || realEnd2.getX() >= realEnd1.getX())) {
                return null;
            }
            //same start point
            if (realStart1.equals(realEnd2) && !realEnd1.equals(realStart2)) {
                return realStart1;
                //same end point
            } else if (realEnd1.equals(realStart2)
                    && !realStart1.equals(realEnd2)) {
                return realEnd1;
            } else {
                //not have exactly 1 point that intersected
                return null;
            }
        }
        //checking if the point is in the range of the lines
        if ((!(this.isInRange(intersection)))
                || (!(other.isInRange(intersection)))) {
            return null;
        } else {
            return intersection;
        }
    }

    /**
     *  The function find if there is an intersection point between two lines.
     *  <p></p>
     * @param other ,the other line we are checking with.
     * @return Returns true if the lines are Intersecting and false otherwise.
     */
    public boolean isIntersecting(Line other) {
        if (((Math.abs(this.slope() - other.slope()) < THRESHOLD)
                && (Math.abs(this.yMeeting() - other.yMeeting())
                < THRESHOLD))) {
            return this.isInRange(other.start()) || this.isInRange(other.end())
                    || this.intersectionWith(other) != null;
        }
        return this.intersectionWith(other) != null;
    }
    /**
     *  The function checking if the lines are equals.
     *  <p></p>
     * @param other ,the other line we are checking with.
     * @return Returns true if the lines are equals, and false otherwise.
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start) && this.end.equals(other.end))
                || (this.start.equals(other.end) && this.end.equals(other.start)
                   );
    }
    /**
     *  The function finds the closest intersection point (between the line and
     *  the rectangle)to the start of the line.
     *  <p></p>
     *  If this line does not intersect with the rectangle, return null.
     * @param rect ,the rectangle that we are checking the intersection points.
     * @return return the closest intersection point to the
     * start of the line. otherwise return null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        double distance;
        java.util.List<Point> intersectionPoints =
                rect.intersectionPoints(this);
        //If this line does not intersect with the rectangle, return null.
        if (intersectionPoints.isEmpty()) {
            return null;
        }
        Point closestPoint = intersectionPoints.get(0);
        double closeDist = start.distance(closestPoint);
        for (int i = 1; i < intersectionPoints.size(); i++) {
            distance = start.distance(intersectionPoints.get(i));
            if (distance < closeDist) {
                closestPoint = intersectionPoints.get(i);
                closeDist = distance;
            }
        }
        return closestPoint;
    }
}


