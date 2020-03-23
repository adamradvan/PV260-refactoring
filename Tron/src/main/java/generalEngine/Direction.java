package generalEngine;

import tronModule.Position;
import tronModule.ScreenParameters;

import static tronModule.config.TronGameConfiguration.MOVE_AMOUNT;

public enum Direction {
    UP {
        @Override
        public Direction validatedFor(Direction currentDirection) {
            if (currentDirection.equals(DOWN)) return currentDirection;
            return UP;
        }

        @Override
        public boolean isNextPositionInScreenScope(Position currentPosition) {
            return currentPosition.getAxisY() - MOVE_AMOUNT >= 0;
        }

        @Override
        public Position newPositionAtScreenBeginning(Position currentPosition) {
            return new Position(currentPosition.getAxisX(), ScreenParameters.getInstance().height);
        }

        @Override
        public Position newPositionInsideScreenScope(Position currentPosition) {
            return new Position(currentPosition.getAxisX(), currentPosition.getAxisY() - MOVE_AMOUNT);
        }

    },
    DOWN {
        @Override
        public Direction validatedFor(Direction currentDirection) {
            if (currentDirection.equals(UP)) return currentDirection;
            return DOWN;
        }

        @Override
        public boolean isNextPositionInScreenScope(Position currentPosition) {
            return currentPosition.getAxisY() + MOVE_AMOUNT <= ScreenParameters.getInstance().height;

        }

        @Override
        public Position newPositionAtScreenBeginning(Position currentPosition) {
            return new Position(currentPosition.getAxisX(), 0);
        }

        @Override
        public Position newPositionInsideScreenScope(Position currentPosition) {
            return new Position(currentPosition.getAxisX(), currentPosition.getAxisY() + MOVE_AMOUNT);
        }

    },
    RIGHT {
        @Override
        public Direction validatedFor(Direction currentDirection) {
            if (currentDirection.equals(LEFT)) return currentDirection;
            return RIGHT;
        }

        @Override
        public boolean isNextPositionInScreenScope(Position currentPosition) {
            return currentPosition.getAxisX() + MOVE_AMOUNT <= ScreenParameters.getInstance().width;
        }

        @Override
        public Position newPositionAtScreenBeginning(Position currentPosition) {
            return new Position(0, currentPosition.getAxisY());
        }

        @Override
        public Position newPositionInsideScreenScope(Position currentPosition) {
            return new Position(currentPosition.getAxisX() + MOVE_AMOUNT, currentPosition.getAxisY());
        }
    },
    LEFT {
        @Override
        public Direction validatedFor(Direction currentDirection) {
            if (currentDirection.equals(RIGHT)) return currentDirection;
            return LEFT;
        }

        @Override
        public boolean isNextPositionInScreenScope(Position currentPosition) {
            return currentPosition.getAxisX() + MOVE_AMOUNT >= 0;
        }

        @Override
        public Position newPositionAtScreenBeginning(Position currentPosition) {
            return new Position(ScreenParameters.getInstance().width, currentPosition.getAxisY());
        }

        @Override
        public Position newPositionInsideScreenScope(Position currentPosition) {
            return new Position(currentPosition.getAxisX() - MOVE_AMOUNT, currentPosition.getAxisY());
        }
    };

    public abstract Direction validatedFor(Direction currentDirection);

    public abstract boolean isNextPositionInScreenScope(Position currentPosition);

    public abstract Position newPositionAtScreenBeginning(Position currentPosition);

    public abstract Position newPositionInsideScreenScope(Position currentPosition);
}
