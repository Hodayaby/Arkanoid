// 322209289 Hodaya Ben Yashar
package Levels;
import Objects.Block;
import Objects.Velocity;
import Objects.Rectangle;
import Objects.Point;
import Graphics.Background;
import Graphics.NameLevIndicator;
import Game_Help.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 1.
 * @author Hodaya Ben Yashar.
 */
public class Level1 implements LevelInformation {
    private static final int NUM_OF_BLOCKS = 1;
    private static final int BLOCK_HEIGHT = 30;
    private static final int BLOCK_WIDTH = 30;
    private static final int POINT_Y = 200;
    private static final int POINT_X = 400;
    private static final int PADDLE_WIDTH = 200;
    private static final int PADDLE_SPEED = 10;
    private static final int BALL_VEL_DX = 0;
    private static final int BALL_VEL_DY = 3;
    private static final int NUM_OF_BALLS = 1;
    private static final int LEVEL_NUM = 1;
    /**
     * Number of balls.
     * @return the number of balls
     */
    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }

    /**
     * Initial velocity of each ball.
     * @return the list
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            velocities.add(new Velocity(BALL_VEL_DX, BALL_VEL_DY));
        }
        return velocities;
    }

    /**
     * Paddle speed.
     * @return the paddle speed.
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * Paddle width.
     *
     * @return the paddle width.
     */
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    /**
     * Level name string.
     * @return the level name.
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * Gets the background.
     * @return the background
     */
    @Override
    public Sprite getBackground() {
        return new Background(LEVEL_NUM);
    }
    @Override
    public Sprite getNameIndicator() {
        return new NameLevIndicator(this.levelName());
    }
    /**
     * the blocks list.
     * @return the block list
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Point p = new Point(POINT_X, POINT_Y);
                Rectangle rec = new Rectangle(p, BLOCK_WIDTH, BLOCK_HEIGHT);
        blocks.add(new Block(rec, Color.RED));
        return blocks;
    }

    /**
     * Number of blocks to remove int.
     *
     * @return the int
     */
    @Override
    public int numberOfBlocksToRemove() {
        return NUM_OF_BLOCKS;
    }
}
