package games.tron;

import core.config.GameConfiguration;
import core.model.Direction;
import core.model.PlayableGameObjectImpl;
import core.model.Position;
import core.model.controls.Controls;

import java.awt.*;

public class Bike extends PlayableGameObjectImpl {
    private static final GameConfiguration.GameObjectType GAME_OBJECT_TYPE = GameConfiguration.GameObjectType.BIKE;

    public Bike(Color color, Controls controls, Position initialPosition, Direction initialDirection) {
        super(color, controls, initialPosition, initialDirection);
    }

    @Override
    public void modifyPositionHistory() {
        getPositionHistory().add(nextPosition);
    }

    @Override
    public GameConfiguration.GameObjectType getType() {
        return GAME_OBJECT_TYPE;
    }

}













    
   