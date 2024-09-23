// 322209289 Hodaya Ben Yashar
package Graphics;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Pause screen.
 * @author Hodaya Ben Yashar
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;

    /**
     * Constructs a new Pause screen.
     * @param k the KeyboardSensor.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
    }
    /**
     * Performs the logic for one frame of the animation.
     * @param d the DrawSurface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to "
                + "continue", 32);
    }
    /**
     * Checks if the animation should stop.
     * @return true if the animation should stop, false otherwise.
     */
    @Override
    public boolean shouldStop() {
        return false; }
}
