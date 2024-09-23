// 322209289 Hodaya Ben Yashar
package Graphics;
//import Geometry.Point;
import Game.GameLevel;
//import Objects.Point;
import Objects.Rectangle;
import Game_Help.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type Background.
 * @author Hodaya Ben Yashar
 */
public class Background implements Sprite {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private int level;
    private Rectangle rec;

    /**
     * constructor a new Background.
     * @param level the level the backgrund belong.
     */
    public Background(int level) {
        this.level = level;
    }
    /**
     * Add to game.
     * @param g the game
     */
    //לחזורררררר
    @Override
    public void addToGame(GameLevel g) {
        this.addToGame(g);
    }

    /**
     * Draw the background to the screen.
     * @param d the draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLUE);
        if (level == 1) {
            int centerX = 415;
            int centerY = 215;
            int r = 30;
            for (int i = 1; i < 4; i++) {
                d.setColor(Color.BLUE);
                d.drawCircle(centerX, centerY, r + i * 20);
            }
            d.drawLine(415, 185, 415, 85);
            d.drawLine(415, 245, 415, 345);
            d.drawLine(455, 200, 550, 200);
            d.drawLine(385, 215, 285, 215);
        }
            if (level == 2) {
                d.setColor(Color.BLUE);
                }
                if (level == 3) {
                    d.setColor(Color.BLUE);
                }
            }

    /**
     * Notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }
}
