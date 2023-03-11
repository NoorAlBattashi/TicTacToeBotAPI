package com.tttbotapi.tictactoebotapi.model;

import java.util.ArrayList;

public class Board {
    public ArrayList<ArrayList<String>> ticTacToe= new ArrayList<ArrayList<String>>();

    public ArrayList<ArrayList<String>> getBoard(){
       return this.ticTacToe;
    }

    public void setBoard(Board board){
         this.ticTacToe = board.ticTacToe;
    }
}
