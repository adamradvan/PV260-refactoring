package core.presentation;

import core.model.GameObject;

import java.util.List;

public interface GraphicsCallBack {
    void onUpdateGraphics(List<GameObject> gameObjects);
}
