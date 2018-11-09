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

package com.optimo.boardgames.tictactoe.scene;

import com.optimo.boardgames.Config;
import com.optimo.boardgames.Scene;
import com.optimo.boardgames.tictactoe.render.ConsoleManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by mga on 11/8/18.
 */

public class WelcomeScene implements Scene {

    private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeScene.class);

    private final ConsoleManager consoleManager;

    public WelcomeScene(ConsoleManager consoleManager) {
        this.consoleManager = consoleManager;
    }

    @Override
    public void run(Config config) {
        if (LOGGER.isTraceEnabled())
            LOGGER.trace("Scene Startted");
        consoleManager.println(config.getText("game.name"));
        consoleManager.println(config.getText("game.credits"));
    }

}