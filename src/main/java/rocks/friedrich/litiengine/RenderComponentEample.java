package rocks.friedrich.litiengine;

import java.awt.Color;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.RenderComponent;
import de.gurkenlabs.litiengine.gui.screens.Resolution;

public class RenderComponentEample
{
    public static void main(String[] args)
    {
        Game.init();
        Game.window().setResolution(Resolution.Ratio4x3.RES_640x480);
        RenderComponent component = Game.window().getRenderComponent();
        component.setBackground(Color.BLUE);
        component.onRendered(g -> {
            g.setColor(Color.RED);
            g.drawRect(50, 50, 50, 50);
        });
        Game.start();
    }
}
