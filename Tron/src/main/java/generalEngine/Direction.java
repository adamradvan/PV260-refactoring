package generalEngine;

public enum Direction {
    UP {
        @Override
        public Direction checkNextMoveDirection(Direction currentDirection) {
            if (currentDirection.equals(DOWN)) return currentDirection;
            return UP;
        }
    },
    DOWN {
        @Override
        public Direction checkNextMoveDirection(Direction currentDirection) {
            if (currentDirection.equals(UP)) return currentDirection;
            return DOWN;
        }
    },
    RIGHT {
        @Override
        public Direction checkNextMoveDirection(Direction currentDirection) {
            if (currentDirection.equals(LEFT)) return currentDirection;
            return RIGHT;
        }
    },
    LEFT {
        @Override
        public Direction checkNextMoveDirection(Direction currentDirection) {
            if (currentDirection.equals(RIGHT)) return currentDirection;
            return LEFT;
        }
    };

    public abstract Direction checkNextMoveDirection(Direction currentDirection);
}
