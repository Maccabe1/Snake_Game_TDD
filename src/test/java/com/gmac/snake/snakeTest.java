package com.gmac.snake;

import javafx.geometry.Point2D;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;


public class snakeTest {

    @Test
    public void snakeMovesInAllDirections() {
        Snake snake = new Snake(new Point2D(0, 0));

        for (Direction direction : Direction.values()) {
            Point2D oldPosition = snake.getPosition();
            snake.setDirection(direction);
            snake.update();
            assertThat(snake.getPosition(), is(oldPosition.add(direction.vector)));
        }
    }

    @Test
    public void snakeCanEatFood() {
        Snake snake = new Snake(new Point2D(10, 5));
        Food food = new Food(new Point2D(10, 5));
        assertTrue(snake.isCollidingWith(food));

    }
}

