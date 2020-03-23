package generalEngine;

import java.util.Map;

public class Controls {
    private final int up;
    private final int down;
    private final int right;
    private final int left;
    private final Map<Integer, Direction> mappedDirections;

    public Controls(int up, int down, int right, int left) {
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
        this.mappedDirections = Map.of(
                up, Direction.UP,
                down, Direction.DOWN,
                right, Direction.RIGHT,
                left, Direction.LEFT);
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
    }

    public Direction getDirectionFor(int eventCommand) {
        return mappedDirections.get(eventCommand);
    }

}
