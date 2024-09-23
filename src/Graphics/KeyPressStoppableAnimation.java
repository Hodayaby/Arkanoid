// 322209289 Hodaya Ben Yashar
package Graphics;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 * @author Hodaya Ben Yashar
 */
public class KeyPressStoppableAnimation implements Animation {
   private KeyboardSensor sensor;
   private  String key;
   private Animation animation;
    private boolean isAlreadyPressed;
    private boolean stop;
    /**
     * Constructs a new KeyPressStoppableAnimation.
     * @param sensor    the keyboard sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key,
                                      Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
        this.stop = false;
    }

    /**
     * Performs the logic for one frame of the animation.
     * @param d the DrawSurface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.sensor.isPressed(this.key)
                && !this.isAlreadyPressed) {
            this.stop = true;
        }
        if (!this.sensor.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }
    }

    /**
     * Checks if the animation should stop.
     * @return false because the KeyPressStoppableAnimation will take care about
     * when to stop.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
