// 322209289 Hodaya Ben Yashar
package Graphics;
import biuoop.DrawSurface;
/**
 * @author Hodaya Ben Yashar
 * The interface Animation.
 */
public interface Animation {
    /**
     * Performs the logic for one frame of the animation.
     * @param d the DrawSurface.
     */
    void doOneFrame(DrawSurface d);
    /**
     * Checks if the animation should stop.
     * @return true if the animation should stop, false otherwise.
     */
    boolean shouldStop();
}
