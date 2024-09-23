// 322209289 Hodaya Ben Yashar
package Objects;
/**
 * @author Hodaya Ben Yashar
 * The type Velocity.
 */
public class Velocity {
    //fields
    private double dx;
    private double dy;

    /**
     * constructor of a new Velocity.
     * @param dx the dx
     * @param dy the dy
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Gets dx.
     * @return the dx
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Gets dy.
     * @return the dy
     */
    public double getDy() {
        return this.dy;
    }
    /**
     * Takes a point with position(x,y)
     * and return a new one with position(x+dx, y+dy).
     * @param p the point
     * @return the point that we wanted
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * From angle and speed creating a velocity.
     * @param angle the angle
     * @param speed the speed
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radianAngle = Math.toRadians(angle);
        double dx = speed * Math.sin(radianAngle);
        double dy = -speed * Math.cos(radianAngle);
        return new Velocity(dx, dy);
    }
}
