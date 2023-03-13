package com.tttbotapi.tictactoebotapi.model;

import java.util.ArrayList;
import java.util.Random;


public class Bot {
    private String botSymbol;
    private Board board;
    /**

     Gets the bot symbol that is different from the player 1 symbol.
     @param player1Symbol The symbol of player 1.
     @return The bot symbol.
     @throws IllegalArgumentException If the player 1 symbol is neither "X" nor "O".
     */
    public String getBotSymbol(String player1Symbol) throws IllegalArgumentException {
        if (player1Symbol.equalsIgnoreCase("X")) {
            this.botSymbol = "O";
            return this.botSymbol;
        } else if (player1Symbol.equalsIgnoreCase("O")) {
            this.botSymbol = "X";
            return this.botSymbol;
        } else {
            throw new IllegalArgumentException("Choose either X or O only");
        }
    }

    /**

     This method is responsible for making a move by the bot on the given board.
     @param board the current state of the board
     @param player1Symbol the symbol used by player1
     @return the updated state of the board after bot's move
     @throws Exception if there is an error while setting bot's position on the board
     */
    public ArrayList<ArrayList<String>> makeMove(Board board, String player1Symbol) throws Exception {
        this.botSymbol = getBotSymbol(player1Symbol);
        Random random = new Random();
        int row = random.nextInt(3); // generates a random number between 0 and 2
        int col = random.nextInt(3); // generates a random number between 0 and 2

        while (!board.isPositionAvailable(board, row, col)) {
            row = random.nextInt(3);
            col = random.nextInt(3);
        }

        try {
            board.getBoard().get(row).set(col, botSymbol);
        } catch (Exception e) {
            throw new Exception("Error: Unable to set bot position.");
        }

        return board.getBoard();
    }
}
