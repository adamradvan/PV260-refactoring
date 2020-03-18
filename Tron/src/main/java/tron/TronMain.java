package tron;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TronMain extends Core implements KeyListener, MouseListener, MouseMotionListener {
    int pressedKey;
    
    Player player1 = new Player(Color.green, GameConfiguration.PLAYER_1_CONTROLS, 40, 40, Direction.RIGHT);
    Player player2 = new Player(Color.red, GameConfiguration.PLAYER_2_CONTROLS, 600, 440, Direction.LEFT);

    public static void main(String[] args) {
        new TronMain().run();
    }

    public void init() {
        super.init();

        Window window = screenManager.getFullScreenWindow();
        window.addKeyListener(this);
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());
        player1.makeMove(pressedKey, screenManager, graphics);
        player2.makeMove(pressedKey, screenManager, graphics);
        
        for(Position position : player1.getBikePath()) {
            if( position.equals(player2.getCurrentPosition()) ||
                ( position.equals(player1.getCurrentPosition()) && 
                  position != player1.getCurrentPosition()) ) {
                System.exit(0);
            }           
        }
        
        for(Position position : player2.getBikePath()) {
            if( position.equals(player1.getCurrentPosition()) ||
                ( position.equals(player2.getCurrentPosition()) && 
                  position != player2.getCurrentPosition()) ) {
                System.exit(0);
            }           
        }
    }

    public void keyPressed(KeyEvent event) {
        pressedKey = event.getKeyCode();
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent arg0) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }
}
