package core.presentation;

import core.Engine;
import core.model.GameObject;

import java.awt.*;
import java.util.List;

public class Presentation implements GraphicsCallBack {
    Engine gameEngine;
    Graphics2D graphics;

    public Presentation(Engine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void run() {
        gameEngine.setPresentationGraphics(this);
        graphics = gameEngine.getGraphics();
        gameEngine.startEngine();
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
