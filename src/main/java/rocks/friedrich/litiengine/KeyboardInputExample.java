package rocks.friedrich.litiengine;

import java.awt.event.KeyEvent;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.input.Input;

public class KeyboardInputExample
{
    public static void main(String[] args)
    {
        Game.init();
        Input.keyboard().onKeyPressed(KeyEvent.VK_ESCAPE, e -> System.exit(0));
        Input.keyboard().onKeyPressed(KeyEvent.VK_1,
                e -> System.out.println("pressed"));
        Input.keyboard().onKeyTyped(KeyEvent.VK_2,
                e -> System.out.println("typed"));
        Input.keyboard().onKeyReleased(KeyEvent.VK_3,
                e -> System.out.println("released"));
        Game.start();
    }
}
