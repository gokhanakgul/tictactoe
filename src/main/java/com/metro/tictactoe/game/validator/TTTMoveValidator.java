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

package com.metro.tictactoe.game.validator;

import com.metro.game.Board;
import com.metro.game.Move;
import com.metro.game.Validator;
import com.metro.tictactoe.game.player.Mark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by mga on 10/29/18.
 */

public class TTTMoveValidator implements Validator<Move<Mark>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTMoveValidator.class);

    private final Board board;

    public TTTMoveValidator(Board board) {
        this.board = board;
    }

    @Override
    public boolean validate(Move<Mark> move) {

        if (!board.isAvailable())
            return false;

        if (move == null)
            return false;

        if (move.getPlayer() == null)
            return false;

        if (!isBoardRange(board.getSize(), move.getCol()))
            return false;

        if (!isBoardRange(board.getSize(), move.getRow()))
            return false;

        return this.board.get(move.getCol(), move.getRow()) == null;
    }


    private boolean isBoardRange(int boardLength, int candidate) {
        return (boardLength > candidate && candidate >= 0) ;
    }


}