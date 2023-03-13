package com.tttbotapi.tictactoebotapi.controller;

import com.tttbotapi.tictactoebotapi.model.Board;
import com.tttbotapi.tictactoebotapi.model.Bot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * This class serves as a REST API controller for Tic Tac Toe game.
 * <p>
 * It exposes endpoints to play the game by receiving the symbol of the player
 * <p>
 * with the board and responding with the current board with the bot move and game status.
 *
 * @RestController - Indicates that this class is a REST controller.
 * @RequestMapping(path = "/api") - Specifies the base URI path for the controller's endpoints.
 */
@RestController
@RequestMapping(path = "/api")
public class BotController {
    // Instance variables to store the Bot and Board objects.
    private Bot bot = new Bot();
    public Board board = new Board();

    /**
     * Endpoint to receive a symbol and board from a player
     * and return the current board with the bot move and game status.
     *
     * @param symbol    - The symbol of the player.
     * @param ticTacToe - The board of the game.
     * @return A ResponseEntity with the current board with the bot move and game status.
     */
    @PostMapping(path = "/{symbol}")
    public ResponseEntity<?> play(
            @PathVariable(name = "symbol") String symbol,
            @RequestBody Board ticTacToe
    ) {
        try {
            // Validate the player's symbol.
            if (symbol.length() != 1) {
                throw new IllegalArgumentException("Invalid symbol");
            }
            // Make a move on the board using the Bot object.
            board.setBoard(bot.makeMove(ticTacToe, symbol));
            // Create a HashMap object to store the board and game status.
            HashMap<String, Object> game = new HashMap<>();
            game.put("Board", board.getBoard());
            game.put("Game Status", board.gameStatus(board.getBoard()));
            return ResponseEntity.ok(game);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

