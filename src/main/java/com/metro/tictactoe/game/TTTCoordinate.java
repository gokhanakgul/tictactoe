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

import com.metro.game.Coordinate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


/**
 * Created by mga on 10/30/18.
 */
public class TTTCoordinate implements Coordinate {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTCoordinate.class);

    protected final int col;
    protected final int row;

    public TTTCoordinate(int col, int row) {
        this.col = col;
        this.row = row;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public boolean validate(int length) {
        return isBoardRange(length,col) && isBoardRange(length,row);
    }

    private boolean isBoardRange(int boardLength, int candidate) {
        return (candidate >= 0 && boardLength > candidate );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TTTCoordinate that = (TTTCoordinate) o;
        return col == that.col &&
                row == that.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(col, row);
    }

    @Override
    public String toString() {
        return "TTTCoordinate{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }
}
