package tron;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public abstract class Core implements KeyListener, MouseListener, MouseMotionListener {

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
    protected ScreenManager screenManager;
    private boolean running;

    public void run() {
        try {
            init();
            gameLoop();
        } finally {
            screenManager.restoreScreen();
        }
        System.exit(0);
    }

    public void init() {
        screenManager = new ScreenManager();

        DisplayMode displayMode = screenManager.findFirstCompatibleMode(modes);
        screenManager.setFullScreen(displayMode);

        Window window = screenManager.getFullScreenWindow();
        window.setFont(new Font("Arial", Font.PLAIN, 20));
        window.setBackground(Color.WHITE);
        window.setForeground(Color.RED);
        window.addKeyListener(this);
        window.addMouseListener(this);
        window.addMouseMotionListener(this);

        Cursor cursor = window.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null");
        window.setCursor(cursor);

        running = true;
    }

    public void gameLoop() {
        while (running) {
            Graphics2D graphics = screenManager.getGraphics();
            draw(graphics);
            graphics.dispose();

            screenManager.update();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopGame() {
        running = false;
    }


    public abstract void draw(Graphics2D g);

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
