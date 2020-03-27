package games.snake;

import core.config.GameConfiguration;
import core.model.GameObjectImpl;
import core.model.Position;

import java.awt.*;

public class Food extends GameObjectImpl {
    private static final GameConfiguration.GameObjectType GAME_OBJECT_TYPE = GameConfiguration.GameObjectType.FOOD;

    public Food(Color color, Position position) {
        super(color, position);
    }

    @Override
    public GameConfiguration.GameObjectType getType() {
        return GAME_OBJECT_TYPE;
    }


}
