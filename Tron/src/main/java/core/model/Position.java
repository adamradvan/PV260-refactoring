package core.model;

import java.util.Objects;

public class Position {
    private final int axisX;
    private final int axisY;

    public Position(int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    public int getAxisX() {
        return axisX;
    }

    public int getAxisY() {
        return axisY;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return axisX == position.axisX &&
                axisY == position.axisY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(axisX, axisY);
    }

    @Override
    public String toString() {
        return String.format("{%d, %d}", axisX, axisY);
    }
}
