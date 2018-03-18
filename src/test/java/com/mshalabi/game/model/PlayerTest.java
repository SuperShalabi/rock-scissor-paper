package com.mshalabi.game.model;

import com.mshalabi.game.strategy.PlayerStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPlay() {
        StrategyMock strategy = new StrategyMock();

        Player player = new Player("Player 1", strategy);

        Hand hand = player.chooseHand();

        assertEquals(1, strategy.chooseHandCalled());
        assertEquals(Hand.PAPER, hand);
    }

    class StrategyMock implements PlayerStrategy {
        private int count = 0;

        int chooseHandCalled() {
            return count;
        }

        public Hand chooseHand() {
            count++;

            return Hand.PAPER;
        }
    }
}