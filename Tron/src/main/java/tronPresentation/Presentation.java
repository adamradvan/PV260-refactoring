package tronPresentation;

import generalEngine.GameObject;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.util.List;
import tronModule.GraphicsCallBack;
import tronModule.ScreenParameters;
import tronModule.TronEngine;

public class Presentation implements GraphicsCallBack{
    TronEngine tronEngine;
    Graphics2D graphics;
        
    public void run() {      
        tronEngine = new TronEngine(this);
        init();               
        graphics = tronEngine.getGraphics();
        tronEngine.startTronEngine();
        graphics.dispose();
        System.exit(0);
    }
    
    private void init() {
        Window window = tronEngine.getFullScreenWindow();
        window.setFont(new Font("Arial", Font.PLAIN, 20));
        window.setBackground(Color.WHITE);
        window.setForeground(Color.RED);
        window.addKeyListener(tronEngine);
        window.addMouseListener(tronEngine);

        Cursor cursor = window.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null");
        window.setCursor(cursor);
    }

    @Override
    public void onUpdateGraphics(List<GameObject> gameObjects) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, ScreenParameters.getInstance().width, ScreenParameters.getInstance().width);
        for(GameObject gameObject : gameObjects) {
            gameObject.drawObject(graphics);
        }
    }
}
