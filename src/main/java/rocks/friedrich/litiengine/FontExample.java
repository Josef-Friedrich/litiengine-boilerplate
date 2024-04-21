package rocks.friedrich.litiengine;

import java.awt.Color;
import java.awt.Graphics2D;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.resources.Resources;

public class FontExample extends Screen
{
    public FontExample()
    {
        super("font");
    }

    public void render(Graphics2D g)
    {
        super.render(g);
        g.setFont(Resources.fonts().get("fonts/Jersey10-Regular.ttf", 32f));
        g.setColor(Color.GREEN);
        Game.graphics().renderText(g, "Hello, LITIengine!", 0, 100);
        g.setColor(Color.BLUE);
        Game.graphics().renderText(g, "Font Test", 0, 0);
    }

    public static void main(String[] args)
    {
        Game.init();
        Game.screens().add(new FontExample());
        Game.start();
    }
}
