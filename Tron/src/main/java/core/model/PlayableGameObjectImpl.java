package core.model;

import core.model.controls.Controls;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static core.config.GameConfiguration.SQUARE_SIZE;

public abstract class PlayableGameObjectImpl implements PlayableGameObject {
    protected Position nextPosition;
    private Controls controls;
    private Color color;
    private Position currentPosition;
    private Direction currentDirection;
    private Direction nextDirection;
    private List<Position> positionHistory = new ArrayList<>();
    private boolean parsedLatestInput = false;
    private int inputEvent;

    public PlayableGameObjectImpl(Color color,
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
    public void drawObject(Graphics2D graphics) {
        for (Position position : positionHistory) {
            graphics.setColor(color);
            graphics.fillRect(position.getAxisX(), position.getAxisY(), SQUARE_SIZE, SQUARE_SIZE);
        }
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public List<Position> getPositionHistory() {
        return positionHistory;
    }
}














