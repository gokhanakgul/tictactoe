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

package com.metro.tictactoe.game;

import com.metro.game.Board;
import com.metro.game.Move;
import com.metro.game.Render;
import com.metro.game.Result;
import com.metro.tictactoe.game.player.Mark;
import com.metro.tictactoe.game.utils.PrintStreamRender;
import com.metro.tictactoe.game.validator.TTTMoveValidator;
import com.metro.tictactoe.game.validator.TTTWinValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by mga on 10/29/18.
 */

public class TTTBoard extends AbstractBoard {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTBoard.class);

    private final TTTMoveValidator validator;

    private final TTTWinValidator winValidator;

    private final Render<String, Board<Move<Mark>>> render;

    public TTTBoard(int size) {
        super(size);

        this.render = new PrintStreamRender(System.out);

        this.validator = new TTTMoveValidator(this);

        this.winValidator = new TTTWinValidator(this);

    }

    @Override
    public void render() {
        this.render.render(this);
    }

    @Override
    public Result set(Move<Mark> move) {

        try {
            if (!validator.validate(move))
                return Result.RETRY;

            this.board[move.getCol()][move.getRow()] = move;
            availableCells.remove(getIndexFromCoordiate(getSize(), move.getCol(), move.getRow()));

            if (this.winValidator.validate(move)) {
                return Result.WIN;
            }

            if (getAvailableCellCount() == 0)
                return Result.FINISHED;

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            return Result.EXCEPTION;
        }

        return Result.CONTINUE;
    }

    @Override
    public String toString() {
        return "TTTBoard{" +
                "size=" + getSize() +
                ", board=" + Arrays.toString(board) +
                ", validator=" + validator +
                ", availableCells=" + availableCells +
                '}';
    }
}