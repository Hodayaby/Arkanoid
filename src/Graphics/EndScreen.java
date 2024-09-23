// 322209289 Hodaya Ben Yashar
package Graphics;
import Game_Help.Counter;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The class End screen.
 * @author Hodaya Ben Yashar
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private Counter currentScore;
    private Boolean wining;
    /**
     * Constructs a new End screen.
     * @param k the KeyboardSensor.
     * @param currentScore  the counter of score.
     * @param wining the key to know if wining or loosing.
     */
    public EndScreen(KeyboardSensor k, Counter currentScore, Boolean wining) {
        this.keyboard = k;
        this.currentScore = currentScore;
        this.wining = wining;
    }
    /**
     * Performs the logic for one frame of the animation.
     * @param d the DrawSurface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (wining) {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is "
                    + this.currentScore.getValue() + ".", 32);
        } else {
            d.drawText(10, d.getHeight() / 2, "Game Over."
                    + " Your score is "
                    + this.currentScore.getValue() + ".", 32);
        }
    }
    /**
     * Checks if the animation should stop.
     * @return false because the KeyPressStoppableAnimation will take care about
     * when to stop.
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}

