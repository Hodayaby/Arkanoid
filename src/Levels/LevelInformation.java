// 322209289 Hodaya Ben Yashar
package Levels;
import Game_Help.Sprite;
import Objects.Block;
import Objects.Velocity;
import java.util.List;

/**
 * The interface Level information.
 *
 * @author Hodaya Ben Yashar The interface Level information.
 */
public interface LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the number of balls
     */
    int numberOfBalls();

    /**
     * Initial velocity of each ball.
     *
     * @return the list
     */
    List<Velocity> initialBallVelocities();

    /**
     * The paddle speed.
     *
     * @return the paddle speed
     */
    int paddleSpeed();

    /**
     * The paddle width.
     *
     * @return the paddle width.
     */
    int paddleWidth();

    /**
     * Level name string.
     *
     * @return the string
     */
    String levelName();

    /**
     * Gets the background.
     *
     * @return the background
     */
    Sprite getBackground();

    /**
     * The blocks list.
     *
     * @return the blocks list.
     */
    List<Block> blocks();

    /**
     * Number of blocks to remove .
     *
     * @return the number of blocks.
     */
    int numberOfBlocksToRemove();
    /**
     * Gets the name indicator of the level.
     *
     * @return the name indicator.
     */
    Sprite getNameIndicator();
}
