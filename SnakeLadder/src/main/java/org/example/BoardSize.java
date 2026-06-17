package org.example;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BoardSize {

    private Dice dice;
    private List<JUMPER> snake;
    private List<JUMPER> ladder;
    private Queue<Player> nextTurn;
    private Map<String, Integer> position;
    private int boardSize;

    public BoardSize(
            Dice dice,
            List<JUMPER> snake,
            List<JUMPER> ladder,
            Queue<Player> nextTurn,
            Map<String, Integer> position,
            int boardSize) {

        this.dice = dice;
        this.snake = snake;
        this.ladder = ladder;
        this.nextTurn = nextTurn;
        this.position = position;
        this.boardSize = boardSize;
    }

    public void startGame() {

        while (true) {

            Player currentPlayer = nextTurn.poll();

            int currentPosition =
                    position.get(currentPlayer.getPlayerName());

            int diceRoll = dice.rollDice();

            System.out.println(
                    currentPlayer.getPlayerName()
                            + " rolled a "
                            + diceRoll);

            int nextCell = currentPosition + diceRoll;

            // Cannot move beyond board
            if (nextCell > boardSize) {

                System.out.println(
                        currentPlayer.getPlayerName()
                                + " cannot move beyond "
                                + boardSize);

                nextTurn.offer(currentPlayer);
                continue;
            }

            int finalPosition = nextCell;

            // Check snake
            for (JUMPER s : snake) {

                if (s.startPoint == nextCell) {

                    System.out.println(
                            currentPlayer.getPlayerName()
                                    + " bitten by snake at "
                                    + nextCell);

                    finalPosition = s.endPoint;
                    break;
                }
            }

            // Check ladder
            for (JUMPER l : ladder) {

                if (l.startPoint == nextCell) {

                    System.out.println(
                            currentPlayer.getPlayerName()
                                    + " climbed ladder at "
                                    + nextCell);

                    finalPosition = l.endPoint;
                    break;
                }
            }

            // Winner check
            if (finalPosition == boardSize) {

                System.out.println(
                        currentPlayer.getPlayerName()
                                + " won the game!");

                break;
            }

            // Update position
            position.put(
                    currentPlayer.getPlayerName(),
                    finalPosition);

            System.out.println(
                    currentPlayer.getPlayerName()
                            + " moved to position "
                            + finalPosition);

            // Add player back to queue
            nextTurn.offer(currentPlayer);
        }
    }
}