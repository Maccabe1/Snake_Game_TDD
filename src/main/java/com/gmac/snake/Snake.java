package com.gmac.snake;

import javafx.geometry.Point2D;

public class Snake {
    private Direction direction;
    private Point2D position;

    public Snake(Point2D position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void update() {
        position = position.add(direction.vector);
    }

    public Object getPosition() {
        return position;
    }
}
