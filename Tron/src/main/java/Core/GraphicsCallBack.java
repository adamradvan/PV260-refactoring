package Core;

import Core.models.GameObject;

import java.util.List;

public interface GraphicsCallBack {
    void onUpdateGraphics(List<GameObject> gameObjects);
}
