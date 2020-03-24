package Core;

import Core.GameObject;
import java.util.List;

public interface GraphicsCallback {
    void onUpdateGraphics(List<GameObject> gameObjects);
}
