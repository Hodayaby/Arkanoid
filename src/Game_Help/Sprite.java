// 322209289 Hodaya Ben Yashar
package Game_Help;
import Game.GameLevel;
import biuoop.DrawSurface;

/**
 * @author Hodaya Ben Yashar
 * The interface Sprite.
 */
public interface Sprite {
    /**
     * Add to game.
     *
     * @param g the game
     */
    void addToGame(GameLevel g);

    /**
     * Draw the sprite to the screen.
     *
     * @param d the draw surface.
     */

    void drawOn(DrawSurface d);

    /**
     * Notify the sprite that time has passed.
     */
    void timePassed();
}
