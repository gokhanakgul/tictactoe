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

import com.metro.game.Coordinate;
import com.metro.tictactoe.game.TTTCoordinate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Scanner;


/**
 * Created by mga on 10/29/18.
 */

public class ConsoleStream {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleStream.class);

    private final Scanner scanner;

    public ConsoleStream(InputStream inputStream) {
        this.scanner = new Scanner(inputStream, "UTF-8");
    }

    public ConsoleStream() {
        this.scanner = new Scanner(System.in, "UTF-8");
    }

    public void println(String print) {
        System.out.println(print);
    }

    public void print(String print) {
        System.out.print(print);
    }

    public int[] inputCoordinate() {
        final String nextCoordinate = this.scanner.next();

        String[] coordinates = {};
        if (nextCoordinate != null && nextCoordinate.length() >= 3)
            coordinates = nextCoordinate.split(",");

        if (coordinates.length == 2) {

            try{
                int col = Integer.parseInt(coordinates[0]);
                int row = Integer.parseInt(coordinates[1]);

                return new int[]{col-1, row-1};
            }catch (Exception ex){
                LOGGER.error("Invalid Coordinate format",ex);
                return null;
            }

        }
        return null;
    }


    public String inputString() {
        return this.scanner.next();
    }

    public String format(String text, Object... args) {
        return String.format(text, args);
    }
}
