package games.tron;

import core.Engine;
import core.config.GameConfiguration;
import core.config.PlayerConfiguration;
import core.model.GameObject;
import core.model.MovableGameObject;
import core.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TronEngine extends Engine {
    List<Bike> players = GameConfiguration.TRON_PLAYERS.stream().map(PlayerConfiguration::toBikeObject).collect(Collectors.toList());

    @Override
    public List<GameObject> getGameObjects() {
        return new ArrayList<>(players);
    }

    @Override
    public List<MovableGameObject> getMovableGameObjects() {
        return new ArrayList<>(players);
    }

    @Override
    public void checkCollisions() {
        checkForPlayersCollisions();
    }

    private void checkForPlayersCollisions() {
        for (Bike player : players) {
            checkSelfCollision(player.getCurrentPosition(), player.getPositionHistory());
            checkOthersPath(player);
        }
    }

    private void checkOthersPath(Bike player) {
        List<Bike> others = players.stream().filter(p -> !p.equals(player)).collect(Collectors.toList());
        for (Bike otherPlayer : others) {
            for (Position positionOfOther : otherPlayer.getPositionHistory()) {
                if (positionOfOther.equals(player.getCurrentPosition())) {                    
                    stopGame();
                }
            }
        }
    }


}


