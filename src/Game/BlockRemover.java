// 322209289 Hodaya Ben Yashar
package Game;

import Game_Help.Counter;
import Objects.Ball;
import Objects.Block;
import Game_Help.HitListener;

/**
 * @author Hodaya Ben Yashar.
 * The type Block remover.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     * @param game          the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }
    /**
     * This method removes the beingHit block from the game.
     * also it removes listener from the block
     * @param beingHit the block that is being hit.
     * @param hitter the Ball that's doing the hitting.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
            beingHit.removeHitListener(this);
            beingHit.removeFromGame(this.game);
            this.remainingBlocks.decrease(1);
    }
}