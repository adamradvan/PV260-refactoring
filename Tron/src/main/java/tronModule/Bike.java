package tronModule;

import generalEngine.Controls;
import generalEngine.Direction;
import generalEngine.GameObject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Bike implements GameObject{
    private int moveAmount;
    private Controls controls;
    private Color color;
    private Position currentPosition;
    private Position nextPosition;
    private Direction currentDirection;
    private Direction nextDirection;
    private GameConfiguration.GameObjectType type = GameConfiguration.GameObjectType.Bike;  
    private ArrayList<Position> bikePath = new ArrayList<>();
    
    public Bike(int moveAmount,
                Color color,
                Controls controls,
                Position initialPosition,
                Direction initialDirection) {        
        this.moveAmount = moveAmount;
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


    //TODO: refactor this method to remove screen overflows
    protected void computeNextPosition() {
        switch (nextDirection) {
            case UP:
                if (currentPosition.getAxisY() > 0) {
                    nextPosition = new Position(currentPosition.getAxisX(),
                                                   currentPosition.getAxisY() - moveAmount);
                } else {
                    nextPosition = new Position(currentPosition.getAxisX(),
                                                   ScreenParameters.getInstance().height);
                }
                break;
            case DOWN:
                if (currentPosition.getAxisY() < ScreenParameters.getInstance().height) {
                    nextPosition = new Position(currentPosition.getAxisX(),
                                                   currentPosition.getAxisY() + moveAmount);
                } else {
                    nextPosition = new Position(currentPosition.getAxisX(), 0);
                }
                break;
            case RIGHT:
                if (currentPosition.getAxisX() < ScreenParameters.getInstance().width) {
                    nextPosition = new Position(currentPosition.getAxisX() + moveAmount,
                                                   currentPosition.getAxisY());
                } else {
                    nextPosition = new Position(0, currentPosition.getAxisY());
                }
                break;
            case LEFT:
                if (currentPosition.getAxisX() > 0) {
                    nextPosition = new Position(currentPosition.getAxisX() - moveAmount,
                                                   currentPosition.getAxisY());
                } else {
                    nextPosition = new Position(ScreenParameters.getInstance().width,
                                                   currentPosition.getAxisY());
                }
                break;
            default:
                nextPosition = null;
                break;
        }
    }

    @Override
    public void onCollision(GameObject gameObject) {
        
    }

    @Override
    public GameConfiguration.GameObjectType getType() {
        return type;
    }
    
    @Override
    public void drawObject(Graphics2D graphics) {
        for (Position position : bikePath) {
            graphics.setColor(color);
            graphics.fillRect(position.getAxisX(), position.getAxisY(), 5, 5);
        }
    }
    
    private void addNextPositionToPath() {
        bikePath.add(nextPosition);
    }
    
    public ArrayList<Position> getBikePath() {
        return bikePath;
    }
    
    public Position getCurrentPosition() {
        return currentPosition;
    }
}













    
   