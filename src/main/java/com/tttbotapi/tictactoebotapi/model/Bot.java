package com.tttbotapi.tictactoebotapi.model;

import java.util.ArrayList;
import java.util.Random;


public class Bot {
    private String botSymbol;

    public String getBotSymbol (String player1Symbol){
        if(player1Symbol.equalsIgnoreCase("X")){
            return this.botSymbol ="O";
        }
        else if(player1Symbol.equalsIgnoreCase("O")){
            return this.botSymbol ="X";
        }
        else{
            return "Choose either X or O only";
        }
    }

    public ArrayList<ArrayList<String>> makeMove (Board board, String player1Symbol){
        this.botSymbol = getBotSymbol(player1Symbol);
        Random random = new Random();
        int row = random.nextInt(3); // generates a random number between 0 and 2
        int col = random.nextInt(3); // generates a random number between 0 and 2

        while (board.getBoard().get(row).get(col).equals(botSymbol) && board.getBoard().get(row).get(col).equals(player1Symbol)){
            row = random.nextInt(3);
            col = random.nextInt(3);
        }

        board.getBoard().get(row).set(col, botSymbol);

        return board.getBoard();
    }
}
