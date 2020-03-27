package core.model;

import core.presentation.ScreenParameters;

import static core.config.GameConfiguration.SQUARE_SIZE;

public enum Direction {
    UP {
        @Override
        public Direction validatedFor(Direction currentDirection) {
            return (currentDirection.equals(DOWN)) ? currentDirection : UP;
        }

        @Override
        public boolean isNextPositionInScreenScope(Position currentPosition) {
            return currentPosition.getAxisY() - SQUARE_SIZE >= 0;
        }

        @Override
        public Position newPositionAtScreenBeginning(Position currentPosition) {
            return new Position(currentPosition.getAxisX(), ScreenParameters.getInstance().height);
        }

        @Override
        public Position newPositionInsideScreenScope(Position currentPosition) {
            return new Position(currentPosition.getAxisX(), currentPosition.getAxisY() - SQUARE_SIZE);
        }

    },
    DOWN {
        @Override
        public Direction validatedFor(Direction currentDirection) {
            return (currentDirection.equals(UP)) ? currentDirection : DOWN;
        }

        @Override
        public boolean isNextPositionInScreenScope(Position currentPosition) {
            return currentPosition.getAxisY() + SQUARE_SIZE <= ScreenParameters.getInstance().height;

        }

        @Override
        public Position newPositionAtScreenBeginning(Position currentPosition) {
            return new Position(currentPosition.getAxisX(), 0);
        }

        @Override
        public Position newPositionInsideScreenScope(Position currentPosition) {
            return new Position(currentPosition.getAxisX(), currentPosition.getAxisY() + SQUARE_SIZE);
        }

    },
    RIGHT {
        @Override
        public Direction validatedFor(Direction currentDirection) {
            return (currentDirection.equals(LEFT)) ? currentDirection : RIGHT;
        }

        @Override
        public boolean isNextPositionInScreenScope(Position currentPosition) {
            return currentPosition.getAxisX() + SQUARE_SIZE <= ScreenParameters.getInstance().width;
        }

        @Override
        public Position newPositionAtScreenBeginning(Position currentPosition) {
            return new Position(0, currentPosition.getAxisY());
        }

        @Override
        public Position newPositionInsideScreenScope(Position currentPosition) {
            return new Position(currentPosition.getAxisX() + SQUARE_SIZE, currentPosition.getAxisY());
        }
    },
    LEFT {
        @Override
        public Direction validatedFor(Direction currentDirection) {
            return (currentDirection.equals(RIGHT)) ? currentDirection : LEFT;
        }

        @Override
        public boolean isNextPositionInScreenScope(Position currentPosition) {
            return currentPosition.getAxisX() + SQUARE_SIZE >= 0;
        }

        @Override
        public Position newPositionAtScreenBeginning(Position currentPosition) {
            return new Position(ScreenParameters.getInstance().width, currentPosition.getAxisY());
        }

        @Override
        public Position newPositionInsideScreenScope(Position currentPosition) {
            return new Position(currentPosition.getAxisX() - SQUARE_SIZE, currentPosition.getAxisY());
        }
    };

    public abstract Direction validatedFor(Direction currentDirection);

    public abstract boolean isNextPositionInScreenScope(Position currentPosition);

    public abstract Position newPositionAtScreenBeginning(Position currentPosition);

    public abstract Position newPositionInsideScreenScope(Position currentPosition);
}
