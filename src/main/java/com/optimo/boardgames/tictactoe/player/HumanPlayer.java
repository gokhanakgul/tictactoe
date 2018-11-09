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

package com.optimo.boardgames.tictactoe.player;

import com.optimo.boardgames.Action;
import com.optimo.boardgames.Board;
import com.optimo.boardgames.Coordinate;
import com.optimo.boardgames.Stone;
import com.optimo.boardgames.tictactoe.render.ConsoleManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by mga on 11/8/18.
 */

public class HumanPlayer extends AiPlayer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HumanPlayer.class);

    private final ConsoleManager consoleManager;

    public HumanPlayer(String name, Stone stone, ConsoleManager input) {
        super(name, new InventoryImpl(stone));
        this.consoleManager = input;
    }

    @Override
    public Action play(Board board) {
        Action action = null;

        Coordinate coordinate = null;
        while (coordinate == null) {

            coordinate = consoleManager.getCoordinate("Please enter valid coordinate for board like 1,2 :");
            if (coordinate != null) {
                action = new ActionImpl(coordinate, this);
                if (!board.set(action)) {
                    coordinate = null;
                }
            }

        }

        return action;
    }

}
