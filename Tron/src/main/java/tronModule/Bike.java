package tronModule;

import generalEngine.Controls;
import generalEngine.Direction;
import generalEngine.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static tronModule.TronGameConfiguration.MOVE_AMOUNT;

public class Bike implements GameObject {
    private static final TronGameConfiguration.GameObjectType GAME_OBJECT_TYPE = TronGameConfiguration.GameObjectType.Bike;

    private Controls controls;
    private Color color;
    private Position currentPosition;
    private Position nextPosition;
    private Direction currentDirection;
    private Direction nextDirection;
    private List<Position> bikePath = new ArrayList<>();

    public Bike(
            Color color,
            Controls controls,
            Position initialPosition,
            Direction initialDirection) {
        this.controls = controls;
        this.color = color;
        this.currentPosition = initialPosition;
        this.currentDirection = initialDirection;
    }

    @Override
    public void makeMove(int directionCommand) {
        Direction command = findDirectionOfEvent(directionCommand);
        findDirectionOfNextMove(command);
        computeNextPosition();
        addNextPositionToPath();
        currentDirection = nextDirection;
        currentPosition = nextPosition;
    }

    private Direction findDirectionOfEvent(int command) {
        Direction direction =  controls.getDirectionFor(command);
        if (direction == null) return currentDirection;
        return direction;
    }

     protected void findDirectionOfNextMove(Direction directionCommand) {
         nextDirection = directionCommand.checkNextMoveDirection(currentDirection);
     }


    protected void computeNextPosition() {
        if (nextDirection.isNextPositionInScreenScope(currentPosition)) {
            nextPosition = nextDirection.newPositionInsideScreenScope(currentPosition);
        } else
            nextPosition = nextDirection.newPositionAtScreenBeginning(currentPosition);
    }

    private void addNextPositionToPath() {
        bikePath.add(nextPosition);
    }

    @Override
    public void onCollision(GameObject gameObject) {

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













    
   