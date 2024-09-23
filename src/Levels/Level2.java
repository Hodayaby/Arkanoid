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
 * The type Level 2.
 * @author Hodaya Ben Yashar.
 */
public class Level2 implements LevelInformation {
    private static final int NUM_OF_BLOCKS = 15;
    private static final int LEVEL_NUM = 2;
    private static final int PADDLE_WIDTH = 500;
    private static final int PADDLE_SPEED = 5;
    private static final int VEL_SPEED = 2;
    private static final int VEL_ANGLE = -90;
    private static final int NUM_OF_BALLS = 10;
    private static final int WIDTH = 800;
    private static final int INITIAL_HEIGHT_BLOCK = 100;
    private static final int WIDTH_BLOCK = 52;
    private static final int HEIGHT_BLOCK = 25;
    private static final int BORDER_SIZE = 10;
    private static final int BLOCKS_IN_ROW = 15;
    /**
     * Number of balls int.
     *
     * @return the number of balls
     */
    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }

    /**
     * Initial velocity of each ball.
     *
     * @return the list
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        double angle = VEL_ANGLE;
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity vel = Velocity.fromAngleAndSpeed(angle, VEL_SPEED);
            velocities.add(vel);
            angle += 180.0 / (NUM_OF_BALLS - 1);
        }
        return velocities;
    }

    /**
     * The paddle speed.
     * @return paddle speed.
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * The paddle width.
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
        return "Wide easy";
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
        int widthBlock = WIDTH_BLOCK;
        Color[] colorsList = {Color.RED, Color.RED, Color.ORANGE, Color.ORANGE,
                 Color.YELLOW, Color.YELLOW, Color.GREEN, Color.GREEN,
                 Color.GREEN, Color.CYAN, Color.CYAN, Color.BLUE, Color.BLUE,
                Color.MAGENTA, Color.MAGENTA};
            for (int j = 0; j < BLOCKS_IN_ROW; j++) {
                double xBlock = WIDTH - BORDER_SIZE - widthBlock
                                - (j * widthBlock);
                Point p = new Point(xBlock, INITIAL_HEIGHT_BLOCK);
                Rectangle rec = new Rectangle(p, widthBlock, HEIGHT_BLOCK);
                Block block = new Block(rec, colorsList[j]);
                blocks.add(block);
            }
        return blocks;
    }
    /**
     * Number of blocks to remove int.
     * @return the int
     */
    @Override
    public int numberOfBlocksToRemove() {
        return NUM_OF_BLOCKS;
    }
}

