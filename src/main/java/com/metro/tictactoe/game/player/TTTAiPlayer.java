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

import com.metro.game.Board;
import com.metro.game.Coordinate;
import com.metro.game.Result;
import com.metro.game.player.AiPlayer;
import com.metro.tictactoe.game.TTTMove;
import com.metro.tictactoe.game.utils.GameUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by mga on 10/29/18.
 */

public class TTTAiPlayer extends TTTAbstractPlayer implements AiPlayer<Mark> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTAiPlayer.class);

    public TTTAiPlayer(Mark mark, String name, String id) {
        super(mark, name, id);
    }

    @Override
    public Result play(Board board) {
        LOGGER.debug(format("Turn to %s, Thinking..", getName().toUpperCase()));

        Result result = Result.RETRY;

        final List<Coordinate> coordinates = board.getAvailableCellCoordinates();

        while (Result.RETRY.equals(result)) {

            Coordinate coordinate = GameUtility.pickRandom(coordinates);

            LOGGER.debug(String.format("%s Set Move : %s", this.name, coordinate.toString()));

            result = board.set(new TTTMove(coordinate, this));

            switch (result) {
                case RETRY:
                    LOGGER.debug(String.format("%s , Your selection IS NOT VALID !", this.name));
                    break;

                case FINISHED:
                case CONTINUE:
                case WIN:
                    board.render();
                    break;

                default:
                    break;
            }
        }

        return result;
    }

    @Override
    public Mark getMark() {
        return Mark.RANDOM.equals(this.mark) ? GameUtility.pickRandom(MARK_RND_LIST) : this.mark;
    }

    @Override
    public String toString() {
        return "TTTAiPlayer{" +
                "mark=" + mark +
                ", name='" + getName() + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return super.getName() + " (AI)";
    }
}