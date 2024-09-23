// 322209289 Hodaya Ben Yashar
package Game;
import Game_Help.CollisionInfo;
import Objects.Line;
import Objects.Point;
import Game_Help.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hodaya Ben Yashar.
 * The type Game environment.
 */
public class GameEnvironment {
    private List<Collidable> listCollide;

    /**
     * Constructor for a new Game environment.
     */
    public GameEnvironment() {
        this.listCollide = new ArrayList<Collidable>();
    }

    /**
     * constructor for a new Game environment.
     *
     * @param collidables the collidables list that already exist.
     */
//delete
    public GameEnvironment(ArrayList<Collidable> collidables) {
        this.listCollide = collidables;
}

    /**
     * add the given collidable to the environment.
     *
     * @param c the collidable.
     */
    public void addCollidable(Collidable c) {
        this.listCollide.add(c);
        }
    /**
     * Remove the given collidable from the environment.
     *
     * @param c the collidable.
     */
    public void removeCollidable(Collidable c) {
        this.listCollide.remove(c);
    }

    /**
     * Gets game environment.
     *
     * @return the game environment
     */
    public List<Collidable> getGameEnvironment() {
        return this.listCollide;
    }

    /**
     * Gets the closest collision.
     * we assume an object moving from line.start() to line.end().
     * and  If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory the trajectory
     * @return the closest collision if there is a collision, null otherwise.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //the first collision information
        Collidable object = listCollide.get(0);
        Point intersection = trajectory
                            .closestIntersectionToStartOfLine(listCollide.get(0)
                            .getCollisionRectangle());
        //list is empty
        if (object == null) {
            return new CollisionInfo(null, null);
        }
        //checking for the closest one
        for (int i = 1; i < listCollide.size(); i++) {
            //if there is no collision get the next one in the list
            if (intersection == null) {
                intersection = trajectory.
                closestIntersectionToStartOfLine(listCollide.get(i).
                getCollisionRectangle());
                object = listCollide.get(i);
            } else {
                if (trajectory.closestIntersectionToStartOfLine(listCollide
                        .get(i).getCollisionRectangle()) != null
                        && intersection.distance(trajectory.start())
                        > trajectory.
                        closestIntersectionToStartOfLine(listCollide.get(i).
                                getCollisionRectangle()).
                        distance(trajectory.start())) {
                    intersection = trajectory.
                            closestIntersectionToStartOfLine(listCollide.get(i)
                                    .getCollisionRectangle());
                    object = listCollide.get(i);
                }
            }
        }
        return new CollisionInfo(intersection, object);
    }

}
