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
 * The type Level 3.
 * @author Hodaya Ben Yashar.
 */
public class Level3 implements LevelInformation {
    private static final int NUM_OF_BLOCKS = 40;
    private static final int NUM_OF_BALLS = 2;
    private static final int BALL_VEL_DX = 2;
    private static final int BALL_VEL_DY = -2;
    private static final int PADDLE_WIDTH = 80;
    private static final int PADDLE_SPEED = 3;
    private static final int LEVEL_NUM = 3;
    private static final int WIDTH = 800;
    private static final int INITIAL_HEIGHT_BLOCK = 100;
    private static final int WIDTH_BLOCK = 55;
    private static final int HEIGHT_BLOCK = 25;
    private static final int BORDER_SIZE = 10;
    private static final int BLOCKS_IN_ROW = 10;
    private static final int BLOCKS_IN_COLUMN = 5;

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
     * @return the velocity list.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            velocities.add(new Velocity(BALL_VEL_DX + i, BALL_VEL_DY));
        }
        return velocities;
    }

    /**
     * The paddle speed.
     *
     * @return the paddle speed.
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * Paddle width int.
     *
     * @return the int
     */
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    /**
     * the level name string.
     *
     * @return the level name.
     */
    @Override
    public String levelName() {
        return "Green 3";
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
     * The blocks list.
     * @return the block list
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int widthBlock = WIDTH_BLOCK;
        int heightBlock = HEIGHT_BLOCK;
        Color[] colorsList = {Color.RED, Color.ORANGE, Color.YELLOW,
                Color.GREEN, Color.CYAN, Color.BLUE};
        for (int i = 0; i < BLOCKS_IN_COLUMN; i++) {
            for (int j = 0; j < BLOCKS_IN_ROW - i; j++) {
                double xBlock = WIDTH - BORDER_SIZE - widthBlock
                                - (j * widthBlock);
                double yBlock = INITIAL_HEIGHT_BLOCK + (i * heightBlock);
                Point p = new Point(xBlock, yBlock);
                Rectangle rec = new Rectangle(p, widthBlock, heightBlock);
                Block block = new Block(rec, colorsList[i]);
                blocks.add(block);
            }
        }
        return blocks;
    }
    /**
     * Number of blocks to remove int.
     * @return the number of blocks
     */
    @Override
    public int numberOfBlocksToRemove() {
        return NUM_OF_BLOCKS;
    }
}