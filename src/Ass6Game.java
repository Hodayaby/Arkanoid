// 322209289 Hodaya Ben Yashar
import Graphics.AnimationRunner;
import Game.GameFlow;
import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import Levels.LevelInformation;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Hodaya Ben Yashar
 * The class Ass6Game.
 */
public class Ass6Game {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        AnimationRunner runner = new AnimationRunner();
        GameFlow gameFlow = new GameFlow(runner, runner.getGui().getKeyboardSensor());
        List<LevelInformation> levels = new ArrayList<>();
        levels.add(new Level1());
        levels.add(new Level2());
        levels.add(new Level3());
        List<LevelInformation> newOrderLevel = new ArrayList<>();
        if (args.length == 0) {
            gameFlow.runLevels(levels);
        } else {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("1")) {
                    newOrderLevel.add(new Level1());
                } else if (args[i].equals("2")) {
                    newOrderLevel.add(new Level2());
                } else if (args[i].equals("3")) {
                    newOrderLevel.add(new Level3());
                } else {
                    continue;
                }
            }
            if (newOrderLevel.isEmpty()) {
                newOrderLevel = levels;
            }
        }
            gameFlow.runLevels(newOrderLevel);
        }
    }