package core.model.controls;

import core.model.Direction;

import java.util.Map;

public class KeyboardControls implements Controls {
    private final Map<Integer, Direction> mappedDirections;

    public KeyboardControls(int[] controls) {
        if (controls.length != 4)
            throw new IllegalArgumentException("KeyboardControls array must be of length 4");

        this.mappedDirections = Map.of(
                controls[0], Direction.UP,
                controls[1], Direction.DOWN,
                controls[2], Direction.RIGHT,
                controls[3], Direction.LEFT);
    }

    @Override
    public Direction obtainNewDirectionFromEvent(int eventCommand, Direction currentDirection) {
        Direction newDirection = mappedDirections.get(eventCommand);

        return (newDirection == null) ? currentDirection : newDirection.validatedFor(currentDirection);
    }

}
