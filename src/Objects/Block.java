// 322209289 Hodaya Ben Yashar
package Objects;
import Game.GameLevel;
import Game_Help.Collidable;
import Game_Help.HitListener;
import Game_Help.HitNotifier;
import Game_Help.Sprite;
import biuoop.DrawSurface;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Hodaya Ben Yashar.
 * The type Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    /**
     * constructor for a new block.
     *
     * @param rectangle the rectangle
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * constructor for a new block.
     *
     * @param rectangle the rectangle
     * @param color     the color
     */
    public Block(Rectangle rectangle, java.awt.Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }
    /**
     * Gets collision rectangle.
     *
     * @return the collision rectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    /**
     * Calculate the new velocity of the object after the collision.
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @param hitter The ball that caused the hit.
     * @return the velocity -is the new velocity expected after the hit (based
     * on the force the block inflicted on us).
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint,
                        Velocity currentVelocity) {
        Velocity newV = currentVelocity;
        //same point
      if (collisionPoint.equals(this.rectangle.getUpperLeft())
          || collisionPoint.equals(this.rectangle.getLeftDown())
              || collisionPoint.equals(this.rectangle.getRightUp())
              || collisionPoint.equals(this.rectangle.getRightDown())) {
           newV = new Velocity(-currentVelocity.getDx(),
                               -currentVelocity.getDy());
          // Vertical hit
      } else if (collisionPoint.getX() == this.rectangle.getUpperLeft().getX()
            || collisionPoint.getX() == this.rectangle.getRightUp().getX()) {
            // Vertical hit
             newV = new Velocity(-currentVelocity.getDx(),
                                 currentVelocity.getDy());
            // Horizontal hit
        } else if (collisionPoint.getY() == this.rectangle.getUpperLeft().getY()
                || collisionPoint.getY() == this.rectangle.getLeftDown()
                   .getY()) {
             newV = new Velocity(currentVelocity.getDx(),
                                -currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return newV;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface the surface
     */
     @Override
    public void drawOn(DrawSurface surface) {
        //draw the frame of the block
         surface.setColor(java.awt.Color.BLACK);
         surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                 (int) this.rectangle.getUpperLeft().getY(),
                 (int) this.rectangle.getWidth(),
                 (int) this.rectangle.getHeight());
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
    }
    /**
     * Notify the block that time has passed.
     */
    @Override
    public void timePassed() {
    }
    /**
     * Add the block to the game ( to the sprite and the collidable lists).
     */
    @Override
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl the hit listener
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl the hit listener
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
    /**
     * Notifies all listeners that a hit event has occurred.
     * and doing this by calls the 'hitEvent' method on each listener.
     * @param hitter The ball that caused the hit.
     */
    private void  notifyHit(Ball hitter) {
        // Make a copy of the hitListeners.
        List<HitListener> listeners = new ArrayList
                <>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    /**
     * Remove the block from the game.
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
}
