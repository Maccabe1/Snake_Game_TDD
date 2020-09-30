package com.gmac.snake;

import javafx.geometry.Point2D;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class snakeTest {
    @Test
    public void snakeMoves() {
        Snake snake = new Snake(new Point2D(0, 0));

        snake.setDirection(Direction.RIGHT);
        snake.update();
        assertThat(snake.getPosition(), is(new Point2D(1, 0)));
    }
}

