package generalEngine;

import tronModule.TronGameConfiguration;

import java.awt.*;

public interface GameObject {
    void makeMove(int directionCommand);
    void drawObject(Graphics2D graphics);
    void onCollision(GameObject gameObject);
    TronGameConfiguration.GameObjectType getType();
}
