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
import com.metro.tictactoe.game.scenes.TestScene;
import com.metro.tictactoe.game.utils.GameUtility;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by mga on 10/29/18.
 */
public class TTTGameTest {

    @Test
    public void start() {
        Game game = new TTTGame(null, null);

        try {
            game.start();
            Assert.fail("Exception expected.");
        } catch (Exception ex) {

        }
    }

    @Test
    public void nameExpectedNull() {
        Game game = new TTTGame(null, null);

        Assert.assertNull(game.getName());
    }


    @Test
    public void name() {
        Config config = null;

        try {
            config = GameUtility.loadPropertiesFile();
        } catch (IOException e) {
            Assert.fail("Expecting a config file ");
        }

        Game game = new TTTGame(null, config);

        Assert.assertNotNull(game.getConfig());
        Assert.assertNotNull(game.getName());
    }


    @Test
    public void sceneScenario() {
        Config config = null;

        try {
            config = GameUtility.loadPropertiesFile();
        } catch (IOException e) {
            Assert.fail("Expecting a config file ");
        }

        final TestScene testScene = new TestScene();
        final TestScene[] scenes = {testScene};

        Game game = new TTTGame(scenes, config);

        Assert.assertNotNull(game.getConfig());
        Assert.assertNotNull(game.getName());

        try {
            game.start();
        } catch (Exception ex) {

            Assert.fail("Exception not expecting");
        }


    }
}