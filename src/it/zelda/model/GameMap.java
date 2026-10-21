
package it.zelda.model;

import java.awt.Rectangle;
import java.util.List;

public class GameMap {

    private final List<Rectangle> obstacles;

    public GameMap() {
        obstacles = List.of(
            new Rectangle(300, 200, 80, 80),
            new Rectangle(450, 200, 80, 80)
        );
    }

    public List<Rectangle> getObstacles() {
        return obstacles;
    }
}
