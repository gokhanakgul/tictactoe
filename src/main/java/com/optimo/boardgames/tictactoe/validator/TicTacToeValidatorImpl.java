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

import com.optimo.boardgames.Action;
import com.optimo.boardgames.Board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by mga on 11/8/18.
 */

public class TicTacToeValidatorImpl implements TicTacToeValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToeValidatorImpl.class);

    private final Board board;

    public TicTacToeValidatorImpl(Board board) {
        this.board = board;
    }

    @Override
    public Result validate(Action move) {

        LOGGER.debug(String.format("Validation move for %s , coordinates col : %d ,row : %d ", move.getPlayer(), move.getCoordinate().getCol(), move.getCoordinate().getRow()));
        if (validateColumn(move) || validateRow(move) || validateDiagonal(move) || validateReverseDiagonal(move))
            return Result.WIN;

        if (!board.hasSpace())
            return Result.FINISHED;

        return Result.CONTINUE;
    }

    /**
     * Validation for column directions for specific move
     */
    private boolean validateColumn(Action move) {
        LOGGER.debug("Validation for Column");

        List<Action> moves = new ArrayList<>();
        for (int row = 0; row < this.board.getSize(); row++) {

            Action cnd = this.board.get(move.getCoordinate().getCol(), row);
            if (cnd != null) {
                moves.add(cnd);
            } else {
                return false;
            }
        }

        return validateGroupedItem(moves);
    }

    /**
     * Validation for Row direction
     */
    private boolean validateRow(Action move) {
        LOGGER.debug("Validation for Row");

        List<Action> moves = new ArrayList<>();
        for (int col = 0; col < this.board.getSize(); col++) {

            Action cnd = this.board.get(col, move.getCoordinate().getRow());
            if (cnd != null) {
                moves.add(cnd);
            } else {
                return false;
            }
        }

        return validateGroupedItem(moves);
    }

    /**
     * Checks a move is available too check diagonal direction validation
     */
    private boolean validateDiagonal(Action move) {
        LOGGER.debug("Checking for Diagonal");

        if (move.getCoordinate().getRow() != move.getCoordinate().getCol())
            return false;


        LOGGER.debug("Validation for Diagonal");

        List<Action> moves = new ArrayList<>();
        for (int col = 0; col < this.board.getSize(); col++) {

            Action cnd = this.board.get(col, col);
            if (cnd != null) {
                moves.add(cnd);
            } else {
                return false;
            }
        }

        return validateGroupedItem(moves);

    }

    private boolean validateReverseDiagonal(Action move) {
        LOGGER.debug("Checking for Reverse Diagonal");

        if (this.board.getSize() != move.getCoordinate().getRow() + move.getCoordinate().getCol() + 1)
            return false;

        LOGGER.debug("Validation for Reverse Diagonal");
        List<Action> moves = new ArrayList<>();
        for (int col = 0; col < this.board.getSize(); col++) {

            Action cnd = this.board.get(col, this.board.getSize() - (col + 1));
            if (cnd != null) {
                moves.add(cnd);
            } else {
                return false;
            }
        }

        return validateGroupedItem(moves);

    }

    /**
     * Check Win Scenarios for groped moves
     *
     * @param moveColList includes moves for a direction .
     * @return specify succes or fail.
     */
    private boolean validateGroupedItem(List<Action> moveColList) {
        final Stream<Long> longStream = moveColList
                .stream()
                .collect(Collectors.groupingBy(Action::getStone, Collectors.counting()))
                .values()
                .stream()
                .filter(aLong -> aLong.intValue() == this.board.getSize());


        //final Stream<Long> longStream = collect.values().stream();
        return longStream.count() == 1;

    }
}
