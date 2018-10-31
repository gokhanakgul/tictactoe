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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by mga on 10/29/18.
 */

public class TTTWinValidator implements Validator<Move<Mark>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTWinValidator.class);

    private final Board<Move<Mark>> board;

    public TTTWinValidator(Board<Move<Mark>> board) {
        this.board = board;
    }


    /**
     * Validation for latest move happen on board
     * The Win Validation algoritm will not search all over the board .
     * It is only checking neccesary posibilities against latest move.
     *
     * @param move
     * @return
     */
    @Override
    public boolean validate(Move<Mark> move) {
        LOGGER.debug(String.format("Validation move for %s , coordinates col : %d ,row : %d ", move.getPlayer(), move.getCol(), move.getRow()));
        return validateColumn(move) || validateRow(move) || validateDiagonal(move) || validateReverDiagonal(move);
    }

    /**
     * Validation for column directions for specific move
     */
    private boolean validateColumn(Move<Mark> move) {
        LOGGER.debug("Validation for Column");

        List<Move<Mark>> moves = new ArrayList<>();
        for (int row = 0; row < this.board.getSize(); row++) {

            Move<Mark> cnd = this.board.get(move.getCol(), row);
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
    private boolean validateRow(Move move) {
        LOGGER.debug("Validation for Row");

        List<Move<Mark>> moves = new ArrayList<>();
        for (int col = 0; col < this.board.getSize(); col++) {

            Move<Mark> cnd = this.board.get(col, move.getRow());
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
    private boolean validateDiagonal(Move<Mark> move) {
        LOGGER.debug("Checking for Diagonal");

        if (move.getRow() != move.getCol())
            return false;


        LOGGER.debug("Validation for Diagonal");

        List<Move<Mark>> moves = new ArrayList<>();
        for (int col = 0; col < this.board.getSize(); col++) {

            Move<Mark> cnd = this.board.get(col, col);
            if (cnd != null) {
                moves.add(cnd);
            } else {
                return false;
            }
        }

        return validateGroupedItem(moves);

    }

    private boolean validateReverDiagonal(Move<Mark> move) {
        LOGGER.debug("Checking for Reverse Diagonal");

        if (this.board.getSize() != move.getRow() + move.getCol() + 1)
            return false;

        LOGGER.debug("Validation for Reverse Diagonal");
        List<Move<Mark>> moves = new ArrayList<>();
        for (int col = 0; col < this.board.getSize(); col++) {

            Move<Mark> cnd = this.board.get(col, this.board.getSize() - (col + 1));
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
    private boolean validateGroupedItem(List<Move<Mark>> moveColList) {
        final Map<Mark, List<Move<Mark>>> gropedItem = moveColList.stream().collect(Collectors.groupingBy(Move<Mark>::getValue));

        for (Mark mark : gropedItem.keySet()) {
            final List<Move<Mark>> moves = gropedItem.get(mark);
            if (moves.size() == this.board.getSize()) {
                return true;
            }
        }
        return false;
    }

}