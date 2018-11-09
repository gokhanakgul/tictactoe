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

package com.optimo.boardgames.tictactoe.render;

import com.optimo.boardgames.Coordinate;
import com.optimo.boardgames.tictactoe.board.CoordinateImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


/**
 * Created by mga on 11/8/18.
 */

public class ConsoleManagerImpl implements ConsoleManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleManagerImpl.class);
    private final PrintStream printStream;
    private final Scanner scanner;

    public ConsoleManagerImpl(InputStream source, PrintStream printStream) {
        this.scanner = new Scanner(source, "UTF-8");
        this.printStream = printStream;
    }

    @Override
    public Coordinate getCoordinate(String message) {
        println(message);

        final String nextCoordinate = this.scanner.next();

        String[] coordinates = {};
        if (nextCoordinate != null && nextCoordinate.length() >= 3)
            coordinates = nextCoordinate.split(",");

        if (coordinates.length == 2) {

            try {

                int col = Integer.parseInt(coordinates[0]);
                int row = Integer.parseInt(coordinates[1]);

                return new CoordinateImpl(col - 1, row - 1);

            } catch (Exception ex) {
                LOGGER.error("Invalid Coordinate format", ex);
                return null;
            }

        }

        return null;
    }

    @Override
    public void println(String string) {
        printStream.println(string);
    }

    @Override
    public void print(String string) {
        printStream.print(string);
    }
}
