package com.mshalabi.game.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameRules {
    private Map<GameHand, Winner> rules;

    public GameRules() {
        this.rules = new HashMap<>();
    }

    public GameRules(Map<GameHand, Winner> rules) {
        this();
        this.addRules(rules);
    }

    public void addRules(Map<GameHand, Winner> rules) {
        this.rules.putAll(rules);
    }

    public void addRule(Hand hand1, Hand hand2, Winner winner) {
        this.rules.put(new GameHand(hand1, hand2), winner);
    }

    public Winner rule(Hand hand1, Hand hand2) {
        return this.rules.get(new GameHand(hand1, hand2));
    }

    static class GameHand {
        private Hand hand1;
        private Hand hand2;

        public GameHand(Hand hand1, Hand hand2) {
            this.hand1 = hand1;
            this.hand2 = hand2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GameHand gameHand = (GameHand) o;
            return hand1 == gameHand.hand1 &&
                    hand2 == gameHand.hand2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(hand1, hand2);
        }
    }
}
