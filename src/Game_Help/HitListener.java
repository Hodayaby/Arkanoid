
// 322209289 Hodaya Ben Yashar
package Game_Help;

import Objects.Ball;
import Objects.Block;

/**
 * @author Hodaya Ben Yashar
 * The interface HitListener.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit the block that is being hit.
     * @param hitter the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
