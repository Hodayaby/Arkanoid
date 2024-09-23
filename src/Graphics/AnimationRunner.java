// 322209289 Hodaya Ben Yashar
package Graphics;
import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * The type Animation runner.
 * @author Hodaya Ben Yashar.
 */
public class AnimationRunner {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int FRAMES_PER_SECOND = 60;
    private GUI gui;
    private int framesPerSecond;

    /**
     * Constructs a new AnimationRunner.
     */
    public AnimationRunner() {
        this.gui = new GUI("Game", WIDTH, HEIGHT);
        this.framesPerSecond = FRAMES_PER_SECOND;
    }

    /**
     * Gets the gui.
     * @return the gui
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * This method runs the specified animation.
     * @param animation the Animation to run
     */
    public void run(Animation animation) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
