package com.mshalabi.game.strategy.impl;

import com.mshalabi.game.model.Hand;
import com.mshalabi.game.strategy.PlayerStrategy;

public class RandomPlayerStrategy implements PlayerStrategy {
    private static final Hand[] HANDS = new Hand[]{Hand.PAPER, Hand.ROCK, Hand.SCISSOR};

    @Override
    public Hand chooseHand() {
        return HANDS[(int) (Math.random() * HANDS.length)];
    }
}
