package core.model;

import core.model.controls.Controls;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class MovableGameObjectImpl extends GameObjectImpl implements MovableGameObject {
    protected Position nextPosition;
    private Controls controls;
    private Direction currentDirection;
    private Direction nextDirection;
    private List<Position> positionHistory = new ArrayList<>();
    private boolean parsedLatestInput = false;
    private int inputEvent;

    public MovableGameObjectImpl(Color color,
                                 Controls controls,
                                 Position initialPosition,
                                 Direction initialDirection) {
        super(color, initialPosition);
        this.controls = controls;
        this.currentDirection = initialDirection;
    }


    @Override
    public void assignFromNextToCurrent() {
        this.currentDirection = nextDirection;
        super.position = nextPosition;
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
        if (nextDirection.isNextPositionInScreenScope(getCurrentPosition())) {
            nextPosition = nextDirection.newPositionInsideScreenScope(getCurrentPosition());
        } else
            nextPosition = nextDirection.newPositionAtScreenBeginning(getCurrentPosition());
    }

    @Override
    public void drawObject(Graphics2D graphics) {
        for (Position position : positionHistory) {
            drawForPosition(position, graphics);
        }
    }

    public Position getCurrentPosition() {
        return position;
    }

    public List<Position> getPositionHistory() {
        return positionHistory;
    }
}














