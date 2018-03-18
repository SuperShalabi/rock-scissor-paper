package com.mshalabi.game.model;

import com.mshalabi.game.strategy.PlayerStrategy;

public class Player {
    private String name;
    private PlayerStrategy playerStrategy;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, PlayerStrategy playerStrategy) {
        this(name);
        this.setPlayerStrategy(playerStrategy);
    }

    public String getName() {
        return name;
    }

    public void setPlayerStrategy(PlayerStrategy playerStrategy) {
        if (playerStrategy == null) {
            throw new IllegalArgumentException("PlayerStrategy can not be null.");
        }

        this.playerStrategy = playerStrategy;
    }

    public Hand chooseHand() {
        if (this.playerStrategy == null) {
            throw new IllegalStateException("PlayerStrategy must be initialized before playing.");
        }

        return this.playerStrategy.chooseHand();
    }
}
