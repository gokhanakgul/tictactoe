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

package com.metro.game.player;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


/**
 * Created by mga on 10/30/18.
 */

public class JavaScannerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaScannerTest.class);


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8");


        System.out.print("Enter your name: ");


        String username = scanner.next();


        System.out.print("Enter your age: ");


        int age = scanner.nextInt();

        System.out.println(String.format("%s, your age is %d", username, age));

    }
}
