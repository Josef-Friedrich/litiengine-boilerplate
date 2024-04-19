package rocks.friedrich.litiengine;

import de.gurkenlabs.litiengine.Game;

public class Program {

  public static void main(String[] args) {
    Game.info().setName("Example Game");
    Game.info().setSubTitle("tested by Josef Friedrich");
    Game.info().setVersion("v0.1.0");
    Game.info().setWebsite("https://github.com/Josef-Friedrich/litiengine-examples");
    Game.init(args);
    Game.start();
  }
}
