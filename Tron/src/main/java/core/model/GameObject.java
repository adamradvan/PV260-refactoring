package core.model;

import core.config.GameConfiguration;

import java.awt.*;


public interface GameObject {

    GameConfiguration.GameObjectType getType();

    void drawObject(Graphics2D graphics);

    void makeMove();

}
