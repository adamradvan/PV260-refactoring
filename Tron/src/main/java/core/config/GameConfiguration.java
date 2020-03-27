package core.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameConfiguration {

    public static final int SQUARE_SIZE = 10;
    public static final GameSpeed GAME_SPEED = GameSpeed.MEDIUM;

    public static final List<PlayerConfiguration> TRON_PLAYERS = Arrays.stream(PlayerConfiguration.values()).collect(Collectors.toList());
//    public static final List<PlayerConfiguration> TRON_PLAYERS = List.of(PlayerConfiguration.PLAYER_ARROWS, PlayerConfiguration.PLAYER_MOUSE);

    public static final PlayerConfiguration SNAKE_PLAYER = PlayerConfiguration.PLAYER_ARROWS;

}
