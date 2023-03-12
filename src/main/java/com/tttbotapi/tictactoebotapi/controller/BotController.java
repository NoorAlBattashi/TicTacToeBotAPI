package com.tttbotapi.tictactoebotapi.controller;

import com.tttbotapi.tictactoebotapi.model.Board;
import com.tttbotapi.tictactoebotapi.model.Bot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/api")
public class BotController {
    private Bot bot = new Bot();
    public Board board = new Board();

    @PostMapping(path = "/{symbol}")
    public ResponseEntity <?> play(
            @PathVariable(name = "symbol") String symbol,
            @RequestBody Board ticTacToe
    ) {
        try {
            if (symbol.length() != 1) {
                throw new IllegalArgumentException("Invalid symbol");
            }

            board.setBoard(bot.makeMove(ticTacToe, symbol));
            HashMap<String, Object> game = new HashMap<>();
            game.put("Board", board.getBoard());
            game.put("Game Status", board.checkWinner(board.getBoard()));
            return ResponseEntity.ok(game);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    }

