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

package com.metro.tictactoe.game.scenes;

import com.metro.game.Game;
import com.metro.game.Scene;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;


/**
 * Created by mga on 10/31/18.
 */

public class TestScene implements Scene {

    private int counter = 0;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestScene.class);

    public TestScene() {

    }

    @Override
    public void preload(Game game) {
        LOGGER.debug("Preload");
    }

    @Override
    public void create(Game game) {
        LOGGER.debug("CREATE");
    }

    @Override
    public void update(Game game) {

        this.counter++;

        try {
            LOGGER.debug("Doing Update Operation");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LOGGER.debug("CREATE");
    }

    @Override
    public void end(Game game) {
        LOGGER.debug("END");
    }

    @Override
    public boolean isDone(Game game) {
        return counter == 10 ;
    }
}
