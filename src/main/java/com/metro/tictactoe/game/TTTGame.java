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

import com.metro.game.Config;
import com.metro.game.Game;
import com.metro.game.Scene;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Created by mga on 10/29/18.
 *
 * Game implementation for Tic Tac Toe
 *
 */

public class TTTGame implements Game {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTGame.class);

    private final List<Scene> scenes;
    private final Config config;

    public TTTGame(final Scene[] scenes, Config config) {
        this.scenes = scenes == null ? new ArrayList<>() : Collections.unmodifiableList(Arrays.asList(scenes));
        this.config = config;
    }

    @Override
    public Config getConfig() {
        return this.config;
    }

    @Override
    public void start() {

        LOGGER.debug("Game Started");

        if(scenes != null && !scenes.isEmpty() ) {
            scenes.get(0).start(this);
        }else {
            throw new RuntimeException("Game wont start without any scenes !");
        }

    }

    @Override
    public String getName() {
        if(config==null)
            return null;

        return config.getValue("game.name");
    }

}