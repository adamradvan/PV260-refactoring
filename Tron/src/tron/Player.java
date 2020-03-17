package tron;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Player implements KeyListener{
    Controls controls;
    private Color color;
    private ArrayList<Position> path;
    private Direction currentDirection;
    
    public Player(Color color, 
                  int[] controls, 
                  int initialXPosition, 
                  int initialYPosition,
                  Direction initialDirection){
        this.color = color;
        this.controls = new Controls(controls[0], 
                                     controls[1], 
                                     controls[2], 
                                     controls[3]);
        path = new ArrayList();
        path.add(new Position(initialXPosition, initialYPosition));
        this.currentDirection = initialDirection;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent pressedKeyEvent) {
        if(pressedKeyEvent.getKeyCode() == controls.getUp() && 
           !currentDirection.equals(Direction.DOWN)) {
            currentDirection = Direction.UP;
        } 
        
        if(pressedKeyEvent.getKeyCode() == controls.getDown() && 
           !currentDirection.equals(Direction.UP)) {
            currentDirection = Direction.DOWN;
        } 
        
        if(pressedKeyEvent.getKeyCode() == controls.getRight()&& 
           !currentDirection.equals(Direction.LEFT)) {
            currentDirection = Direction.RIGHT;
        }
        
        if(pressedKeyEvent.getKeyCode() == controls.getLeft()&& 
           !currentDirection.equals(Direction.RIGHT)) {
            currentDirection = Direction.LEFT;
        }  
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
