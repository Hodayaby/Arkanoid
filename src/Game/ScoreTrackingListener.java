// 322209289 Hodaya Ben Yashar
package Game;

import Game_Help.Counter;
import Objects.Ball;
import Objects.Block;
import Game_Help.HitListener;

/**
 * @author Hodaya Ben Yashar
 * The type Score tracking listener.
 */
public class ScoreTrackingListener implements HitListener {
    private static final int POINT_FOR_HIT_BLOCK = 5;
    private Counter currentScore;

    /**
     * Constructs a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * This method updates the score when a block is hit.
     *
     * @param beingHit the block being hit
     * @param hitter   the ball that hits the block
     */
@Override
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(POINT_FOR_HIT_BLOCK);
    }
}
