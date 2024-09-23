// 322209289 Hodaya Ben Yashar
package Game;
import Game_Help.Counter;
import Game_Help.SpriteCollection;
import Graphics.Animation;
import Graphics.AnimationRunner;
import Graphics.CountdownAnimation;
import Graphics.KeyPressStoppableAnimation;
import Graphics.PauseScreen;
import Graphics.ScoreIndicator;
import Objects.Ball;
import Objects.Block;
import Objects.Paddle;
import Objects.Point;
import Objects.Rectangle;
import Game_Help.Collidable;
import Levels.LevelInformation;
import Game_Help.Sprite;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;


import java.awt.Color;

/**
 * The type Game level.
 *
 * @author Hodaya Ben Yashar.
 */
public class GameLevel implements Animation {
    private static final int RADIUS = 4;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BORDER_SIZE = 10;
    private static final int BORDER_UP_SIZE = 30;
    private static final int HEIGHT_PADDLE = 20;
    private static final int BALL_1_CENTER_X = 400;
    private static final int BALL_1_CENTER_Y = 400;
    private static final int POINTS_REMOVE_ALL_BLOCKS = 100;
    private static final int COUNTDOWN = 3;
    private static final int DURATION_COUNTDOWN = 2;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter score;
    private BlockRemover blockRemover;
    private ScoreTrackingListener scoreTrackingListener;
    private BallRemover ballRemover;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInfo;

    /**
     * constructor for a new game level.
     *
     * @param levelInfo the level information.
     * @param keyboard  the keyboard sensor.
     * @param runner    the animation runner.
     * @param gui       the GUI.
     * @param score     the counter score.
     */
    public GameLevel(LevelInformation levelInfo,
                     KeyboardSensor keyboard, AnimationRunner runner, GUI gui,
                     Counter score) {
        this.levelInfo = levelInfo;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.gui = gui;
        this.blockCounter = new Counter();
        this.ballCounter = new Counter();
        this.score = score;
        this.scoreTrackingListener = new ScoreTrackingListener(this.score);
        this.blockRemover = new BlockRemover(this, blockCounter);
        this.ballRemover = new BallRemover(this, ballCounter);
        this.runner = runner;
        this.keyboard = keyboard;
        this.running = true;

    }

    /**
     * Add collidable to the list of collidable.
     *
     * @param c the collidable that we are adding.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Remove collidable from the list of collidable.
     *
     * @param c the collidable that we are adding.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Gets the ball counter.
     * @return the ball counter
     */
    public Counter getBallCounter() {
        return this.ballCounter;
    }

    /**
     * Gets the score.
     * @return the score
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * Gets the animation runner.
     * @return the runner
     */
    public AnimationRunner getRunner() {
        return this.runner;
    }

    /**
     * Add to the sprite list.
     *
     * @param s the sprite we are adding.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Remove sprite from the sprite list.
     *
     * @param s the sprite we are adding.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Initialize the game.
     * Initialize a new game: creating the Blocks and Ball and Paddle and the
     * borders of the screen.
     * and add the sprites.
     */
    public void initialize() {
    this.createBorders();
    this.createBlocks();
    this.createPaddle();
    this.createBalls();
    this.addSprite(new ScoreIndicator(this.score));
    this.addSprite(levelInfo.getNameIndicator());
   this.addSprite(levelInfo.getBackground());
    }

    /**
     * Create borders.
     * and add them to the game environment.
     */
    public void createBorders() {
  int size = BORDER_SIZE;
  Color colorBorder = Color.GRAY;
  Block up = new Block(new Rectangle(new Point(0, 0), WIDTH,
                                     BORDER_UP_SIZE),
                     colorBorder);
  Block down = new Block(new Rectangle(new Point(BORDER_SIZE + 1,
                                                  HEIGHT - size),
                         WIDTH - 2 * size - 1, BORDER_SIZE), Color.BLACK);
  Block left = new Block(new Rectangle(new Point(0, 0), size, HEIGHT),
                                     colorBorder);
  Block right = new Block(new Rectangle(new Point(WIDTH - size, 0), size,
                                HEIGHT), colorBorder);
  left.addToGame(this);
  right.addToGame(this);
  up.addToGame(this);
  down.addToGame(this);
  //death region
  down.addHitListener(this.ballRemover);
  }

    /**
     * Create the paddle.
     * and add him to the game environment
     */
    public void createPaddle() {
        int move = this.levelInfo.paddleSpeed();
        double widthPaddle = this.levelInfo.paddleWidth();
        double heightPaddle = HEIGHT_PADDLE;
        Point p = new Point(WIDTH / 2 - widthPaddle / 2,
                HEIGHT - heightPaddle - BORDER_SIZE);
        Rectangle rec = new Rectangle(p, widthPaddle, heightPaddle);
        Paddle pad = new Paddle(rec, gui.getKeyboardSensor(), Color.BLUE, move);
        pad.addToGame(this);
    }

    /**
     * Create the balls.
     * and add them to the game environment/
     */
    public void createBalls() {
        for (int i = 0; i < this.levelInfo.numberOfBalls(); i++) {
            Ball ball = new Ball(BALL_1_CENTER_X, BALL_1_CENTER_Y,
                    RADIUS, Color.WHITE);
            ball.setVelocity(this.levelInfo.
                            initialBallVelocities().get(i).getDx(),
                    this.levelInfo.initialBallVelocities().get(i).getDy());
            ball.setGameEnvironment(environment);
            ball.setBorder(0, WIDTH, 0, HEIGHT);
            ball.addToGame(this);
        }
            this.ballCounter.increase(this.levelInfo.numberOfBalls());
    }

    /**
     * Create blocks.
     * and add them to the game environment
     */
    public void createBlocks() {
        for (int i = 0; i < this.levelInfo.numberOfBlocksToRemove(); i++) {
            Block block = this.levelInfo.blocks().get(i);
          this.blockCounter.increase(1);
          block.addToGame(this);
          block.addHitListener(this.blockRemover);
          block.addHitListener(this.scoreTrackingListener);
        }
   }

    /**
     * Performs the logic for one frame of the animation.
     * @param d the DrawSurface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, WIDTH, HEIGHT);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(
                    this.keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen(this.keyboard)));
        }
        // No more blocks so stop running
        if (this.blockCounter.getValue() == 0) {
            this.score.increase(POINTS_REMOVE_ALL_BLOCKS);
            this.running = false;
        }
        if (this.ballCounter.getValue() == 0) {
            this.running = false;
        }
    }

    /**
     * Checks if the animation should stop.
     *
     * @return true if the animation should stop, false otherwise.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Run the game
     * start the animation loop.
     */
    public void run() {
        this.initialize();
        CountdownAnimation countdown = new CountdownAnimation(
                                   DURATION_COUNTDOWN, COUNTDOWN, this.sprites);
        this.runner.run(countdown);
        this.running = true;
        this.runner.run(this);
    }
}