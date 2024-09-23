// 322209289 Hodaya Ben Yashar
package Game_Help;

import Objects.Point;

/**
 * @author Hodaya Ben Yashar
 * The type Collision info.
 */
public class CollisionInfo {

    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * constructor for a new CollisionInfo.
     *
     * @param collisionPoint  the collision point
     * @param collisionObject the collision object
     */
//Constructs
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * return Collision point.
     *
     * @return the point at which the collision occurs
     */
    public Point collisionPoint() {
       return this.collisionPoint;
    }

    /**
     * returning the Collision object .
     *
     * @return the collidable object involved in the collision
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
