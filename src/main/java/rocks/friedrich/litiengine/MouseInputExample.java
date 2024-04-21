package rocks.friedrich.litiengine;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.input.Input;

public class MouseInputExample
{
    public static void main(String[] args)
    {
        Game.init();
        Input.mouse().onClicked(e -> {
            System.out.println(
                    "Mouse clicked at x: " + e.getX() + ", y: " + e.getY());
        });
        Game.start();
    }
}
