package games.snake;

import core.config.GameConfiguration;
import core.model.Direction;
import core.model.PlayableGameObjectImpl;
import core.model.Position;
import core.model.controls.Controls;

import java.awt.*;

public class Snake extends PlayableGameObjectImpl {
    private static final GameConfiguration.GameObjectType GAME_OBJECT_TYPE = GameConfiguration.GameObjectType.SNAKE;


    public Snake(Color color, Controls controls, Position initialPosition, Direction initialDirection) {
        super(color, controls, initialPosition, initialDirection);
    }

    @Override
    public void modifyPositionHistory() {
        getPositionHistory().add(nextPosition);
        if (getPositionHistory().size() > 5)
            getPositionHistory().remove(0);
    }

    @Override
    public GameConfiguration.GameObjectType getType() {
        return GAME_OBJECT_TYPE;
    }
}
