// 322209289 Hodaya Ben Yashar
package Graphics;
import Game_Help.SpriteCollection;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type Countdown animation.
 *
 * @author Hodaya Ben Yashar
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean firstRun;
    private long startTime;
    private boolean shouldStop;

    /**
     * constructor a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom,
                              SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.firstRun = true;
        this.startTime = 0;
        this.shouldStop = false;

    }

    /**
     * Sets the background.
     * @param d     the drawSurface
     * @param color the color of the background
     */
    public void setBackground(DrawSurface d, Color color) {
        d.setColor(color);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
    }
    /**
     * Performs the logic for one frame of the animation.
     *
     * @param d the DrawSurface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.firstRun) {
            this.startTime = System.currentTimeMillis();
            this.firstRun = false;
        }
        this.setBackground(d, Color.black);
       this.gameScreen.drawAllOn(d);
        d.setColor(Color.BLUE);
        long passTime = System.currentTimeMillis() - this.startTime;
        double secondsPassed = passTime / 1000.0;
        int currentCount = this.countFrom - (int) (secondsPassed
                           / (this.numOfSeconds / this.countFrom));
        d.drawText(d.getWidth() / 2, d.getHeight() / 2,
                  String.valueOf(currentCount), 60);
        // Check if the countdown has finished
        if (secondsPassed >= this.numOfSeconds) {
            this.shouldStop = true;
        }
    }
    /**
     * Checks if the animation should stop.
     * @return true if the animation should stop, false otherwise.
     */
@Override
    public boolean shouldStop() {
        return this.shouldStop;
    }
}
