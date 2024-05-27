# litiengine-boilerplate

Litiengine verwendet ab der Version 0.6.0 Java 21. Auf Ubuntu kann
Java 21 folgendermaßen installiert und als Standard festgelegt werden.

```
sudo apt install openjdk-21-jdk
sudo update-alternatives --config java
```

## gradle

./gradlew build -Dorg.gradle.java.home=/usr/lib/jvm/java-21-openjdk-amd64

## vscode

```json
{
  "java.configuration.runtimes": [
    {
      "name": "JavaSE-21",
      "path": "/usr/lib/jvm/java-21-openjdk-amd64",
      "default": true
    }
  ],
  "java.jdt.ls.java.home": "/usr/lib/jvm/java-21-openjdk-amd64",
  "java.gradle.buildServer.enabled": "off"
}
```


# Text setzen

Schriftdatei in folgendenden Ordner kopieren: `./src/main/resources/fonts/Jersey10-Regular.ttf`

```java
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
```

# Screens

https://litiengine.com/docs/game-api/screens/

<!-- Screens are the containers that allow you to organize the visible contents of
your game. They render the game’s Environment and are considered the parent of
all GUI components you want to display in a particular state of your game. The
screen itself inherits from GuiComponent and thereby provides support to define
an Appearance and listen to all kinds of Input events (e.g. onMouseMoved(…)).
Everything that should be visible to the player needs to be rendered to the
currently active screen. -->

[Screens](https://litiengine.com/api/de/gurkenlabs/litiengine/gui/screens/Screen/)
sind die Container, mit denen Sie die sichtbaren Inhalte Ihres Spiels
organisieren können. Sie rendern die Spielumgebung und gelten als übergeordnete
Elemente aller GUI-Komponenten, die Sie in einem bestimmten Zustand Ihres
Spiels anzeigen möchten. Ein Screen selbst erbt von
[GuiComponent](https://litiengine.com/api/de/gurkenlabs/litiengine/gui/GuiComponent/)
und bietet dadurch Unterstützung beim Definieren einer
[Appearance](https://litiengine.com/api/de/gurkenlabs/litiengine/gui/Appearance/)
und beim Abhören aller Arten von Eingabeereignissen (z. B. onMouseMoved(…)).
Alles, was für den Spieler sichtbar sein soll, muss auf dem aktuell aktiven
Screen gerendert werden.

<!-- Screens are identified and addressed by a unique name. The ScreenManager
holds instances of all available screen and handles whenever a different
Screen should be shown to the player. It provides the currently active Screen
for the Game’s RenderComponent which calls the Screen.render(Graphics2D) method
on every tick of the RenderLoop. Overwriting this method provides the ability
to define a customized render pipeline that suits the need of a particular
Screen implementation. With the GameScreen, the LITIENGINE provides a simple
default Screen implementation that renders the current Environment and all its
GuiComponents. -->

Bildschirme werden durch einen eindeutigen Namen identifiziert und addressiert.
Der [ScreenManager](https://litiengine.com/api/de/gurkenlabs/litiengine/gui/screens/ScreenManager/)
enthält Instanzen aller verfügbaren `Screens` und verarbeitet,
wann immer dem Player ein anderer `Screen` angezeigt werden soll.
Es stellt den aktuell aktiven Bildschirm für die RenderComponent des Spiels bereit,
die bei jedem Tick des RenderLoop die `Screen.render(Graphics2D)`-Methode aufruft.
Das Überschreiben dieser Methode bietet die Möglichkeit, eine benutzerdefinierte
Renderpipeline zu definieren, die den Anforderungen einer bestimmten
Screen-Implementierung entspricht. Mit dem
[GameScreen](https://litiengine.com/api/de/gurkenlabs/litiengine/gui/screens/GameScreen/) stellt die LITIENGINE eine
einfache Standard-Screen-Implementierung bereit, die die aktuelle Umgebung und
alle ihre GuiComponents rendert.


Examples for screens include: Menu Screen, Credits Screen, Game Screen, Inventory Screen

Example usages:

```java
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
```

# Tastatur-Eingabe

```java
import java.awt.event.KeyEvent;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.input.Input;

public class KeyboardInput {

  public static void main(String[] args) {
    Game.init();

    Input.keyboard().onKeyPressed(KeyEvent.VK_ESCAPE, e -> System.exit(0));

    Input.keyboard().onKeyPressed(KeyEvent.VK_1, e -> System.out.println("pressed"));
    Input.keyboard().onKeyTyped(KeyEvent.VK_2, e -> System.out.println("typed"));
    Input.keyboard().onKeyReleased(KeyEvent.VK_3, e -> System.out.println("released"));
    Game.start();
  }
}
```

# Mouse-Eingabe

```java
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
```
