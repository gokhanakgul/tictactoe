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
import com.metro.game.Move;
import com.metro.game.Result;
import com.metro.game.player.HumanPlayer;
import com.metro.tictactoe.game.TTTCoordinate;
import com.metro.tictactoe.game.TTTMove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mga on 10/29/18.
 */

public class TTTHumanPlayer extends TTTAbstractPlayer implements HumanPlayer<Mark> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTHumanPlayer.class);

    public TTTHumanPlayer(Mark mark, String name, String id) {
        super(mark, name, id);
    }

    @Override
    public Result play(Board board) {

        LOGGER.debug(format("Turn to %s, Your sign is %s ", getName().toUpperCase(), this.mark));

        Result result = Result.RETRY;

        if (!board.isAvailable()) {
            return null;
        }


        while (Result.RETRY.equals(result)) {

            final Coordinate coorCandidate = getCandidate(board.getSize());

            Move<Mark> candidate = new TTTMove(coorCandidate, this);

            result = board.set(candidate);

            LOGGER.debug(format("%s Set Move : %s", this.name, candidate.toString()));

            switch (result) {
                case RETRY:
                    println(format("%s , Your selection IS NOT VALID !", this.name));
                    break;

                case FINISHED:
                case CONTINUE:
                case WIN:
                    board.render();
                    println("_____________________");
                    break;

                default:
                    break;

            }
        }

        return result;
    }


    private Coordinate getCandidate(int boardLength) {
        Coordinate candidate = null;

        boolean validInput = false;
        while (!validInput) {
            print(format("Enter %s Coordinate: Range (0,0) (%s,%s) :", this, boardLength, boardLength));

            Integer[] coorCandidate = inputCoordinate();
            if(coorCandidate!=null)
                candidate = new TTTCoordinate(coorCandidate[0],coorCandidate[1]);

            validInput = candidate !=null && candidate.validate(boardLength);
            if (!validInput)
                println("Entered Coordinate Not Valid ! ");

        }
        return candidate;
    }

    private boolean isBoardRange(int boardLength, int candidate) {
        if (candidate < 0)
            return false;

        return (boardLength >= candidate && candidate > 1) || (boardLength > candidate && candidate >= 1);
    }

    @Override
    public String toString() {
        return "TTTHumanPlayer{" +
                "mark=" + mark +
                ", name='" + name + '\'' +
                '}';
    }
}