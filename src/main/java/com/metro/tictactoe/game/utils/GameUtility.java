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

package com.metro.tictactoe.game.utils;

import com.metro.game.Config;
import com.metro.tictactoe.game.TTTConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.util.List;
import java.util.Properties;


/**
 * Created by mga on 10/30/18.
 */

public class GameUtility {

    public static final String SYSTEM_USER_DIR = "user.dir";
    public static final String APP_PROPERTIES = "/app.properties";
    private static final Logger LOGGER = LoggerFactory.getLogger(GameUtility.class);
    private static final SecureRandom random = new SecureRandom();

    public static <T extends Enum<?>> T pickRandom(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        final T enumConstant = clazz.getEnumConstants()[x];

        LOGGER.debug(enumConstant.toString());
        return enumConstant;
    }

    public static <T> T pickRandom(List<T> coordinates) {
        if (coordinates.size() <= 0) {
            LOGGER.error("Size Problem");
        }

        return coordinates.get(random.nextInt(coordinates.size()));
    }


    /**
     * Find default app properties file
     */
    public static Config loadPropertiesFile() throws IOException {
        return loadPropertiesFile(APP_PROPERTIES, true);
    }


    /**
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static Config loadPropertiesFile(String filePath, boolean checkWorkingDir) throws IOException {

        Properties properties = new Properties();
        if (checkWorkingDir)
            checkFromWorkingDirectory(properties);

        if (properties.isEmpty())
            properties.load(GameUtility.class.getResourceAsStream(APP_PROPERTIES));

        return new TTTConfig(properties);
    }




    private static Properties checkFromWorkingDirectory(Properties properties) {
        String workingDir = System.getProperty(SYSTEM_USER_DIR);

        LOGGER.debug("Current working directory : " + workingDir);

        final String pathname = workingDir + APP_PROPERTIES;


        try {
            properties.load(Files.newInputStream(Paths.get(pathname), StandardOpenOption.READ));
        } catch (IOException e) {
            LOGGER.error(String.format("Could not found config file [%s] ", pathname));
        }


        return properties;
    }
}
