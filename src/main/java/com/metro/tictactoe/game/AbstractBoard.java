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
import com.metro.game.Coordinate;
import com.metro.game.Move;
import com.metro.tictactoe.game.player.Mark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by mga on 10/31/18.
 */

public abstract class AbstractBoard implements Board<Move<Mark>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractBoard.class);

    private final int size;
    protected final Move<Mark>[][] board;
    protected Map<Integer, Coordinate> availableCells;

    public AbstractBoard(int size) {
        this.size = size;
        this.board = new Move[size][size];
        initAvailableCells();
    }

    protected void initAvailableCells() {

        availableCells = new HashMap<>();

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                int index = getIndexFromCoordiate(size, i, j);
                availableCells.put(index, new TTTCoordinate(i, j));
            }
        }
    }

    @Override
    public boolean isAvailable() {
        return availableCells.size() > 0;
    }

    @Override
    public List<Coordinate> getAvailableCellCoordinates() {
        return Collections.unmodifiableList(new ArrayList<>(availableCells.values()));
    }

    @Override
    public Move<Mark> get(int col, int row) {
        return this.board[col][row];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getAvailableCellCount() {
        return this.availableCells.size();
    }

    protected int getIndexFromCoordiate(int length, int col, int row) {
        return (col * length) + row;
    }
}
