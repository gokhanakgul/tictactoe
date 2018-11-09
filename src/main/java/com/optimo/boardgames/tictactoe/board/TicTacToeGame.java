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

package com.optimo.boardgames.tictactoe.board;

import com.optimo.boardgames.Config;
import com.optimo.boardgames.Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by mga on 11/8/18.
 */

public class TicTacToeGame implements Game {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToeGame.class);

    private final Config config;

    public TicTacToeGame(Config config) {
        this.config = config;
    }

    @Override
    public void start() {
        config.getScenes().stream().sequential().forEach(scene -> scene.run(config));
    }
}
