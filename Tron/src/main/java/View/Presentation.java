package View;

import Core.Engine;
import Core.GameObject;
import Core.GraphicsCallBack;
import Core.ScreenParameters;
import Model.TronEngine;

import java.awt.*;
import java.util.List;

public class Presentation implements GraphicsCallBack {
    Engine tronEngine;
    Graphics2D graphics;

    public void run() {
        tronEngine = new TronEngine(this);
        graphics = tronEngine.getGraphics();
        tronEngine.startEngine();
        graphics.dispose();
        System.exit(0);
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
