// 322209289 Hodaya Ben Yashar
package Graphics;
import Game.GameLevel;
import Objects.Point;
import Objects.Rectangle;
import Game_Help.Sprite;
import biuoop.DrawSurface;
/**
 * @author Hodaya Ben Yashar
 * The type NameLevIndicator.
 */
public class NameLevIndicator implements Sprite {
    private static final int POINT_X = 400;
    private static final int POINT_Y = 0;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 20;
    private static final int FONT_SIZE = 15;
    private String levName;
    private Rectangle rec;
    /**
     * Constructs a new NameLevIndicator.
     * @param levName the level name.
     */
    public NameLevIndicator(String levName) {
        this.levName = levName;
        this.rec = new Rectangle(new Point(POINT_X, POINT_Y), WIDTH, HEIGHT);
    }
    /**
     * Add the nameLev Indicator to the  game.
     * @param g the game
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Draw the sprite to the screen.
     * @param d the draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(java.awt.Color.BLACK);
        d.drawRectangle((int) this.rec.getUpperLeft().getX(),
                (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(),
                (int) this.rec.getHeight());
        d.setColor(java.awt.Color.LIGHT_GRAY);
        d.fillRectangle((int) this.rec.getUpperLeft().getX(),
                (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(),
                (int) this.rec.getHeight());
        d.setColor(java.awt.Color.BLACK);
        d.drawText((int) (this.rec.getUpperLeft().getX()
                        + this.rec.getWidth() / 4),
                (int) (this.rec.getUpperLeft().getY()
                        + this.rec.getHeight() / 2 + 5),
                "Level Name: "
                        + this.levName, FONT_SIZE);
    }

    /**
     * Notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }
}

