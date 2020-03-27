package games.snake;

import core.Engine;
import core.config.GameConfiguration;
import core.model.GameObject;
import core.model.MovableGameObject;
import core.model.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static games.snake.PositionGenerator.getValidPositionForFood;


public class SnakeEngine extends Engine {
    public static final Color FOOD_COLOR = Color.RED;

    Snake snake = GameConfiguration.SNAKE_PLAYER.toSnakeObject();
    Food currentFood = createNewFood();

    @Override
    public List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.add(snake);
        gameObjects.add(currentFood);
        return gameObjects;
    }

    @Override
    public List<MovableGameObject> getMovableGameObjects() {
        return List.of(snake);
    }

    @Override
    public void checkCollisions() {
        checkSnakeCollision();
    }

    private void checkSnakeCollision() {
        // check snake collision with itself -> end game
        checkSelfCollision(snake.getCurrentPosition(), snake.getPositionHistory());

        // snake collision with food -> enlarge snake, remove food from engine, add+set new food
        checkCollisionWithFood();
    }

    private void checkCollisionWithFood() {
        if (snake.getCurrentPosition().equals(currentFood.getPosition())) {
            snake.feedSnake();
            removeObject(currentFood);
            currentFood = createNewFood();
            addObject(currentFood);
        }
    }

    private Food createNewFood() {
        Position foodPosition = getValidPositionForFood(snake.getPositionHistory());
        return new Food(FOOD_COLOR, foodPosition);
    }

}
