package tron;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.stream.Collectors;

public class TronMain extends Core {

    Player player1 = new Player(Color.green, GameConfiguration.PLAYER_1_CONTROLS, 40, 40, Direction.RIGHT);
    Player player2 = new Player(Color.red, GameConfiguration.PLAYER_2_CONTROLS, 600, 440, Direction.LEFT);

    List<Player> players = List.of(player1, player2);

    public static void main(String[] args) {
        new TronMain().run();
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());

        player1.draw(graphics, screenManager);
        player2.draw(graphics, screenManager);

        for (Player player : players) {
            checkPlayerPath(player);
            checkOthersPath(player);
        }

    }

    private void checkOthersPath(Player player) {
        List<Player> others = players.stream().filter(p -> !p.equals(player)).collect(Collectors.toList());
        for (Player otherPlayer : others) {
            for (Position positionOfOther : otherPlayer.getBikePath()) {
                if (positionOfOther.equals(player.getCurrentPosition())) {
                    System.out.println(player + " hit other " + otherPlayer);
                    stopGame();
                }
            }
        }
    }

    private void checkPlayerPath(Player player) {
        for (Position playerHistoryPosition : player.getBikePath()) {
            if (playerHistoryPosition.equals(player.getCurrentPosition()) && playerHistoryPosition != player.getCurrentPosition()) {
                System.out.println(player + " hit himself.");
                stopGame();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        player1.keyPressed(event);
        player2.keyPressed(event);
    }
}
