package Model;

import Core.GraphicsCallBack;
import Core.Engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TronEngine extends Engine {
    List<Bike> players = Arrays.stream(PlayersConfiguration.values())
            .map(PlayersConfiguration::toBikeObject)
            .collect(Collectors.toList());
    
    public TronEngine(GraphicsCallBack graphicsInterface) {
        super(graphicsInterface);
    }
    
    public void startTronEngine() {
        try {
            loadObjects(new ArrayList<>(players));
            loadPlayableObjects(new ArrayList<>(players));
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
    public void checkCollisions() {
        checkForPlayersCollisions();
    } 
}


