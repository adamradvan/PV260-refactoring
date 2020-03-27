package games;

import core.presentation.Presentation;
import games.snake.SnakeEngine;
import games.tron.TronEngine;

public class GameStarter {
    public static void main(String[] args) {
//        new Presentation(new TronEngine()).run();
        new Presentation(new SnakeEngine()).run();
    }
}
