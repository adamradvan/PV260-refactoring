package tronModule;

import generalEngine.Controls;
import generalEngine.Direction;
import generalEngine.Engine;
import generalEngine.GameObject;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Collectors;

public class TronEngine extends Engine {
    
    
    public TronEngine(GraphicsCallBack graphicsInterface) {
        super(graphicsInterface);
    }   

    Bike player1 = new Bike(GameConfiguration.MOVE_AMOUNT,
                                  Color.green,
                                  new Controls(GameConfiguration.PLAYER_1_CONTROLS[0],
                                               GameConfiguration.PLAYER_1_CONTROLS[1],
                                               GameConfiguration.PLAYER_1_CONTROLS[2],
                                               GameConfiguration.PLAYER_1_CONTROLS[3]),
                                  new Position(40, 40),
                                  Direction.RIGHT);
    
    Bike player2 = new Bike(GameConfiguration.MOVE_AMOUNT,
                                  Color.red,
                                  new Controls(GameConfiguration.PLAYER_2_CONTROLS[0],
                                               GameConfiguration.PLAYER_2_CONTROLS[1],
                                               GameConfiguration.PLAYER_2_CONTROLS[2],
                                               GameConfiguration.PLAYER_2_CONTROLS[3]),
                                  new Position(600, 440),
                                  Direction.LEFT);
              
    List<GameObject> playerObjects = List.of(player1, player2);
    List<Bike> players = List.of(player1, player2);

   
    public void startTronEngine() {
        try {
            loadObjects(playerObjects);
            startGame();
            gameLoop();
        } finally {
            screenManager.restoreScreen();
        }        
    }
    
    private void checkForPlayersCollisions() {
        for (Bike player : players) {
            checkPlayerPath(player);
            checkOthersPath(player);
        }
    }

    private void checkOthersPath(Bike player) {
        List<Bike> others = players.stream().filter(p -> !p.equals(player)).collect(Collectors.toList());
        for (Bike otherPlayer : others) {
            for (Position positionOfOther : otherPlayer.getBikePath()) {
                if (positionOfOther.equals(player.getCurrentPosition())) {
                    System.out.println(player + " hit other " + otherPlayer);
                    stopGame();
                }
            }
        }
    }

    private void checkPlayerPath(Bike player) {
        for (Position playerHistoryPosition : player.getBikePath()) {
            if (playerHistoryPosition.equals(player.getCurrentPosition()) && playerHistoryPosition != player.getCurrentPosition()) {
                System.out.println(player + " hit himself.");
                stopGame();
            }
        }
    }

    @Override
    public void checkColisions() {
        checkForPlayersCollisions();
    } 
}


