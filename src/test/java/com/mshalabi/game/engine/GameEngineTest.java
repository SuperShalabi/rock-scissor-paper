package com.mshalabi.game.engine;

import com.mshalabi.game.model.GameRules;
import com.mshalabi.game.model.Hand;
import com.mshalabi.game.model.Player;
import com.mshalabi.game.model.Winner;
import com.mshalabi.game.strategy.impl.PaperPlayerStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameEngineTest {

    private static final int ROUNDS = 3;
    GameEngine gameEngine;

    @Before
    public void setUp() {
        GameRules gameRules = new GameRules();
        gameRules.addRule(Hand.ROCK, Hand.ROCK, Winner.TIE);
        gameRules.addRule(Hand.ROCK, Hand.SCISSOR, Winner.FIRST);
        gameRules.addRule(Hand.ROCK, Hand.PAPER, Winner.SECOND);
        gameRules.addRule(Hand.SCISSOR, Hand.ROCK, Winner.SECOND);
        gameRules.addRule(Hand.SCISSOR, Hand.SCISSOR, Winner.TIE);
        gameRules.addRule(Hand.SCISSOR, Hand.PAPER, Winner.FIRST);
        gameRules.addRule(Hand.PAPER, Hand.ROCK, Winner.FIRST);
        gameRules.addRule(Hand.PAPER, Hand.SCISSOR, Winner.SECOND);
        gameRules.addRule(Hand.PAPER, Hand.PAPER, Winner.TIE);

        gameEngine = new GameEngine(gameRules, ROUNDS, new Player("Player A", new PaperPlayerStrategy()),
                new Player("Player B", new PaperPlayerStrategy()));
    }

    @Test
    public void startGame() {
        gameEngine.startGame();

        assertEquals(ROUNDS, gameEngine.getPlayerAWins() + gameEngine.getPlayerBWins() + gameEngine.getTies());
    }
}