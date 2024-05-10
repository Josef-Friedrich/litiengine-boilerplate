package rocks.friedrich.litiengine;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.sound.Sound;

public class AudioExample
{
    public static void main(String[] args)
    {
        Sound mySound = Resources.sounds().get("audio-logo.mp3");
        Game.audio().playMusic(mySound);
    }
}
