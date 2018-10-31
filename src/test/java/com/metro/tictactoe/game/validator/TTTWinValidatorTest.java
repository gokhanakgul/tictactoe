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

import com.metro.game.Coordinate;
import com.metro.game.Move;
import com.metro.game.Validator;
import com.metro.game.player.Player;
import com.metro.game.player.PlayerType;
import com.metro.tictactoe.game.SimpleBoard;
import com.metro.tictactoe.game.TTTCoordinate;
import com.metro.tictactoe.game.TTTMove;
import com.metro.tictactoe.game.player.Mark;
import com.metro.tictactoe.game.player.TTTPlayerFactory;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by mga on 10/31/18.
 */
public class TTTWinValidatorTest {

    @Test
    public void validateCol() {
        Coordinate[] coordinates = {
                new TTTCoordinate(0, 0),
                new TTTCoordinate(0, 1),
                new TTTCoordinate(0, 2)};

        SimpleBoard simpleBoard = new SimpleBoard(3);

        Validator<Move<Mark>> validator = new TTTWinValidator(simpleBoard);

        final TTTMove<Mark> move = makeMovesOnBoard(simpleBoard, coordinates);

        assertTrue(validator.validate(move));
    }

    @Test
    public void validateRow() {

        Coordinate[] coordinates = {
                new TTTCoordinate(0, 0),
                new TTTCoordinate(1, 0),
                new TTTCoordinate(2, 0)};

        SimpleBoard simpleBoard = new SimpleBoard(3);

        Validator<Move<Mark>> validator = new TTTWinValidator(simpleBoard);

        final TTTMove<Mark> move = makeMovesOnBoard(simpleBoard, coordinates);

        assertTrue(validator.validate(move));

    }


    @Test
    public void validateDiagonal() {

        Coordinate[] coordinates = {
                new TTTCoordinate(0, 0),
                new TTTCoordinate(1, 1),
                new TTTCoordinate(2, 2)};

        SimpleBoard simpleBoard = new SimpleBoard(3);

        Validator<Move<Mark>> validator = new TTTWinValidator(simpleBoard);

        final TTTMove<Mark> move = makeMovesOnBoard(simpleBoard, coordinates);

        assertTrue(validator.validate(move));

    }

    @Test
    public void validateReverseDiagonal() {

        Coordinate[] coordinates = {
                new TTTCoordinate(0, 2),
                new TTTCoordinate(1, 1),
                new TTTCoordinate(2, 0)};

        SimpleBoard simpleBoard = new SimpleBoard(3);

        Validator<Move<Mark>> validator = new TTTWinValidator(simpleBoard);

        final TTTMove<Mark> move = makeMovesOnBoard(simpleBoard, coordinates);

        assertTrue(validator.validate(move));

    }

    private TTTMove<Mark> makeMovesOnBoard(SimpleBoard simpleBoard, Coordinate[] coordinates) {
        Player player = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.CROSS);

        simpleBoard.set(new TTTMove<Mark>(coordinates[0], player));
        simpleBoard.set(new TTTMove<Mark>(coordinates[1], player));
        final TTTMove<Mark> move = new TTTMove<Mark>(coordinates[2], player);
        simpleBoard.set(move);
        return move;
    }
}