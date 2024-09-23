// 322209289 Hodaya Ben Yashar
package Game;
import Game_Help.Counter;
import Objects.Ball;
import Objects.Block;
import Game_Help.HitListener;

/**
 * The type BallRemover.
 *  @author Hodaya Ben Yashar.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     * @param game          the game
     * @param remainingBalls the removed blocks
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }
    /**
     * This method removes the ball from the game if it is hitting the death
     * region.
     * @param beingHit the block - the death region.
     * @param hitter the ball.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
       hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}