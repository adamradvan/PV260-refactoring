package core.config;

import core.model.controls.Controls;
import core.model.controls.KeyboardControls;
import core.model.controls.MouseControls;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PlayerControls {

    public static final Controls ARROWS_CONTROLS = new KeyboardControls(new int[]{
            KeyEvent.VK_UP,
            KeyEvent.VK_DOWN,
            KeyEvent.VK_RIGHT,
            KeyEvent.VK_LEFT
    });

    public static final Controls WASD_CONTROLS = new KeyboardControls(new int[]{
            KeyEvent.VK_W,
            KeyEvent.VK_S,
            KeyEvent.VK_D,
            KeyEvent.VK_A
    });

    public static final Controls MOUSE_CONTROLS = new MouseControls(new int[]{
            MouseEvent.BUTTON1,
            MouseEvent.BUTTON3
    });

    private PlayerControls() {
        throw new UnsupportedOperationException("Immutable class");
    }
}

