package Core.models;

import Core.InputEventCallback;

public interface PlayableGameObject extends GameObject, InputEventCallback {

    void computeNextDirection();

    void computeNextPosition();

    void addNextPositionToHistory();

    void assignFromNextToCurrent();

    @Override
    default void makeMove() {
        computeNextDirection();
        computeNextPosition();
        addNextPositionToHistory();
        assignFromNextToCurrent();
    }
}
