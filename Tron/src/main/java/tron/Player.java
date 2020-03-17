package main.java.tron;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Player implements KeyListener {
    private static final int MOVE_AMOUNT = 5;
    private Controls controls;
    private Color color;
    private ArrayList<Position> bikePath = new ArrayList<>();
    private Direction currentDirection;
    private Position currentPosition;

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

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent pressedKeyEvent) {
        if (pressedKeyEvent.getKeyCode() == controls.getUp() && !currentDirection.equals(Direction.DOWN)) {
            currentDirection = Direction.UP;
        }

        if (pressedKeyEvent.getKeyCode() == controls.getDown() && !currentDirection.equals(Direction.UP)) {
            currentDirection = Direction.DOWN;
        }

        if (pressedKeyEvent.getKeyCode() == controls.getRight() && !currentDirection.equals(Direction.LEFT)) {
            currentDirection = Direction.RIGHT;
        }

        if (pressedKeyEvent.getKeyCode() == controls.getLeft() && !currentDirection.equals(Direction.RIGHT)) {
            currentDirection = Direction.LEFT;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }
    
    public void draw(Graphics2D graphics, ScreenManager screenManager) {
        switch (currentDirection) {
            case UP:
                if (currentPosition.getAxisY() > 0) {
                    currentPosition = new Position(currentPosition.getAxisX(),
                                                   currentPosition.getAxisY() - MOVE_AMOUNT);
                } else {
                    currentPosition = new Position(currentPosition.getAxisX(),
                                                   screenManager.getHeight());
                }
                break;
            case DOWN:
                if (currentPosition.getAxisY() < screenManager.getHeight()) {
                    currentPosition = new Position(currentPosition.getAxisX(),
                                                   currentPosition.getAxisY() + MOVE_AMOUNT);
                } else {
                    currentPosition = new Position(currentPosition.getAxisX(), 0);
                }
                break;
            case RIGHT:
                if (currentPosition.getAxisX() < screenManager.getWidth()) {
                    currentPosition = new Position(currentPosition.getAxisX() + MOVE_AMOUNT,
                                                   currentPosition.getAxisY());
                } else {
                    currentPosition = new Position(0, currentPosition.getAxisY());
                }
                break;
            case LEFT:
                if (currentPosition.getAxisX() > 0) {
                    currentPosition = new Position(currentPosition.getAxisX() - MOVE_AMOUNT,
                                                   currentPosition.getAxisY());
                } else {
                    currentPosition = new Position(screenManager.getWidth(),
                                                   currentPosition.getAxisY());
                }
                break;
        }
        
        bikePath.add(currentPosition);

        for (Position position : bikePath) {
            graphics.setColor(color);
            graphics.fillRect(position.getAxisX(), position.getAxisY(), 10, 10);
        }
    }
    
    public Position getCurrentPosition() {
        return currentPosition;
    }

    public ArrayList<Position> getBikePath() {
        return bikePath;
    }
}
