package core.model;

import java.awt.*;

import static core.config.GameConfiguration.SQUARE_SIZE;

public abstract class GameObjectImpl implements GameObject {
    protected Color color;
    protected Position position;

    public GameObjectImpl(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    @Override
    public void drawObject(Graphics2D graphics) {
        drawForPosition(position, graphics);
    }

    public Position getPosition() {
        return position;
    }

    protected void drawForPosition(Position position, Graphics2D graphics) {
        graphics.setColor(color);
        graphics.fillRect(position.getAxisX(), position.getAxisY(), SQUARE_SIZE, SQUARE_SIZE);
    }
}
