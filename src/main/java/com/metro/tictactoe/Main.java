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

package com.metro.tictactoe;

import com.metro.game.Config;
import com.metro.game.Game;
import com.metro.tictactoe.game.TTTGame;
import com.metro.tictactoe.game.TTTScene;
import com.metro.tictactoe.game.utils.GameUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * @author Gökhan Akgül {@literal gokhan.akgul@gmail.com}
 */
public final class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /**
     * Constructor
     */
    private Main() {
        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out),true,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args this is initial params for main function
     */
    public static void main(final String[] args) {


        try {
            final TTTScene tictactoeScene = new TTTScene("TicTacToe Scene");
            final TTTScene[] scenes = {tictactoeScene};

            final Config config = GameUtility.loadPropertiesFile();

            Game game = new TTTGame(scenes, config);
            game.start();

        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }


    }


}