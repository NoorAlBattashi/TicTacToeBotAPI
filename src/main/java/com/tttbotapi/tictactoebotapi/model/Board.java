package com.tttbotapi.tictactoebotapi.model;

import java.util.ArrayList;

public class Board {
    public ArrayList<ArrayList<String>> ticTacToe = new ArrayList<ArrayList<String>>();

    public ArrayList<ArrayList<String>> getBoard() {
        return this.ticTacToe;
    }

    public void setBoard(ArrayList<ArrayList<String>> board) {
        try {
            this.ticTacToe = board;
        } catch (Exception e) {
            System.out.println("Error occurred while setting the board: " + e.getMessage());
        }
    }


    public String checkWinner(ArrayList<ArrayList<String>> board) {
        if (board == null) {
            throw new IllegalArgumentException("Board cannot be null");
        }

        if (board.size() != 3 || board.get(0).size() != 3 || board.get(1).size() != 3 || board.get(2).size() != 3) {
            throw new IllegalArgumentException("Invalid board size");
        }

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board.get(i).get(0).equals(board.get(i).get(1)) &&
                    board.get(i).get(1).equals(board.get(i).get(2))) {
                return board.get(i).get(0) + " You Win";
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board.get(0).get(i).equals(board.get(1).get(i)) &&
                    board.get(1).get(i).equals(board.get(2).get(i))) {
                return board.get(0).get(i) + " You Win";
            }
        }

        // Check diagonals
        if (board.get(0).get(0).equals(board.get(1).get(1)) &&
                board.get(1).get(1).equals(board.get(2).get(2))) {
            return board.get(0).get(0) + " You Win";
        }
        if (board.get(0).get(2).equals(board.get(1).get(1)) &&
                board.get(1).get(1).equals(board.get(2).get(0))) {
            return board.get(0).get(2) + " You Win";
        }

        // If no winner, check for draw
        boolean draw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.get(i).get(j).equals("")) {
                    draw = false;
                    break;
                }
            }
            if (!draw) {
                break;
            }
        }
        if (draw) {
            return "Draw";
        }

        // If no winner and no draw, return null
        return null;
    }

    public static boolean isPositionAvailable(Board board, int row, int col) {
        try {
            // check if position is already taken
            if (board.getBoard().get(row).get(col).equals("X") || board.getBoard().get(row).get(col).equals("O")) {
                return false;
            }

            // position is available
            return true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: invalid row or column value.");
            return false;
        } catch (Exception e) {
            System.out.println("An error occurred while checking if the position is available: " + e.getMessage());
            return false;
        }
    }
}

