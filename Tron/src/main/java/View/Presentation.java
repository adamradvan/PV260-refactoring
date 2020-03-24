package View;

import Core.GameObject;
import Core.ScreenParameters;
import Model.TronEngine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import Core.GraphicsCallback;

public class Presentation implements GraphicsCallback{
    TronEngine tronEngine;
    Graphics2D graphics;
        
    public void run() {      
        initializeTronEngine();
        tronEngine.startTronEngine();
        graphics.dispose();
        System.exit(0);
    }
    
    public void initializeTronEngine() {
        tronEngine = new TronEngine(this);
        tronEngine.createWindow(new Font("Arial", Font.PLAIN, 20),
                                Color.WHITE,
                                Color.RED);
        graphics = tronEngine.getGraphics();
    }

    @Override
    public void onUpdateGraphics(List<GameObject> gameObjects) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, ScreenParameters.getInstance().width, ScreenParameters.getInstance().height);
        for (GameObject gameObject : gameObjects) {
            gameObject.drawObject(graphics);
        }
    }
}
