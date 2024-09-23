// 322209289 Hodaya Ben Yashar
package Game_Help;
import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;
/**
 * @author Hodaya Ben Yashar
 * The type Sprite collection.
 */
public class SpriteCollection {
    private List<Sprite> listSprites;

    /**
     * Constructor for a new Sprite collection.
     */
    public SpriteCollection() {
        this.listSprites = new ArrayList<Sprite>();
    }

    /**
     * Add sprite to the list.
     *
     * @param s the sprite.
     */
    public void addSprite(Sprite s) {
        this.listSprites.add(s);
    }

    /**
     * Notify all time passed.
     * Call timePassed() on all sprites.
     */

    public void notifyAllTimePassed() {
        for (int i = 0; i < this.listSprites.size(); i++) {
            this.listSprites.get(i).timePassed();
        }
    }

    /**
     * Draw all on.
     * Call drawOn(d) on all sprites.
     * @param d the draw surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.listSprites.size(); i++) {
            this.listSprites.get(i).drawOn(d);
        }
    }
    /**
     * Remove sprite from the list.
     *
     * @param s the sprite.
     */
    public void removeSprite(Sprite s) {
        this.listSprites.remove(s);
    }
}
