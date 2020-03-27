package core;


import core.config.GameConfiguration;
import core.model.GameObject;
import core.model.MovableGameObject;
import core.model.Position;
import core.presentation.GraphicsCallBack;
import core.presentation.ScreenManager;
import core.presentation.ScreenParameters;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public abstract class Engine implements ListenerManager {
    private static final DisplayMode[] modes =
            {
                    new DisplayMode(1920, 1080, 32, 0),
                    new DisplayMode(1680, 1050, 32, 0),
                    new DisplayMode(1280, 1024, 32, 0),
                    new DisplayMode(800, 600, 32, 0),
                    new DisplayMode(800, 600, 24, 0),
                    new DisplayMode(800, 600, 16, 0),
                    new DisplayMode(640, 480, 32, 0),
                    new DisplayMode(640, 480, 24, 0),
                    new DisplayMode(640, 480, 16, 0),
            };
    private final Window window;
    protected ScreenManager screenManager = new ScreenManager();
    protected ScreenParameters screenParameters = ScreenParameters.getInstance();
    private GraphicsCallBack presentationGraphics;
    private List<GameObject> gameObjects = new ArrayList<>();
    private List<MovableGameObject> movableGameObjects = new ArrayList<>();
    private int pressedKey;
    private boolean running;

    protected Engine() {
        DisplayMode displayMode = screenManager.findFirstCompatibleMode(modes);
        screenManager.setFullScreen(displayMode);
        screenParameters.height = screenManager.getHeight();
        screenParameters.width = screenManager.getWidth();
        window = screenManager.getFullScreenWindow();
        initializeWindow();
    }

    public void setPresentationGraphics(GraphicsCallBack presentationGraphics) {
        this.presentationGraphics = presentationGraphics;
    }

    public abstract void checkCollisions();

    public abstract List<GameObject> getGameObjects();

    public abstract List<MovableGameObject> getMovableGameObjects();

    public void startEngine() {
        try {
            loadObjects();
            loadPlayableObjects();
            startGame();
            gameLoop();
        } finally {
            screenManager.restoreScreen();
        }
    }

    protected void gameLoop() {
        while (running) {
            presentationGraphics.onUpdateGraphics(gameObjects);
            checkCollisions();
            for (MovableGameObject movable : movableGameObjects) {
                movable.makeMove();
            }
            screenManager.update();

            try {
                Thread.sleep(GameConfiguration.GAME_SPEED.milliseconds());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void loadObjects() {
        List<GameObject> gameObjects = getGameObjects();
        if (gameObjects == null) {
            throw new IllegalArgumentException("Game objects must be initialised in engine implementation");
        }
        this.gameObjects = gameObjects;
    }

    protected void loadPlayableObjects() {
        List<MovableGameObject> movableGameObjects = getMovableGameObjects();
        if (movableGameObjects == null) {
            throw new IllegalArgumentException("Playable game objects must be initialised in engine implementation");
        }
        this.movableGameObjects = movableGameObjects;
    }

    protected void addObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    protected void removeObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    protected void checkSelfCollision(Position positionToCheck, List<Position> path) {
        for (Position positionFromPath : path) {
            if (positionFromPath.equals(positionToCheck) && positionFromPath != positionToCheck) {
                stopGame();
            }
        }
    }

    protected void startGame() {
        running = true;
    }

    protected void stopGame() {
        running = false;
    }

    public Graphics2D getGraphics() {
        return screenManager.getGraphics();
    }


    @Override
    public void keyPressed(KeyEvent event) {
        pressedKey = event.getKeyCode();

        if (pressedKey == KeyEvent.VK_ESCAPE) {
            stopGame();
        }

        for (MovableGameObject playable : movableGameObjects) {
            playable.inputEventCallback(pressedKey);
        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        pressedKey = event.getButton();

        for (MovableGameObject playable : movableGameObjects) {
            playable.inputEventCallback(pressedKey);
        }
    }

    private void initializeWindow() {
        window.setFont(new Font("Arial", Font.PLAIN, 20));
        window.setBackground(Color.WHITE);
        window.setForeground(Color.RED);
        window.addKeyListener(this);
        window.addMouseListener(this);
        Cursor cursor = window.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null");
        window.setCursor(cursor);
    }

}