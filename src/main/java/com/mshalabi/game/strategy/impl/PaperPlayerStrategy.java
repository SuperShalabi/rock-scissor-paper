package com.mshalabi.game.strategy.impl;

import com.mshalabi.game.model.Hand;
import com.mshalabi.game.strategy.PlayerStrategy;

public class PaperPlayerStrategy implements PlayerStrategy {
    @Override
    public Hand chooseHand() {
        return Hand.PAPER;
    }
}
