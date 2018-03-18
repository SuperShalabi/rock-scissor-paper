package com.mshalabi.game.engine;

import com.mshalabi.game.model.GameRules;
import com.mshalabi.game.model.Hand;
import com.mshalabi.game.model.Player;
import com.mshalabi.game.model.Winner;

public class GameEngine {
    private GameRules gameRules;

    private Player playerA;
    private Player playerB;
    private int rounds;

    private int playerAWins;
    private int playerBWins;
    private int ties;

    public GameEngine(GameRules gameRules, int rounds, Player playerA, Player playerB) {
        this.gameRules = gameRules;
        this.rounds = rounds;
        this.playerA = playerA;
        this.playerB = playerB;

        playerAWins = 0;
        playerBWins = 0;
        ties = 0;
    }

    public void startGame() {
        for (int i = 0; i < rounds; i++) {
            Hand hand1 = playerA.chooseHand();
            Hand hand2 = playerB.chooseHand();

            Winner winner = gameRules.rule(hand1, hand2);
            switch (winner) {

                case TIE:
                    ties ++;
                    break;
                case FIRST:
                    playerAWins ++;
                    break;
                case SECOND:
                    playerBWins ++;
                    break;
            }
        }
    }

    public int getPlayerAWins() {
        return playerAWins;
    }

    public int getPlayerBWins() {
        return playerBWins;
    }

    public int getTies() {
        return ties;
    }
}
