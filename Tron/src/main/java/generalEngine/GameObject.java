package generalEngine;

import java.awt.*;
import java.awt.event.KeyEvent;
import tronModule.GameConfiguration;

public interface GameObject {
    void makeMove(int directionCommand);
    void drawObject(Graphics2D graphics);
    void onCollision(GameObject gameObject);
    GameConfiguration.GameObjectType getType();
}
