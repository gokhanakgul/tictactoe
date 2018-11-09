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
import com.optimo.boardgames.Inventory;
import com.optimo.boardgames.Player;
import com.optimo.boardgames.Stone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;


/**
 * Created by mga on 11/8/18.
 */

public class AiPlayer implements Player {

    private static final Logger LOGGER = LoggerFactory.getLogger(AiPlayer.class);
    private final String name;
    private final Inventory inventory;
    private final Random random;

    public AiPlayer(String name, Inventory inventory) {
        this.name = name;
        this.inventory = inventory;
        this.random = new SecureRandom();
    }

    @Override
    public Action play(Board board) {
        final List<Coordinate> availables = board.availables();
        final Coordinate coordinate = availables.size() == 1 ? availables.get(0) : availables.get(pickIndex(availables.size()));
        Action action = new ActionImpl(coordinate, this);
        board.set(action);
        return action;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Stone getStone() {
        return inventory.getStones().get(pickIndex(inventory.getStones().size()));
    }

    private int pickIndex(int size) {
        return random.nextInt(size);
    }
}
