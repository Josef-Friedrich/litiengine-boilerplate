# litiengine-boilerplate

Litiengine verwendet ab der Version 0.6.0 Java 21. Auf Ubuntu kann
Java 21 folgendermaßen installiert und als Standard festgelegt werden.

```
sudo apt install openjdk-21-jdk
sudo update-alternatives --config java
```

# Text setzen

Schriftdatei in folgendenden Ordner kopieren: `src/main/resources/fonts/Jersey10-Regular.ttf`

```java
package rocks.friedrich.litiengine;

import java.awt.Color;
import java.awt.Graphics2D;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.resources.Resources;

public class FontScreen extends Screen {
    public FontScreen() {
        super("font");
    }

    public void render(Graphics2D g) {
        super.render(g);
        g.setFont(Resources.fonts().get("fonts/Jersey10-Regular.ttf", 32f));
        g.setColor(Color.GREEN);
        Game.graphics().renderText(g, "Hello, LITIengine!", 0, 100);
        g.setColor(Color.BLUE);
        Game.graphics().renderText(g, "Font Test", 0, 0);
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
// a custom screen implementation that renders "Test text" on the screen
public class TestScreen extends GameScreen {
  public TestScreen() {
    super("TEST");
  }
  @Override
  public void render(final Graphics2D g) {
    super.render(g);
    TextRenderer.render(g, "Test text", 100, 100);
  }
}
```

```java
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.Resolution;

public class Program {

  public static void main(String[] args) {
    // add some custom screens to the ScreenManager
    Game.screens().add(new MenuScreen());
    Game.screens().add(new IngameScreen());
    Game.screens().add(new EndOfLevelScreen());

    // display the screen with the name "MENU"
    Game.screens().display("MENU");

    // print the name of the currently active screen
    System.out.println("Currently active screen: " + Game.screens().current().getName());

    Game.start();
  }
}
```
