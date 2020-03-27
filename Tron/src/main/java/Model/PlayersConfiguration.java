package Model;

import Core.controls.Controls;
import Core.Direction;
import Core.controls.KeyboardControls;
import Core.controls.MouseControls;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public enum PlayersConfiguration {
    PLAYER_1(
            Color.GREEN,
            PlayerControls.PLAYER_1_CONTROLS,
            new Position(40, 40),
            Direction.RIGHT
    ),
    PLAYER_2(
            Color.RED,
            PlayerControls.PLAYER_2_CONTROLS,
            new Position(600, 440),
            Direction.LEFT
    ),
    PLAYER_3(
            Color.YELLOW,
            PlayerControls.PLAYER_3_CONTROLS,
            new Position(200, 600),
            Direction.DOWN
    );

    private Color color;
    private Controls controls;
    private Position startingPosition;
    private Direction startingDirection;

    PlayersConfiguration(Color color, Controls controls, Position startingPosition, Direction startingDirection) {
        this.color = color;
        this.controls = controls;
        this.startingPosition = startingPosition;
        this.startingDirection = startingDirection;
    }

    public Bike toBikeObject() {
        return new Bike(color, controls, startingPosition, startingDirection);
    }

    private static class PlayerControls {
        private static final Controls PLAYER_1_CONTROLS = new KeyboardControls(new int[]{
                KeyEvent.VK_UP,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_LEFT
        });

        private static final Controls PLAYER_2_CONTROLS = new KeyboardControls(new int[]{
                KeyEvent.VK_W,
                KeyEvent.VK_S,
                KeyEvent.VK_D,
                KeyEvent.VK_A
        });

        private static final Controls PLAYER_3_CONTROLS = new MouseControls(new int[]{
                MouseEvent.BUTTON1,
                MouseEvent.BUTTON3
        });
    }
}
