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

package com.optimo.boardgames.tictactoe.validator;

import com.optimo.boardgames.Board;
import com.optimo.boardgames.Coordinate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by mga on 11/8/18.
 */

public class CoordinateValidatorImpl implements CoordinateValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoordinateValidatorImpl.class);

    private final Board board;

    public CoordinateValidatorImpl(Board board) {
        this.board = board;
    }

    @Override
    public Boolean validate(Coordinate coordinate) {
        return isBoardRange(this.board.getSize(), coordinate.getCol()) && isBoardRange(this.board.getSize(), coordinate.getRow()) && this.board.get(coordinate) == null;
    }

    private boolean isBoardRange(int boardLength, int candidate) {
        return (boardLength > candidate && candidate >= 0);
    }
}
