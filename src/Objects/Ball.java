// 322209289 Hodaya Ben Yashar
package Objects;
import Game.GameLevel;
import Game.GameEnvironment;
//import Game_Flow.GameLevel;
import Game_Help.CollisionInfo;
import Game_Help.Sprite;
import biuoop.DrawSurface;
/**
 * @author Hodaya Ben Yashar
 * The type Ball.
 */
public class Ball implements Sprite {
    private static final double THRESHOLD = 0.00001;
    //fields
    private Point center;
    private int r;
    private double x;
    private double y;
    private double rightLimit;
    private double leftLimit;
    private double topLimit;
    private double lowLimit;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;


    /**
     * Constructor for a new Ball.
     *
     * @param center          the center point
     * @param r               the radius
     * @param color           the color
     * @param gameEnvironment the gameEnvironment
     */
    public Ball(Point center, int r, java.awt.Color color,
                GameEnvironment gameEnvironment) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * another constructor for a new Ball.
     *
     * @param x     the x coordinate for the center point
     * @param y     the y coordinate for the center point
     * @param r     the radius
     * @param color the color
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    /**
     * Gets x.
     *
     * @return the x coordinate of the center point
     */
// accessors
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Gets y.
     *
     * @return the y coordinate of the center point
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Gets center point.
     *
     * @return the center point
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * Gets size of the radius.
     *
     * @return the size of the radius.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface the surface
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(),
                           r);
    }
    /**
     * Notify the ball that time has passed so move one step.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }
    /**
     * Add the ball to the game ( to the sprite list).
     */
    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * Sets velocity according to the value that is sent.
     *
     * @param v the velocity.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets the velocity according to the values that are sent.
     *
     * @param dx the dx of the velocity
     * @param dy the dy of the velocity
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Sets the game environment.
     *
     * @param g the game environment.
     */
    public void setGameEnvironment(GameEnvironment g) {
         this.gameEnvironment = g;
    }

    /**
     * Gets the velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /**
     * Sets borders.
     *
     * @param leftLimit  the left limit
     * @param rightLimit the right limit
     * @param lowLimit   the low limit
     * @param topLimit   the top limit
     */
    public void setBorder(double leftLimit, double rightLimit, double lowLimit,
                          double topLimit) {
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
        this.lowLimit = lowLimit;
        this.topLimit = topLimit;
    }

    /**
     * update the new center according to the place of the collision point on
     * rectangle (according to the line of the rectangle).
     * @param colliInfo the Collision Info
     */
    public void newCenter(CollisionInfo colliInfo) {
        double pointX = colliInfo.collisionPoint().getX();
        double pointY = colliInfo.collisionPoint().getY();
        Rectangle rec = colliInfo.collisionObject().getCollisionRectangle();
        Line l1 = new Line(rec.getUpperLeft(), rec.getLeftDown());
        Line l2 = new Line(rec.getRightUp(), rec.getLeftDown());
        Line l3 = new Line(rec.getRightUp(), rec.getRightDown());
        Line l4 = new Line(rec.getUpperLeft(), rec.getRightDown());
        if (l1.isInRange(colliInfo.collisionPoint())) {
            this.center = new Point(pointX - this.r, pointY);
        }
        if (l2.isInRange(colliInfo.collisionPoint())) {
            this.center = new Point(pointX, pointY + this.r);
        }
        if (l3.isInRange(colliInfo.collisionPoint())) {
            this.center = new Point(pointX + this.r, pointY);
        }
        if (l4.isInRange(colliInfo.collisionPoint())) {
            this.center = new Point(pointX, pointY - this.r);
        }
    }

    /**
     * Move the ball one step.
     * checks if the new location collide with an object and if so change his
     * velocity.
     */
    public void moveOneStep() {
        //check the velocity
        if (this.velocity == null) {
            this.velocity = new Velocity(0, 0);
        }
    Point newP = this.velocity.applyToPoint(this.center);
    Line trajectory = new Line(this.center, newP);
    CollisionInfo colliInfo = this.gameEnvironment
                              .getClosestCollision(trajectory);
        //no collision so the ball stay the same
        if (colliInfo.collisionPoint() == null
            || colliInfo.collisionObject() == null) {
        this.center = newP;
        } else {
            newCenter(colliInfo);
        this.velocity = colliInfo.collisionObject()
                        .hit(this, colliInfo.collisionPoint(),
                             this.velocity);

    }
}
    /**
     * Remove the ball from the game.
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}

