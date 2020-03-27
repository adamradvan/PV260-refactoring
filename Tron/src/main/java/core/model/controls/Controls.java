package core.model.controls;

import core.model.Direction;

public interface Controls {

    Direction obtainNewDirectionFromEvent(int eventCommand, Direction currentDirection);

}
