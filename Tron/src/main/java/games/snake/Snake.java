package games.snake;

import core.config.GameConfiguration;
import core.model.Direction;
import core.model.MovableGameObjectImpl;
import core.model.Position;
import core.model.controls.Controls;

import java.awt.*;
import java.util.stream.Collectors;

public class Snake extends MovableGameObjectImpl {
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

    public void feedSnake() {
        Position snakeTail = getPositionHistory().get(0);
        getPositionHistory().add(0, snakeTail);
        System.out.println("Snake is fed, his path:" + getPositionHistory().stream().map(Position::toString).collect(Collectors.joining(", ")));
    }

    @Override
    public GameConfiguration.GameObjectType getType() {
        return GAME_OBJECT_TYPE;
    }
}
