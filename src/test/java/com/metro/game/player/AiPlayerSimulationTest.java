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

package com.metro.game.player;

import com.metro.game.Board;
import com.metro.game.Result;
import com.metro.tictactoe.game.TTTBoard;
import com.metro.tictactoe.game.player.Mark;
import com.metro.tictactoe.game.player.TTTPlayerFactory;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mga on 10/29/18.
 */
public class AiPlayerSimulationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaScannerTest.class);

    @Test
    public void aiSimulationTest(){

        Board board = new TTTBoard(4);

        List<Player> playerList = new ArrayList<>();

        playerList.add(TTTPlayerFactory.initPlayer(PlayerType.AI, Mark.CROSS, "Player1"));
        playerList.add(TTTPlayerFactory.initPlayer(PlayerType.AI, Mark.NOUGHT, "Player2"));
        playerList.add(TTTPlayerFactory.initPlayer(PlayerType.AI, Mark.RANDOM, "Player3"));


        Result finished = Result.CONTINUE;

        while (Result.CONTINUE.equals(finished)) {

            for (Player<Mark> pl : playerList) {

                finished = pl.play(board);

                switch (finished) {
                    case WIN:
                        LOGGER.debug("GAME DONE ! ");
                        LOGGER.debug(String.format(" %s Won the GAME !", pl.getName()));

                        break;

                    case CONTINUE:
                        LOGGER.debug("GAME CONTINUE ! ");
                        break;

                    case RETRY:
                        LOGGER.debug("GAME FAILED ! ");
                        break;

                    case FINISHED:
                        LOGGER.debug("GAME FINISHED ! ");
                        LOGGER.debug(" NOBODY WON THE GAME");

                        break;
                    default:

                }

                if (!Result.CONTINUE.equals(finished))
                    break;
            }
        }

        Assert.assertTrue(Result.WIN.equals(finished) || Result.FINISHED.equals(finished)|| Result.EXCEPTION.equals(finished));
    }
}