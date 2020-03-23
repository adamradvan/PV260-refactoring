package generalEngine;

import java.util.Map;

public class Controls {
    private Map<Integer, Direction> mappedDirections;

    public Controls(int[] controls) {
        if (controls.length != 4)
            throw new IllegalArgumentException("Controls array must be of length 4");

        this.mappedDirections = Map.of(
                controls[0], Direction.UP,
                controls[1], Direction.DOWN,
                controls[2], Direction.RIGHT,
                controls[3], Direction.LEFT);
    }

    public Direction getDirectionFor(int eventCommand) {
        return mappedDirections.get(eventCommand);
    }

}
