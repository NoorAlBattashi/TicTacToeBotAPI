package com.tttbotapi.tictactoebotapi.controller;

import com.tttbotapi.tictactoebotapi.model.Board;
import com.tttbotapi.tictactoebotapi.model.Bot;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api")
public class BotController {
    private Bot bot = new Bot();
    public Board board = new Board();
    public static String player1Symbol;

    @PostMapping(path = "/setting/{symbol}")
    public ArrayList<ArrayList<String>> setSetting(@PathVariable(name = "symbol") String symbol,
                              @RequestBody Board ticTacToe) {
        player1Symbol = symbol;
        bot.getBotSymbol(symbol);
        board.setBoard(ticTacToe);
        return board.getBoard();
       // return bot.makeMove(ticTacToe,symbol);
    }

    @GetMapping(path = "/board")
    public ArrayList<ArrayList<String>> play() {

        return bot.makeMove(board,player1Symbol);
    }

}
