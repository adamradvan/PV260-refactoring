package tronModule.config;

import generalEngine.Controls;
import generalEngine.Direction;
import tronModule.Bike;
import tronModule.Position;

import java.awt.*;
import java.awt.event.KeyEvent;

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
    );

    private Color color;
    private int[] controls;
    private Position startingPosition;
    private Direction startingDirection;

    PlayersConfiguration(Color color, int[] controls, Position startingPosition, Direction startingDirection) {
        this.color = color;
        this.controls = controls;
        this.startingPosition = startingPosition;
        this.startingDirection = startingDirection;
    }

    public Bike toBikeObject() {
        return new Bike(color, new Controls(controls), startingPosition, startingDirection);
    }


    private static class PlayerControls {
        public static final int[] PLAYER_1_CONTROLS = {
                KeyEvent.VK_UP,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_LEFT};

        public static final int[] PLAYER_2_CONTROLS = {
                KeyEvent.VK_W,
                KeyEvent.VK_S,
                KeyEvent.VK_D,
                KeyEvent.VK_A};
    }

}
