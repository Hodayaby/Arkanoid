// 322209289 Hodaya Ben Yashar
package Game_Help;
import Objects.Ball;
import Objects.Point;
import Objects.Rectangle;
import Objects.Velocity;
import biuoop.DrawSurface;

/**
 * @author Hodaya Ben Yashar
 * The interface Collidable.
 */
public interface Collidable {
    /**
     * Gets collision rectangle.
     *
     * @return the collision rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Hit velocity.
     * Notify the object that we collided with it at collisionPoint with a given
     * velocity.
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @param hitter The ball that caused the hit.
     * @return the velocity -is the new velocity expected after the hit (based
     * on the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * Draw on.
     *
     * @param d the draw surface
     */
   void drawOn(DrawSurface d);
}
