package games.snake;

import core.config.GameConfiguration;
import core.model.GameObject;

import java.awt.*;

public class Food implements GameObject {
    private static final GameConfiguration.GameObjectType GAME_OBJECT_TYPE = GameConfiguration.GameObjectType.FOOD;

    @Override
    public GameConfiguration.GameObjectType getType() {
        return GAME_OBJECT_TYPE;
    }

    @Override
    public void drawObject(Graphics2D graphics) {
        // todo
    }

    @Override
    public void makeMove() {
        // todo
    }
}
