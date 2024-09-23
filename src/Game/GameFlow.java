// 322209289 Hodaya Ben Yashar
package Game;
import Graphics.AnimationRunner;
import Graphics.EndScreen;
import Graphics.KeyPressStoppableAnimation;
import Game_Help.Counter;
import biuoop.KeyboardSensor;
import Levels.LevelInformation;
import java.util.List;

/**
 * @author Hodaya Ben Yashar.
 * The type Game flow.
 */
public class GameFlow {
private AnimationRunner ar;
private KeyboardSensor ks;

    /**
     * constructor a new Game flow.
     * @param ar the animation runner.
     * @param ks the keyboard sensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
       this.ks = ks;
    }
    /**
     * Run the levels of the game.
     * @param levels the levels of the game.
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter score = new Counter();
        for (int i = 0; i < levels.size(); i++) {
            GameLevel level = new GameLevel(levels.get(i), this.ks, this.ar,
                                            this.ar.getGui(), score);
            while (!level.shouldStop()) {
                level.run();
            }
            //the player lost
            if (level.getBallCounter().getValue() == 0) {
                EndScreen endScreen = new EndScreen(this.ar.getGui().
                                      getKeyboardSensor(), level.getScore(),
                                      false);
                level.getRunner().run(new KeyPressStoppableAnimation(
                                      this.ar.getGui().getKeyboardSensor(),
                                      KeyboardSensor.SPACE_KEY, endScreen));
                break;
            }
            //the player won
            if (i == 2) {
                EndScreen endScreen = new EndScreen(this.ar.getGui().
                                      getKeyboardSensor(), level.getScore(),
                                      true);
                level.getRunner().run(new KeyPressStoppableAnimation(
                                      this.ar.getGui().getKeyboardSensor(),
                                      KeyboardSensor.SPACE_KEY, endScreen));
                break;
            }
        }
        this.ar.getGui().close();
    }
}
