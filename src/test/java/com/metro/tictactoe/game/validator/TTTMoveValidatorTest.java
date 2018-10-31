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

import com.metro.game.Move;
import com.metro.game.Validator;
import com.metro.game.player.Player;
import com.metro.game.player.PlayerType;
import com.metro.tictactoe.game.SimpleBoard;
import com.metro.tictactoe.game.TTTMove;
import com.metro.tictactoe.game.player.Mark;
import com.metro.tictactoe.game.player.TTTPlayerFactory;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mga on 10/31/18.
 */
public class TTTMoveValidatorTest {

    @Test
    public void validateSuccessScenarios() {

        SimpleBoard simpleBoard = new SimpleBoard(3);

        Validator<Move<Mark>> validator = new TTTMoveValidator(simpleBoard);

        Player player = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.CROSS);

        Move move = new TTTMove(0, 0, player);

        assertTrue(validator.validate(move));

        move = new TTTMove(2, 2, player);

        assertTrue(validator.validate(move));

        move = new TTTMove(2, 1, player);

        assertTrue(validator.validate(move));

    }

    @Test
    public void validateFailScenarios() {

        SimpleBoard simpleBoard = new SimpleBoard(3);

        Validator<Move<Mark>> validator = new TTTMoveValidator(simpleBoard);

        Player player = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.CROSS);

        Move move = new TTTMove(10, -1, player);

        assertFalse(validator.validate(move));

        move = new TTTMove(0, 4, player);

        assertFalse(validator.validate(move));

        move = new TTTMove(4, 0, player);

        assertFalse(validator.validate(move));

        move = new TTTMove(3, -1, player);

        assertFalse(validator.validate(move));

    }
}