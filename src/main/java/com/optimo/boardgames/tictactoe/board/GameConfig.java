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
import com.optimo.boardgames.Player;
import com.optimo.boardgames.Scene;
import com.optimo.boardgames.Stone;
import com.optimo.boardgames.tictactoe.player.AiPlayer;
import com.optimo.boardgames.tictactoe.player.CrossStone;
import com.optimo.boardgames.tictactoe.player.InventoryImpl;
import com.optimo.boardgames.tictactoe.player.NoughStone;
import com.optimo.boardgames.tictactoe.render.BoardRenderImpl;
import com.optimo.boardgames.tictactoe.render.ConsoleManager;
import com.optimo.boardgames.tictactoe.scene.BoardGameScene;
import com.optimo.boardgames.tictactoe.scene.WelcomeScene;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;


/**
 * Created by mga on 11/8/18.
 */

public class GameConfig implements Config {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameConfig.class);
    private static final String SYSTEM_USER_DIR = "user.dir";
    private static final String APP_PROPERTIES = "/app.properties";
    private final Properties properties;
    private final ConsoleManager consoleManager;
    private final List<Scene> scenes = new ArrayList<>();
    private final List<Player> players = new ArrayList<>();
    private int boardSize = 3;


    public GameConfig(ConsoleManager consoleManager) throws IOException {
        this.properties = loadPropertiesFile();
        this.consoleManager = consoleManager;
    }

    @Override
    public int getBoardSize() {

        try {
            final Integer boardSize = Integer.valueOf(properties.getProperty("board.size"));
            if (boardSize > 2 && boardSize < 11)
                this.boardSize = boardSize;

        } catch (Exception ex) {
            LOGGER.error("Board size problem", ex);

        }

        return this.boardSize;
    }

    @Override
    public List<Scene> getScenes() {
        if (scenes.isEmpty()) {

            scenes.add(new WelcomeScene(consoleManager));
            scenes.add(new BoardGameScene(consoleManager, new BoardRenderImpl()));

        }

        return Collections.unmodifiableList(scenes);
    }

    @Override
    public List<Player> getPlayers() {

        if (players.isEmpty()) {

            Stone crossStone = new CrossStone(null);
            Stone noughStone = new NoughStone(null);

            Player aiPlayer = new AiPlayer("Player1", new InventoryImpl(crossStone));

            Player hp1 = new AiPlayer("Player2", new InventoryImpl(noughStone));
            //Player hp2 = new AiPlayer("Player3", noughStone);

            players.add(aiPlayer);
            players.add(hp1);
            //players.add(hp2);

        }

        return players;
    }

    @Override
    public String getText(String key) {
        return properties.getProperty(key);
    }

    private Properties loadPropertiesFile() throws IOException {
        return loadPropertiesFile(APP_PROPERTIES, true);
    }


    /**
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    private Properties loadPropertiesFile(String filePath, boolean checkWorkingDir) throws IOException {

        Properties properties = new Properties();
        if (checkWorkingDir)
            checkFromWorkingDirectory(properties);

        if (properties.isEmpty())
            properties.load(GameConfig.class.getResourceAsStream(filePath));

        return properties;
    }

    private void checkFromWorkingDirectory(Properties properties) {
        String workingDir = System.getProperty(SYSTEM_USER_DIR);

        LOGGER.debug("Current working directory : " + workingDir);

        final String pathname = workingDir + APP_PROPERTIES;

        try {
            properties.load(Files.newInputStream(Paths.get(pathname), StandardOpenOption.READ));
        } catch (IOException e) {
            LOGGER.error(String.format("Could not found config file [%s] ", pathname));
        }


    }

}