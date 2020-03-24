package Core;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;


public abstract class Engine implements ListenerManager {
    private final Window window;
    private List<GameObject> gameObjects;
    private List<PlayableGameObject> playableGameObjects;
    private final GraphicsCallBack presentationGraphics;
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
        window = screenManager.getFullScreenWindow();
    }

    protected void loadObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    protected void loadPlayableObjects(List<PlayableGameObject> playableGameObjects) {
        this.playableGameObjects = playableGameObjects;
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
                gameObject.makeMove();
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

    @Override
    public void keyPressed(KeyEvent event) {
        pressedKey = event.getKeyCode();

        if (pressedKey == KeyEvent.VK_ESCAPE) {
            System.out.println("User input: ESCAPE, stopping the game");
            stopGame();
        }

        for (PlayableGameObject playable : playableGameObjects) {
            playable.inputEventCallback(pressedKey);
        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        pressedKey = event.getButton();

        for (PlayableGameObject playable : playableGameObjects) {
            playable.inputEventCallback(pressedKey);
        }
    }
    
    public void createWindow(Font font, Color backgroundCcolor, Color foregroundColor) {
        window.setFont(font);
        window.setBackground(backgroundCcolor);
        window.setForeground(foregroundColor);
        window.addKeyListener(this);
        window.addMouseListener(this);
        Cursor cursor = window.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null");
        window.setCursor(cursor);
    }
    
    public abstract void checkCollisions();
}