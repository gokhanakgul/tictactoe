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

package com.optimo.boardgames;

import com.optimo.boardgames.tictactoe.board.GameConfig;
import com.optimo.boardgames.tictactoe.board.TicTacToeGame;
import com.optimo.boardgames.tictactoe.render.ConsoleManager;
import com.optimo.boardgames.tictactoe.render.ConsoleManagerImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;


/**
 * Created by mga on 11/8/18.
 */

public class TicTacToe {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToe.class);

    public static void main(String[] args) throws IOException {

        final PrintStream out = System.out;
        final InputStream in = System.in;

        ConsoleManager consoleManager = new ConsoleManagerImpl(in, out);


        Config config = new GameConfig(consoleManager);

        Game game = new TicTacToeGame(config);
        game.start();

    }

}
