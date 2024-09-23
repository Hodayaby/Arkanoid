// 322209289 Hodaya Ben Yashar
package Objects;
//import Game_Flow.Game;
import Game.GameLevel;
import Game_Help.Collidable;
import Game_Help.Sprite;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Hodaya Ben Yashar
 * The type Paddle.
 */
public class Paddle implements Sprite, Collidable {
    private static final int BORDER_SIZE = 10;
    private static final int WIDTH = 800;
    private static final double THRESHOLD = 0.00001;
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private java.awt.Color color;
    private int move;

    /**
     * Constructs a new Paddle.
     *
     * @param rectangle the rectangle
     * @param keyboard  the keyboard
     * @param color     the color
     * @param move      the move
     */
    public Paddle(Rectangle rectangle, biuoop.KeyboardSensor keyboard,
                  java.awt.Color color, int move) {
        this.rectangle = rectangle;
        this.keyboard = keyboard;
        this.color = color;
        this.move = move;
    }

    /**
     * Move the paddle left.
     */
    public void moveLeft() {
        double xNew = this.rectangle.getUpperLeft().getX() - move;
        double width = this.rectangle.getWidth();
        double height = this.rectangle.getHeight();
        int leftBorder = BORDER_SIZE;
        if (xNew < leftBorder) {
            xNew = leftBorder;
        }
        Point p = new Point(xNew, this.rectangle.getUpperLeft().getY());
        this.rectangle = new Rectangle(p, width, height);
    }

    /**
     * Move the paddle right.
     */
    public void moveRight() {
        double xNew = this.rectangle.getUpperLeft().getX() + move;
        double width = this.rectangle.getWidth();
        double height = this.rectangle.getHeight();
        int rightBorder = WIDTH - BORDER_SIZE - (int) rectangle.getWidth();
        //the paddle is moving outside the borders
        if (xNew > rightBorder) {
            xNew = rightBorder;
        }
        Point p = new Point(xNew, this.rectangle.getUpperLeft().getY());
        this.rectangle = new Rectangle(p, width, height);
    }
    /**
     * The time has passed so the paddle to moves according to the key.
     */
    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
    }
    /**
     * draw the paddle on the given DrawSurface.
     *
     * @param d the surface
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
    }

    /**
     * returning the paddle rectangle.
     * <p></p>
     * @return returns the rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    /**
     *  The function returning a new velocity of the object after it hit the
     *  paddle, according to the region.
     *  <p></p>
     * @param collisionPoint ,the point of the collision.
     * @param currentVelocity ,the current velocity of the object.
     * @param hitter The ball that caused the hit.
     * @return the new velocity according to the hit region.
     */
    public Velocity hit(Ball hitter, Point collisionPoint,
                        Velocity currentVelocity) {
        Line left = new Line(this.rectangle.getUpperLeft(),
                             this.rectangle.getLeftDown());
        Line up =  new Line(this.rectangle.getLeftDown(),
                            this.rectangle.getRightUp());
        Line right = new Line(this.rectangle.getRightUp(),
                              this.rectangle.getRightDown());
        Line bottom = new Line(this.rectangle.getRightDown(),
                               this.rectangle.getUpperLeft());
        double currDx = currentVelocity.getDx();
        double currDy = currentVelocity.getDy();
        if (up.isInRange(collisionPoint)) {
            int region = findRegion(up, collisionPoint);
            if (region == 3) {
                return new Velocity(currentVelocity.getDx(),
                                   -currentVelocity.getDy());
            }
            if (region == -1) {
                region = 5;
            }
           int angle = (270 + region * 30) % 360;
            double speed = Math.sqrt(currDx * currDx + currDy * currDy);
            return Velocity.fromAngleAndSpeed(angle, speed);
        }
        if (left.isInRange(collisionPoint)) {
            return new Velocity(-currDx, currDy);
        }
        if (right.isInRange(collisionPoint)) {
            return new Velocity(-currDx, currDy);
        }
        if (bottom.isInRange(collisionPoint)) {
            return new Velocity(currDx, -currDy);
        }
        return currentVelocity;


    }

    /**
     * Find the number of region.
     *
     * @param line      the line
     * @param collision the collision point
     * @return the number of the  region .
     */
    public int findRegion(Line line, Point collision) {
       double part = line.length() / 5;
       double realStart = Math.min(line.start().getX(), line.end().getX());
       for (int i = 1; i <= 5; i++) {
           if (collision.getX() <= realStart + part * i
                   || Math.abs(collision.getX() - realStart + part * i)
                               < THRESHOLD) {
               return i;
           }
           }
       return -1;
    }
    /**
     * Add this paddle to the game.
     *
     * @param g the game
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}