package generalEngine.controls;

import generalEngine.Direction;

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
        System.out.println(String.format("KeyEvent: %s, currDir: %s", eventCommand, currentDirection));
        Direction newDirection = mappedDirections.get(eventCommand);
        if (newDirection == null) return currentDirection;
        return newDirection.validatedFor(currentDirection);
    }

}
