
package it.zelda.model;

import java.util.List;

public class GameMap {

    private final List<Obstacle> obstacles;

    public GameMap() {
        obstacles = List.of(
            new Obstacle(300, 200, 80, 80),
            new Obstacle(450, 200, 80, 80)
        );
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }
}
