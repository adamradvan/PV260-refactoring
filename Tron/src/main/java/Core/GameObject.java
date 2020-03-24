package Core;

import Model.TronGameConfiguration;

import java.awt.*;

public interface GameObject {

    TronGameConfiguration.GameObjectType getType();

    void drawObject(Graphics2D graphics);

    void makeMove();

    void onCollision(GameObject gameObject);

}
