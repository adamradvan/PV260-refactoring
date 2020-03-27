package games.snake;

import core.Engine;
import core.config.PlayersConfiguration;
import core.model.GameObject;
import core.model.PlayableGameObject;

import java.util.List;


public class SnakeEngine extends Engine {
    //todo make snakes
    Snake snake = PlayersConfiguration.PLAYER_1.toSnakeObject();

    @Override
    public List<GameObject> getGameObjects() {
        return List.of(snake);
    }

    @Override
    public List<PlayableGameObject> getPlayableGameObjects() {
        return List.of(snake);
    }

    @Override
    public void checkCollisions() {
        checkSnakeCollision();
    }

    private void checkSnakeCollision() {
        // todo
    }

}
