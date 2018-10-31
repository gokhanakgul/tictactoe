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
import com.metro.game.Move;
import com.metro.tictactoe.game.player.Mark;
import com.metro.tictactoe.game.player.TTTHumanPlayer;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by mga on 10/29/18.
 */
public class TTTBoardTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTBoardTest.class);


    @Test
    public void checkCandidates() {
        Board<Move<Mark>> tttBoard = new TTTBoard(6);

        tttBoard.getAvailableCellCoordinates().forEach(coordinate -> {
            System.out.println(coordinate.toString());
            assertTrue(tttBoard.getSize() > coordinate.getRow());
            assertTrue(tttBoard.getSize() > coordinate.getCol());
        });
    }


    @Test
    public void initBoard() {

        Board<Move<Mark>> tttBoard = new TTTBoard(6);

        assertEquals(36, tttBoard.getAvailableCellCount());

        final String s = tttBoard.toString();

        System.out.println(s);
    }

    @Test
    public void initBoardWithZero() {

        Board<Move<Mark>> tttBoard = new TTTBoard(0);

        assertEquals(0, tttBoard.getAvailableCellCount());

        assertFalse(tttBoard.isAvailable());

    }

    @Test
    public void checkAvailability() throws Exception {

        Board<Move<Mark>> tttBoard = new TTTBoard(3);

        final TTTHumanPlayer player1 = new TTTHumanPlayer(Mark.CROSS, "Player1","1");
        final TTTHumanPlayer player2 = new TTTHumanPlayer(Mark.NOUGHT, "Player2","2");

        tttBoard.set(new TTTMove(0, 0, player1));
        tttBoard.set(new TTTMove(0, 1, player2));

        assertEquals(7, tttBoard.getAvailableCellCount());

    }

    @Test
    public void checkFull() throws Exception {

        Board<Move<Mark>> tttBoard = new TTTBoard(2);

        final TTTHumanPlayer player1 = new TTTHumanPlayer(Mark.CROSS, "Player1","1");
        final TTTHumanPlayer player2 = new TTTHumanPlayer(Mark.NOUGHT, "Player2","2");

        tttBoard.set(new TTTMove(0, 0, player1));
        tttBoard.set(new TTTMove(0, 1, player2));

        tttBoard.set(new TTTMove(1, 0, player1));
        tttBoard.set(new TTTMove(1, 1, player2));

        assertEquals(0, tttBoard.getAvailableCellCount());

        System.out.println(tttBoard.toString());

    }

    @Test
    public void getMoveNullCheck() {

        Board<Move<Mark>> tttBoard = new TTTBoard(3);

        assertNull(tttBoard.get(0, 0));
    }

    @Test
    public void getMoveException() {

        Board<Move<Mark>> tttBoard = new TTTBoard(3);

        try {
            tttBoard.get(4, 6);
            fail("Expection exception");
        } catch (Exception ex) {
            LOGGER.error("Success :" + ex.getMessage(), ex);
        }

    }

    @Test
    public void setMove() throws Exception {
        Board<Move<Mark>> tttBoard = new TTTBoard(3);

        final TTTHumanPlayer player1 = new TTTHumanPlayer(Mark.CROSS, "Player1","1");

        tttBoard.set(new TTTMove(0, 0, player1));

        assertNotNull(tttBoard.get(0, 0));
    }

}