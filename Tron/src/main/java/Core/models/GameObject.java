package Core.models;

import Model.TronGameConfiguration;

import java.awt.*;
import java.util.List;
import java.util.Optional;


public interface GameObject {

    TronGameConfiguration.GameObjectType getType();

    void drawObject(Graphics2D graphics);

    void makeMove();

}
