package tron;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    private static final int MOVE_AMOUNT = 5;
    private Controls controls;
    private Color color;
    private ArrayList<Position> bikePath = new ArrayList<>();
    private Direction currentDirection;
    private Direction nextDirection;
    private Position currentPosition;
    private Position nextPosition;

    public Player(Color color,
                  int[] controls,
                  int initialXPosition,
                  int initialYPosition,
                  Direction initialDirection) {
        this.color = color;
        this.currentDirection = initialDirection;
        this.controls = new Controls(controls[0], controls[1], controls[2], controls[3]);

        this.currentPosition = new Position(initialXPosition, initialYPosition);
        bikePath.add(this.currentPosition);
    }

    public void makeMove(int directionCommand, 
                         ScreenManager screenManager,
                         Graphics2D graphics) {
        findDirectionOfNextMove(directionCommand);
        computeNextPosition(screenManager);
        addNextPositionToPath();
        drawBikePath(graphics);
        currentDirection = nextDirection;
        currentPosition = nextPosition;
    }
    
    public void findDirectionOfNextMove(int directionCommand) {
        if (directionCommand == controls.getUp() && !currentDirection.equals(Direction.DOWN)) {
            nextDirection = Direction.UP;
        } else if (directionCommand == controls.getDown() && !currentDirection.equals(Direction.UP)) {
            nextDirection = Direction.DOWN;
        } else if (directionCommand == controls.getRight() && !currentDirection.equals(Direction.LEFT)) {
            nextDirection = Direction.RIGHT;
        } else if (directionCommand == controls.getLeft() && !currentDirection.equals(Direction.RIGHT)) {
            nextDirection = Direction.LEFT;
        } else {
            nextDirection = currentDirection;
        }
    }
    
    public void computeNextPosition(ScreenManager screenManager) {
        switch (nextDirection) {
            case UP:
                if (currentPosition.getAxisY() > 0) {
                    nextPosition = new Position(currentPosition.getAxisX(),
                                                   currentPosition.getAxisY() - MOVE_AMOUNT);
                } else {
                    nextPosition = new Position(currentPosition.getAxisX(),
                                                   screenManager.getHeight());
                }
                break;
            case DOWN:
                if (currentPosition.getAxisY() < screenManager.getHeight()) {
                    nextPosition = new Position(currentPosition.getAxisX(),
                                                   currentPosition.getAxisY() + MOVE_AMOUNT);
                } else {
                    nextPosition = new Position(currentPosition.getAxisX(), 0);
                }
                break;
            case RIGHT:
                if (currentPosition.getAxisX() < screenManager.getWidth()) {
                    nextPosition = new Position(currentPosition.getAxisX() + MOVE_AMOUNT,
                                                   currentPosition.getAxisY());
                } else {
                    nextPosition = new Position(0, currentPosition.getAxisY());
                }
                break;
            case LEFT:
                if (currentPosition.getAxisX() > 0) {
                    nextPosition = new Position(currentPosition.getAxisX() - MOVE_AMOUNT,
                                                   currentPosition.getAxisY());
                } else {
                    nextPosition = new Position(screenManager.getWidth(),
                                                   currentPosition.getAxisY());
                }
                break;
            default:
                nextPosition = null;
                break;
        }
    }
    
    public void addNextPositionToPath() {
        bikePath.add(nextPosition);
    }
    
    public void drawBikePath(Graphics2D graphics) {
        for (Position position : bikePath) {
            graphics.setColor(color);
            graphics.fillRect(position.getAxisX(), position.getAxisY(), 5, 5);
        }
    }
        
    public Direction getCurrentDirection() {
        return currentDirection;
    }
    
    public Position getCurrentPosition() {
        return currentPosition;
    }

    public ArrayList<Position> getBikePath() {
        return bikePath;
    }
}
