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

package com.optimo.boardgames.tictactoe.board;

import com.optimo.boardgames.Action;
import com.optimo.boardgames.Board;
import com.optimo.boardgames.Config;
import com.optimo.boardgames.Coordinate;
import com.optimo.boardgames.tictactoe.validator.CoordinateValidator;
import com.optimo.boardgames.tictactoe.validator.CoordinateValidatorImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by mga on 11/8/18.
 */

public class TicTacToeBoard implements Board {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToeBoard.class);

    private final int size;
    private final Action[] actions;
    private final CoordinateValidator validator;
    private List<Coordinate> availableCoordinates;

    public TicTacToeBoard(Config config) {
        this.size = config.getBoardSize();
        this.actions = new Action[size * size];
        this.validator = new CoordinateValidatorImpl(this);
        initAvailableCells();
    }

    private void initAvailableCells() {

        availableCoordinates = new ArrayList<>();

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                int index = coordinateToIndex(this.size, i, j);
                availableCoordinates.add(index, new CoordinateImpl(i, j));
            }
        }

    }

    private int coordinateToIndex(int length, int col, int row) {
        return (col * length) + row;
    }

    @Override
    public Action get(Coordinate coordinate) {
        return get(coordinate.getCol(), coordinate.getRow());
    }

    @Override
    public Action get(int X, int Y) {
        return actions[coordinateToIndex(this.size, X, Y)];
    }

    @Override
    public List<Coordinate> availables() {
        return Collections.unmodifiableList(availableCoordinates.stream().filter(Objects::nonNull).collect(Collectors.toList()));
    }

    @Override
    public boolean set(Action action) {
        if (validator.validate(action.getCoordinate())) {

            final int inxToBeNull = coordinateToIndex(this.size, action.getCoordinate().getCol(), action.getCoordinate().getRow());

            availableCoordinates.set(inxToBeNull, null);
            actions[inxToBeNull] = action;
            return true;
        }

        return false;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean hasSpace() {
        return availableCoordinates.stream().anyMatch(Objects::nonNull);
    }

}