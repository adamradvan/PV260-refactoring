package core.model;

import core.InputEventCallback;

public interface PlayableGameObject extends GameObject, InputEventCallback {

    void computeNextDirection();

    void computeNextPosition();

    void modifyPositionHistory();

    void assignFromNextToCurrent();

    @Override
    default void makeMove() {
        computeNextDirection();
        computeNextPosition();
        modifyPositionHistory();
        assignFromNextToCurrent();
    }
}
