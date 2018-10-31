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

import com.metro.game.Coordinate;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mga on 10/30/18.
 */
public class TTTCoordinateTest {

    @Test
    public void getCol() {

        Coordinate coordinate = new TTTCoordinate(0, 0);

        Assert.assertEquals(0, coordinate.getCol());

    }

    @Test
    public void getRow() {

        Coordinate coordinate = new TTTCoordinate(0, 0);

        Assert.assertEquals(0, coordinate.getRow());
    }

    @Test
    public void equals() {
        Coordinate coordinate2 = new TTTCoordinate(0, 0);

        Coordinate coordinate1 = new TTTCoordinate(0, 0);

        Assert.assertEquals(coordinate1, coordinate2);

    }

    @Test
    public void notEquals() {
        Coordinate coordinate2 = new TTTCoordinate(0, 0);

        Coordinate coordinate1 = new TTTCoordinate(1, 0);

        Assert.assertNotEquals(coordinate1, coordinate2);

    }


    @Test
    public void coordinateValidation() {


        Coordinate coordinate = new TTTCoordinate(0, 0);

        Assert.assertTrue(coordinate.validate(5));

        coordinate = new TTTCoordinate(4, 0);
        Assert.assertTrue(coordinate.validate(5));


        coordinate = new TTTCoordinate(5, 0);
        Assert.assertFalse(coordinate.validate(5));

        coordinate = new TTTCoordinate(4, 5);
        Assert.assertFalse(coordinate.validate(5));

        coordinate = new TTTCoordinate(4, -1);
        Assert.assertFalse(coordinate.validate(5));


    }
}