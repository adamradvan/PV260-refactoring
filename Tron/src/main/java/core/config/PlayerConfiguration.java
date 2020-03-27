package core.config;

import core.model.Direction;
import core.model.Position;
import core.model.controls.Controls;
import games.snake.Snake;
import games.tron.Bike;

import java.awt.*;

public enum PlayerConfiguration {
    PLAYER_ARROWS(
            Color.GREEN,
            PlayerControls.ARROWS_CONTROLS,
            new Position(40, 40),
            Direction.RIGHT
    ),
    PLAYER_WASD(
            Color.RED,
            PlayerControls.WASD_CONTROLS,
            new Position(600, 440),
            Direction.LEFT
    ),
    PLAYER_MOUSE(
            Color.YELLOW,
            PlayerControls.MOUSE_CONTROLS,
            new Position(200, 600),
            Direction.DOWN
    );

    private Color color;
    private Controls controls;
    private Position startingPosition;
    private Direction startingDirection;

    PlayerConfiguration(Color color, Controls controls, Position startingPosition, Direction startingDirection) {
        this.color = color;
        this.controls = controls;
        this.startingPosition = startingPosition;
        this.startingDirection = startingDirection;
    }

    public Bike toBikeObject() {
        return new Bike(color, controls, startingPosition, startingDirection);
    }

    public Snake toSnakeObject() {
        return new Snake(color, controls, startingPosition, startingDirection);
    }
}
