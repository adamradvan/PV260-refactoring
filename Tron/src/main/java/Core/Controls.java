package Core;

import Core.Direction;

public interface Controls {

    Direction obtainNewDirectionFromEvent(int eventCommand, Direction currentDirection);

}
