// 322209289 Hodaya Ben Yashar
package Objects;
/**
 * @author Hodaya Ben Yashar
 * The type Rectangle.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    private Point leftDown;
    private Point rightUp;
    private Point rightDown;


    /**
     * Constructs a new object - a rectangle.
     *
     * @param upperLeft the upper left point
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     */
// Create a new rectangle with location and width/height.
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.leftDown = new Point(upperLeft.getX(),
                               upperLeft.getY() + height);
        this.rightUp = new Point(upperLeft.getX() + width,
                                 upperLeft.getY() + height);
        this.rightDown = new Point(upperLeft.getX() + width,
                                      upperLeft.getY());
    }

    /**
     * Return a (possibly empty) List of intersection points with the specified
     * line.
     * @param line the line
     * @return the java . util . list
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> intersectPoints = new java.util.ArrayList<Point>();
        //the lines of the rectangle
        Line[] linesOfRec = {
                new Line(this.upperLeft, this.leftDown), new Line(this.leftDown,
                                                                  this.rightUp),
                new Line(this.rightUp, this.rightDown), new Line(this.rightDown,
                                                                    upperLeft)};
        for (int i = 0; i < linesOfRec.length; i++) {
            Point intersection = line.intersectionWith(linesOfRec[i]);
            if (intersection != null) {
                intersectPoints.add(intersection);
            }
        }
        return intersectPoints;
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return the width
     */
    public double getWidth() {
            return this.width;
        }

    /**
     * Returns the height of the rectangle.
     *
     * @return the height
     */
    public double getHeight() {
            return this.height;
        }

    /**
     * Returns the upper left point of the rectangle.
     *
     * @return the upper left point.
     */

    public Point getUpperLeft() {
            return this.upperLeft;
        }

    /**
     * Returns the left down point of the rectangle.
     *
     * @return the left down point.
     */
    public Point getLeftDown() {
        return this.leftDown;
    }

    /**
     * Returns the right up point of the rectangl.
     *
     * @return the right up point.
     */
    public Point getRightUp() {
        return this.rightUp;
    }

    /**
     * Returns the right down point of the rectangle.
     *
     * @return the right down
     */
    public Point getRightDown() {
        return this.rightDown;
    }
}
