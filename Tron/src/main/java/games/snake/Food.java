package games.snake;

import core.model.GameObjectImpl;
import core.model.Position;

import java.awt.*;

public class Food extends GameObjectImpl {

    public Food(Color color, Position position) {
        super(color, position);
    }

}
