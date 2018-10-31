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

package com.metro.tictactoe.game.player;

import com.metro.game.player.Player;
import com.metro.game.player.PlayerType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by mga on 10/29/18.
 */

public class TTTPlayerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTPlayerFactory.class);

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public static Player initPlayer(PlayerType playerType, Mark mark, String name) {
        if (playerType == null)
            return null;

        switch (playerType) {
            case AI:
                if (mark == null) {
                    LOGGER.debug("Marker Should not be null therefore default rule is RANDOM");
                    mark = Mark.RANDOM;
                }
                return new TTTAiPlayer(mark, name, UUID.randomUUID().toString());

            case HUMAN:
            default:
                if (mark == null || Mark.RANDOM.equals(mark)) {
                    LOGGER.error("You should specify a Mark for Human either Mark.NOUGHT or Mark.CROSS");
                    return null;
                }
                return new TTTHumanPlayer(mark, name, UUID.randomUUID().toString());

        }
    }

    public static Player initPlayer(PlayerType playerType, Mark mark) {
        final String playerName = "Player" + atomicInteger.addAndGet(1);
        return initPlayer(playerType, mark, playerName);
    }

}