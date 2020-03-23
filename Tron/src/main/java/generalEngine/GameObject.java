package generalEngine;

import java.awt.*;
import java.awt.event.KeyEvent;
import tronModule.GameConfiguration;

public interface GameObject {
    public abstract void makeMove(int directionCommand);
    public abstract void drawObject(Graphics2D graphics);
    public abstract void onColision(GameObject gameObject);
    public abstract GameConfiguration.GameObjectType getType();
}
