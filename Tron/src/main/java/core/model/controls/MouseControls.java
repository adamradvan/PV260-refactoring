package core.model.controls;

import core.model.Direction;

import java.util.List;
import java.util.Map;

import static core.model.Direction.*;

public class MouseControls implements Controls {

    private final Map<Direction, List<Direction>> neighbouringDirections = Map.of(
            UP, List.of(LEFT, RIGHT),
            DOWN, List.of(RIGHT, LEFT),
            RIGHT, List.of(UP, DOWN),
            LEFT, List.of(DOWN, UP)
    );

    private Map<Integer, Integer> mappedIndexes;

    public MouseControls(int[] controls) {
        if (controls.length != 2)
            throw new IllegalArgumentException("MouseControls array must be of length 2, first");

        this.mappedIndexes = Map.of(
                controls[0], 0,
                controls[1], 1);
    }


    @Override
    public Direction obtainNewDirectionFromEvent(int eventCommand, Direction currentDirection) {
        Integer indexOfNeighbour = mappedIndexes.get(eventCommand);

        return (indexOfNeighbour == null) ? currentDirection :
                neighbouringDirections.get(currentDirection).get(indexOfNeighbour);

    }
}
