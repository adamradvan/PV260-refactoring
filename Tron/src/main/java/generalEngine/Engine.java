package generalEngine;

import tronModule.GraphicsCallBack;
import tronModule.ScreenManager;
import tronModule.ScreenParameters;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;


public abstract class Engine implements ListenerManager {
    private List<GameObject> gameObjects;
    private GraphicsCallBack presentationGraphics;
    protected ScreenManager screenManager = new ScreenManager();
    protected ScreenParameters screenParameters = ScreenParameters.getInstance();
    private int pressedKey;
    private boolean running;
    
    private static final DisplayMode[] modes =
            {
                    // new DisplayMode(1920,1080,32,0),
                    new DisplayMode(1680, 1050, 32, 0),
                    // new DisplayMode(1280,1024,32,0),
                    new DisplayMode(800, 600, 32, 0),
                    new DisplayMode(800, 600, 24, 0),
                    new DisplayMode(800, 600, 16, 0),
                    new DisplayMode(640, 480, 32, 0),
                    new DisplayMode(640, 480, 24, 0),
                    new DisplayMode(640, 480, 16, 0),
            };
    
    protected Engine(GraphicsCallBack graphicsInterface) {
        this.presentationGraphics = graphicsInterface; 
        DisplayMode displayMode = screenManager.findFirstCompatibleMode(modes);
        screenManager.setFullScreen(displayMode);
        screenParameters.height = screenManager.getHeight();
        screenParameters.width = screenManager.getWidth();
    }
    
    protected void loadObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }
    
    protected void addObject(GameObject gameObject) {
        //todo:
    }
    
    protected void removeObject(GameObject gameObject) {
        //todo:
    }
    
    public void gameLoop() {
        while (running) {
            presentationGraphics.onUpdateGraphics(gameObjects);
            checkCollisions();
            for (GameObject gameObject : gameObjects) {
                gameObject.makeMove(pressedKey);
            }
            screenManager.update();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startGame() {
        running = true;
    }

    public void stopGame() {
        running = false;
    }
    
    public Graphics2D getGraphics() {
        return screenManager.getGraphics();
    }
    
    public Window getFullScreenWindow() {
        return screenManager.getFullScreenWindow();
    }

     @Override
    public void keyPressed(KeyEvent event) {
        pressedKey = event.getKeyCode();

        if (pressedKey == KeyEvent.VK_ESCAPE) {
            System.out.println("User input: ESCAPE, closing the game");
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public abstract void checkCollisions();
}