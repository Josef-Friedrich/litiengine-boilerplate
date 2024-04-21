package rocks.friedrich.litiengine;

import java.awt.event.KeyEvent;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.Resolution;
import de.gurkenlabs.litiengine.input.Input;

public class WindowExample
{
    public static void main(String[] args)
    {
        Game.init(args);
        Game.window().setResolution(Resolution.Ratio4x3.RES_1024x768);
        Input.keyboard().onKeyTyped(KeyEvent.VK_1, e -> Game.window()
                .setResolution(Resolution.Ratio4x3.RES_640x480));
        Input.keyboard().onKeyTyped(KeyEvent.VK_2, e -> Game.window()
                .setResolution(Resolution.Ratio4x3.RES_1024x768));
        Game.start();
    }
}
