package tronModule;

import generalEngine.Direction;
import generalEngine.GameObject;
import generalEngine.PlayableGameObject;
import generalEngine.controls.Controls;
import tronModule.config.TronGameConfiguration;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static tronModule.config.TronGameConfiguration.MOVE_AMOUNT;

public class Bike implements PlayableGameObject {
    private static final TronGameConfiguration.GameObjectType GAME_OBJECT_TYPE = TronGameConfiguration.GameObjectType.BIKE;

    private Controls controls;
    private Color color;
    private Position currentPosition;
    private Position nextPosition;
    private Direction currentDirection;
    private Direction nextDirection;
    private List<Position> bikePath = new ArrayList<>();
    private boolean parsedLatestInput = false;
    private int inputEvent;

    public Bike(
            Color color,
            Controls controls,
            Position initialPosition,
            Direction initialDirection) {
        this.color = color;
        this.controls = controls;
        this.currentPosition = initialPosition;
        this.currentDirection = initialDirection;
    }

    @Override
    public void assignFromNextToCurrent() {
        currentDirection = nextDirection;
        currentPosition = nextPosition;
    }

    @Override
    public void computeNextDirection() {
        if (!parsedLatestInput) {
            nextDirection = controls.obtainNewDirectionFromEvent(inputEvent, currentDirection);
            parsedLatestInput = true;
        } else
            nextDirection = currentDirection;
    }

    @Override
    public void inputEventCallback(int pressedKey) {
        inputEvent = pressedKey;
        parsedLatestInput = false;
    }

    @Override
    public void computeNextPosition() {
        if (nextDirection.isNextPositionInScreenScope(currentPosition)) {
            nextPosition = nextDirection.newPositionInsideScreenScope(currentPosition);
        } else
            nextPosition = nextDirection.newPositionAtScreenBeginning(currentPosition);
    }

    @Override
    public void addNextPositionToHistory() {
        bikePath.add(nextPosition);
    }

    @Override
    public void onCollision(GameObject gameObject) {
        // todo
    }

    @Override
    public TronGameConfiguration.GameObjectType getType() {
        return GAME_OBJECT_TYPE;
    }

    @Override
    public void drawObject(Graphics2D graphics) {
        for (Position position : bikePath) {
            graphics.setColor(color);
            graphics.fillRect(position.getAxisX(), position.getAxisY(), MOVE_AMOUNT, MOVE_AMOUNT);
        }
    }

    public List<Position> getBikePath() {
        return bikePath;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }
}













    
   