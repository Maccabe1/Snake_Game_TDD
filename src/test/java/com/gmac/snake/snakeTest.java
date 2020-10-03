package com.gmac.snake;

import javafx.geometry.Point2D;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
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

    @Test
    public void snakeIsOutOfBounds() {
        Snake snake = new Snake(new Point2D(25, 0));
        assertTrue(snake.isOutOfBounds(24));
        assertFalse(snake.isOutOfBounds(25));
    }

    @Test
    public void snakeIsDead() {
        Snake snake = new Snake(new Point2D(25, 0));

        for(int i = 0; i < 5; i++) {
            snake.setDirection(Direction.RIGHT);
            snake.update();
            snake.grow();
        }

        snake.setDirection(Direction.UP);
        snake.update();

        snake.setDirection(Direction.DOWN);
        snake.update();

        snake.setDirection(Direction.LEFT);
        snake.update();

        assertTrue(snake.isDead());
    }
}

