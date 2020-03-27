package core.model;

import core.InputEventCallback;

public interface MovableGameObject extends GameObject, InputEventCallback {

    void computeNextDirection();

    void computeNextPosition();

    void modifyPositionHistory();

    void assignFromNextToCurrent();

    default void makeMove() {
        computeNextDirection();
        computeNextPosition();
        modifyPositionHistory();
        assignFromNextToCurrent();
    }
}
