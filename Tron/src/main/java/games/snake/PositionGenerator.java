package games.snake;

import core.config.GameConfiguration;
import core.model.Position;
import core.presentation.ScreenParameters;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class PositionGenerator {

    public static Position getValidPositionForFood(List<Position> snakePath) {
        String path = snakePath.stream().map(Position::toString).collect(Collectors.joining(", "));
        System.out.println("Snake path: " + path);

        while (true) {
            Position generatedPosition = randomPosition();
            if (isGeneratedPositionValid(snakePath, generatedPosition))
                return generatedPosition;
        }

    }


    private static int randomNumber(int minInclusive, int maxInclusive) {
        int multiplier = GameConfiguration.SQUARE_SIZE;
        int minMultiplier = minInclusive <= multiplier ? 1 : (int) Math.ceil((double) minInclusive / multiplier);
        int maxMultiplier = maxInclusive / multiplier;
        return multiplier * ThreadLocalRandom.current().nextInt(minMultiplier, maxMultiplier + 1);
    }

    private static Position randomPosition() {
        int axisX = randomNumber(0, ScreenParameters.getInstance().width);
        int axisY = randomNumber(0, ScreenParameters.getInstance().height);

        return new Position(axisX, axisY);
    }

    private static boolean isGeneratedPositionValid(List<Position> snakePath, Position generatedPosition) {
        for (Position snakePartPosition : snakePath) {
            if (snakePartPosition.equals(generatedPosition)) {
                System.out.println("Generated INVALID food on position: " + generatedPosition);
                return false;
            }
        }
        System.out.println("Generated valid food on position: " + generatedPosition);
        return true;
    }
}
