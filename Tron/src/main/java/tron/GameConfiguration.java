package tron;

import java.awt.event.KeyEvent;

public class GameConfiguration {
    public static final int NUMBER_OF_PLAYERS = 2;

    public static final int[] PLAYER_1_CONTROLS = {
            KeyEvent.VK_UP,
            KeyEvent.VK_DOWN,
            KeyEvent.VK_RIGHT,
            KeyEvent.VK_LEFT};

    public static final int[] PLAYER_2_CONTROLS = {
            KeyEvent.VK_W,
            KeyEvent.VK_S,
            KeyEvent.VK_D,
            KeyEvent.VK_A};
}
