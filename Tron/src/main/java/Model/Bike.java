package Model;

import Core.controls.Controls;
import Core.Direction;
import Core.models.PlayableGameObjectImpl;

import java.awt.*;

public class Bike extends PlayableGameObjectImpl {
    private static final TronGameConfiguration.GameObjectType GAME_OBJECT_TYPE = TronGameConfiguration.GameObjectType.BIKE;

    public Bike(Color color, Controls controls, Position initialPosition, Direction initialDirection) {
        super(color, controls, initialPosition, initialDirection);
    }


    @Override
    public TronGameConfiguration.GameObjectType getType() {
        return GAME_OBJECT_TYPE;
    }


}













    
   