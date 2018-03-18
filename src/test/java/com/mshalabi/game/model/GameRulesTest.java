package com.mshalabi.game.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GameRulesTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Hand.SCISSOR, Hand.PAPER, Winner.FIRST},
                {Hand.SCISSOR, Hand.ROCK, Winner.SECOND},
                {Hand.SCISSOR, Hand.SCISSOR, Winner.TIE},
                {Hand.PAPER, Hand.PAPER, Winner.TIE},
                {Hand.PAPER, Hand.ROCK, Winner.FIRST},
                {Hand.PAPER, Hand.SCISSOR, Winner.SECOND},
                {Hand.ROCK, Hand.PAPER, Winner.SECOND},
                {Hand.ROCK, Hand.ROCK, Winner.TIE},
                {Hand.ROCK, Hand.SCISSOR, Winner.FIRST}
        });
    }

    private GameRules gameRules;

    @Before
    public void setUp() {
        gameRules = new GameRules();
        gameRules.addRule(Hand.ROCK, Hand.ROCK, Winner.TIE);
        gameRules.addRule(Hand.ROCK, Hand.SCISSOR, Winner.FIRST);
        gameRules.addRule(Hand.ROCK, Hand.PAPER, Winner.SECOND);
        gameRules.addRule(Hand.SCISSOR, Hand.ROCK, Winner.SECOND);
        gameRules.addRule(Hand.SCISSOR, Hand.SCISSOR, Winner.TIE);
        gameRules.addRule(Hand.SCISSOR, Hand.PAPER, Winner.FIRST);
        gameRules.addRule(Hand.PAPER, Hand.ROCK, Winner.FIRST);
        gameRules.addRule(Hand.PAPER, Hand.SCISSOR, Winner.SECOND);
        gameRules.addRule(Hand.PAPER, Hand.PAPER, Winner.TIE);
    }

    private Hand hand1, hand2;
    private Winner expected;

    public GameRulesTest(Hand hand1, Hand hand2, Winner expected) {
        this.hand1 = hand1;
        this.hand2 = hand2;
        this.expected = expected;
    }

    @Test
    public void testRule() {
        Winner winner = gameRules.rule(hand1, hand2);

        assertEquals(expected, winner);
    }
}
