package com.mshalabi.game;

import com.mshalabi.game.engine.GameEngine;
import com.mshalabi.game.model.GameRules;
import com.mshalabi.game.model.Winner;
import com.mshalabi.game.strategy.impl.RandomPlayerStrategy;
import com.mshalabi.game.model.Hand;
import com.mshalabi.game.model.Player;
import com.mshalabi.game.strategy.impl.PaperPlayerStrategy;

public class Main {
    private static final int ROUNDS = 100;

    public static void main(String[] args) {
        int rounds = ROUNDS;

        if(args.length > 0) {
            try {
                rounds = Integer.parseInt(args[0]);
                if (rounds <= 0) {
                    System.err.printf("Invalid value for rounds. Got: %s expected a positive integer", args[0]);
                    return;
                }
            } catch (Exception e) {
                System.err.printf("Invalid value for rounds. Got: %s expected an integer", args[0]);
                return;
            }
        }

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

        Player playerA = new Player("Player A", new PaperPlayerStrategy());
        Player playerB = new Player("Player B", new RandomPlayerStrategy());

        GameEngine engine = new GameEngine(gameRules, rounds, playerA, playerB);

        engine.startGame();

        System.out.println(String.format("%s wins %d of %d games\n%s wins %d of %d games\nTie: %d of %d games\n",
                playerA.getName(), engine.getPlayerAWins(), rounds, playerB.getName(), engine.getPlayerBWins(), rounds, engine.getTies(), rounds));
    }
}
