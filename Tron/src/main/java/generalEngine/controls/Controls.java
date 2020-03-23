package generalEngine.controls;

import generalEngine.Direction;

public interface Controls {

    Direction obtainNewDirectionFromEvent(int eventCommand, Direction currentDirection);

}
