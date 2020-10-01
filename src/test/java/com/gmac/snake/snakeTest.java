package com.gmac.snake;

import javafx.geometry.Point2D;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;


public class snakeTest {

    @Test
    public void snakeCanMoveInAllDirections() {
        Snake snake = new Snake(new Point2D(0, 0));

        for (Direction direction : Direction.values()) {
            Point2D oldPosition = snake.getHead();
            snake.setDirection(direction);
            snake.update();
            assertThat(snake.getHead(), is(oldPosition.add(direction.vector)));
        }
    }

    @Test
    public void snakeCanCollideWithFood() {
        Snake snake = new Snake(new Point2D(10, 5));
        Food food = new Food(new Point2D(10, 5));
        assertTrue(snake.isCollidingWith(food));
    }

    @Test
    public void snakeGrowsWhenItCollidesWithFood() {
        Snake snake = new Snake(new Point2D(0, 0));
        snake.setDirection(Direction.RIGHT);
        snake.update();
        snake.grow();

        assertThat(snake.getLength(), is(2));
        assertThat(snake.getBody(), hasItem(new Point2D(0, 0)));
    }
}

