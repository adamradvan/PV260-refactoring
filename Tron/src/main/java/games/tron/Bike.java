package games.tron;

import core.model.Direction;
import core.model.MovableGameObjectImpl;
import core.model.Position;
import core.model.controls.Controls;

import java.awt.*;

public class Bike extends MovableGameObjectImpl {

    public Bike(Color color, Controls controls, Position initialPosition, Direction initialDirection) {
        super(color, controls, initialPosition, initialDirection);
    }

    @Override
    public void modifyPositionHistory() {
        getPositionHistory().add(nextPosition);
    }

}













    
   