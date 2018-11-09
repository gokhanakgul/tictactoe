/*
 * Project : tictactoe.
 *
 * Copyright (C) 2018 mga.
 *
 * This file is part of tictactoe.
 *
 * tictactoe is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * tictactoe is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with tictactoe. If not, see <http://www.gnu.org/licenses/>.
 */

package com.optimo.boardgames.tictactoe.scene;

import com.optimo.boardgames.Action;
import com.optimo.boardgames.Board;
import com.optimo.boardgames.Config;
import com.optimo.boardgames.Player;
import com.optimo.boardgames.Scene;
import com.optimo.boardgames.tictactoe.board.TicTacToeBoard;
import com.optimo.boardgames.tictactoe.render.BoardRender;
import com.optimo.boardgames.tictactoe.render.ConsoleManager;
import com.optimo.boardgames.tictactoe.validator.Result;
import com.optimo.boardgames.tictactoe.validator.TicTacToeValidator;
import com.optimo.boardgames.tictactoe.validator.TicTacToeValidatorImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by mga on 11/8/18.
 */

public class BoardGameScene implements Scene {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardGameScene.class);
    private final BoardRender boardRender;
    private final ConsoleManager consoleManager;
    private TicTacToeValidator validator;
    private Board board;

    public BoardGameScene(ConsoleManager consoleManager, BoardRender boardRender) {
        this.consoleManager = consoleManager;
        this.boardRender = boardRender;
    }

    private void init(Config config) {
        this.board = new TicTacToeBoard(config);
        this.validator = new TicTacToeValidatorImpl(board);
    }

    @Override
    public void run(Config config) {

        init(config);

        final List<Player> players = config.getPlayers();

        boolean turn = true;

        while (turn) {

            for (Player p : players) {

                consoleManager.println(boardRender.render(board));
                consoleManager.println(String.format(" %s turns !" , p.getName()));
                final Action action = p.play(board);

                consoleManager.println(String.format(" %s played %s on %s!" , p.getName(),action.getStone().getSymbol(),action.getCoordinate() .toString()));

                final Result validate = validator.validate(action);

                if (!Result.CONTINUE.equals(validate)) {
                    turn = false;

                    consoleManager.println(boardRender.render(board));

                    if (Result.WIN.equals(validate)) {
                        printWinnerMesage(action);
                    } else {
                        printFinishMesage();
                    }

                    break;
                }
            }

        }

    }

    private void printWinnerMesage(Action action) {
        consoleManager.println(String.format(" Game Won by %s ", action.getPlayer().getName()));
    }

    private void printFinishMesage() {
        consoleManager.println(" Game Over! ");
    }

}