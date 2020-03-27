package games.snake;

import core.model.Direction;
import core.model.MovableGameObjectImpl;
import core.model.Position;
import core.model.controls.Controls;

import java.awt.*;

public class Snake extends MovableGameObjectImpl {

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
    }

}
