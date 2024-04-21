package rocks.friedrich.litiengine;

import java.awt.Color;
import java.awt.event.KeyEvent;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.Resolution;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.Input;

class RedScreen extends Screen
{
    public RedScreen()
    {
        super("red");
    }

    @Override
    public void prepare()
    {
        super.prepare();
        Game.window().getRenderComponent()
                .setBackground(Color.decode("#ff0000"));
    }
}

class BlueScreen extends Screen
{
    public BlueScreen()
    {
        super("blue");
    }

    @Override
    public void prepare()
    {
        super.prepare();
        Game.window().getRenderComponent()
                .setBackground(Color.decode("#0000ff"));
    }
}

public class ScreenExample
{
    public static void main(String[] args)
    {
        Game.init(args);
        Game.window().setResolution(Resolution.Ratio4x3.RES_1024x768);
        Game.screens().add(new RedScreen());
        Game.screens().add(new BlueScreen());
        Input.keyboard().onKeyTyped(KeyEvent.VK_1,
                e -> Game.screens().display("red"));
        Input.keyboard().onKeyTyped(KeyEvent.VK_2,
                e -> Game.screens().display("blue"));
        Game.start();
    }
}
