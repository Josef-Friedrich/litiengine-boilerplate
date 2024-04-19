package rocks.friedrich.litiengine;

import de.gurkenlabs.litiengine.Game;

import de.gurkenlabs.litiengine.gui.screens.Screen;

import java.awt.Graphics2D;
import java.awt.Color;

public class GameScreen extends Screen {
    public GameScreen() {
        super("game");
    }

    @Override
    public void prepare() {
        super.prepare();
        Game.window().getRenderComponent().setBackground(Color.decode("#ff0000"));
    }

    public void render(Graphics2D g) {
        super.render(g);
    }
}
