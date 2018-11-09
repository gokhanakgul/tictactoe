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

import com.optimo.boardgames.Stone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by mga on 11/8/18.
 */

public class NoughStone implements Stone {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoughStone.class);

    private static final String NOUGH = "O";
    private static final String NAME_NOUGH = "Nough";

    private final String symbol;

    public NoughStone(String symbol) {

        this.symbol = symbol != null ? symbol : NOUGH;

    }

    @Override
    public String getName() {
        return NAME_NOUGH;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
