package com.tttbotapi.tictactoebotapi.controller;

import com.tttbotapi.tictactoebotapi.model.Board;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class BotController {
    @PutMapping(path = "/{symbol}")
    public Board getInfo(@PathVariable(name = "symbol") String symbol, @RequestBody Board inputBoard) {
        return ;
    }
}
