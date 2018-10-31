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

import com.metro.tictactoe.game.player.Mark;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by mga on 10/30/18.
 */
public class GameUtilityTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameUtilityTest.class);

    @Test
    public void pickRandomEnum() {

        Mark first = GameUtility.pickRandom(Mark.class);
        Mark second;

        boolean equal = true;
        while (equal) {

            second = GameUtility.pickRandom(Mark.class);

            Assert.assertNotNull(second);

            equal = first.equals(second);

            LOGGER.debug(String.format(" first %s , second  %s", first, second));
        }

        assertFalse(equal);

    }

    @Test
    public void pickRandomFromList() {

        Integer[] lst = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        final List<Integer> integers = Arrays.asList(lst);

        for (int i = 0; i < integers.size(); i++) {
            Integer rndItem = GameUtility.pickRandom(integers);

            assertNotNull(integers.contains(rndItem));
        }

    }
}