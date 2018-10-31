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
import com.metro.game.Result;
import com.metro.game.player.Player;
import com.metro.game.player.PlayerType;
import com.metro.tictactoe.game.player.Mark;
import com.metro.tictactoe.game.player.TTTPlayerFactory;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mga on 10/30/18.
 */
public class TTTBoardWinValidationTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TTTBoardWinValidationTest.class);

    @Test
    public void boardValidatorScenarioDiagonal() {
        LOGGER.debug("------------------------------------------------");
        LOGGER.debug("Scenario : boardValidatorScenarioDiagonal");
        Board board = new TTTBoard(3);

        final Player player1 = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.CROSS);
        //final Player player2 = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.NOUGHT);

        Assert.assertEquals(board.set(new TTTMove(0, 0, player1)), Result.CONTINUE);
        board.render();
        Assert.assertEquals(board.set(new TTTMove(1, 1, player1)), Result.CONTINUE);
        board.render();
        Assert.assertEquals(board.set(new TTTMove(2, 2, player1)), Result.WIN);
        board.render();

    }

    @Test
    public void boardValidatorScenarioReverseDiagonal() {
        LOGGER.debug("------------------------------------------------");
        LOGGER.debug("Scenario : boardValidatorScenarioReverseDiagonal");
        Board board = new TTTBoard(3);
        final Player player1 = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.CROSS);
        //final Player player2 = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.NOUGHT);

        Assert.assertEquals(board.set(new TTTMove(0, 2, player1)), Result.CONTINUE);
        board.render();
        Assert.assertEquals(board.set(new TTTMove(1, 1, player1)), Result.CONTINUE);
        board.render();
        Assert.assertEquals(board.set(new TTTMove(2, 0, player1)), Result.WIN);

    }


    @Test
    public void boardValidatorScenarioCol() {
        LOGGER.debug("------------------------------------------------");
        LOGGER.debug("Scenario : boardValidatorScenarioCol");
        Board board = new TTTBoard(3);
        final Player player1 = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.CROSS);
        //final Player player2 = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.NOUGHT);

        Assert.assertEquals(board.set(new TTTMove(0, 0, player1)), Result.CONTINUE);
        board.render();
        Assert.assertEquals(board.set(new TTTMove(1, 0, player1)), Result.CONTINUE);
        board.render();
        Assert.assertEquals(board.set(new TTTMove(2, 0, player1)), Result.WIN);

    }


    @Test
    public void boardValidatorScenarioRow() {
        LOGGER.debug("------------------------------------------------");
        LOGGER.debug("Scenario : boardValidatorScenarioRow");

        Board board = new TTTBoard(3);
        final Player player1 = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.CROSS);
        //final Player player2 = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.NOUGHT);

        Assert.assertEquals(board.set(new TTTMove(0, 0, player1)), Result.CONTINUE);
        board.render();
        Assert.assertEquals(board.set(new TTTMove(0, 1, player1)), Result.CONTINUE);
        board.render();
        Assert.assertEquals(board.set(new TTTMove(0, 2, player1)), Result.WIN);

    }
}