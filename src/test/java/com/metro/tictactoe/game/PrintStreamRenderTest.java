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

import com.metro.tictactoe.game.utils.PrintStreamRender;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mga on 10/30/18.
 */
public class PrintStreamRenderTest {

    /**
     * Previous Simple Scenario
     */

    public void render() {
        String board6X6 =
                "+---+---+---+---+---+---+" + "\n" + "|   |   |   |   |   |   |" + "\n" +
                        "+---+---+---+---+---+---+" + "\n" + "|   |   |   |   |   |   |" + "\n" +
                        "+---+---+---+---+---+---+" + "\n" + "|   |   |   |   |   |   |" + "\n" +
                        "+---+---+---+---+---+---+" + "\n" + "|   |   |   |   |   |   |" + "\n" +
                        "+---+---+---+---+---+---+" + "\n" + "|   |   |   |   |   |   |" + "\n" +
                        "+---+---+---+---+---+---+" + "\n" + "|   |   |   |   |   |   |" + "\n" +
                        "+---+---+---+---+---+---+";


        PrintStreamRender render = new PrintStreamRender(System.out);
        final String render6X6 = render.render(new TTTBoard(6));
        Assert.assertEquals(render6X6, board6X6);

    }

    @Test
    public void renderWithCoordinate() {
        String board6X6 =
                "+---+---+---+---+---+---+---+" + "\n" +
                        "|[0]|[1]|[2]|[3]|[4]|[5]|[6]|" + "\n" +
                        "+---+---+---+---+---+---+---+" + "\n" +
                        "|[1]|   |   |   |   |   |   |" + "\n" +
                        "+---+---+---+---+---+---+---+" + "\n" + "|[2]|   |   |   |   |   |   |" + "\n" +
                        "+---+---+---+---+---+---+---+" + "\n" + "|[3]|   |   |   |   |   |   |" + "\n" +
                        "+---+---+---+---+---+---+---+" + "\n" + "|[4]|   |   |   |   |   |   |" + "\n" +
                        "+---+---+---+---+---+---+---+" + "\n" + "|[5]|   |   |   |   |   |   |" + "\n" +
                        "+---+---+---+---+---+---+---+" + "\n" + "|[6]|   |   |   |   |   |   |" + "\n" +
                        "+---+---+---+---+---+---+---+";


        PrintStreamRender render = new PrintStreamRender(System.out);
        final String render6X6 = render.render(new TTTBoard(6));
        Assert.assertEquals(render6X6, board6X6);

    }


}