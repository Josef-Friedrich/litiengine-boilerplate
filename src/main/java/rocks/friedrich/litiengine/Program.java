package rocks.friedrich.litiengine;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.Resolution;

public class Program {

  public static void main(String[] args) {
    Game.info().setName("Example Game");
    Game.info().setSubTitle("tested by Josef Friedrich");
    Game.info().setVersion("v0.1.0");
    Game.info().setWebsite("https://github.com/Josef-Friedrich/litiengine-examples");
    Game.init(args);
    Game.window().setResolution(Resolution.Ratio4x3.RES_1024x768);

    Game.screens().add(new GameScreen());
    Game.screens().add(new FontScreen());
    Game.screens().display("font");
    Game.start();
  }
}
