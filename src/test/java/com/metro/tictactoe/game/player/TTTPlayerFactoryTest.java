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

package com.metro.tictactoe.game.player;

import com.metro.game.player.AiPlayer;
import com.metro.game.player.HumanPlayer;
import com.metro.game.player.Player;
import com.metro.game.player.PlayerType;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mga on 10/31/18.
 */
public class TTTPlayerFactoryTest {

    @Test
    public void initPlayer() {

        final Player player = TTTPlayerFactory.initPlayer(null, null);

        Assert.assertNull(player);


    }

    @Test
    public void initHumanCross() {
        final Player player = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.CROSS);

        Assert.assertNotNull(player);
        Assert.assertEquals(Mark.CROSS, player.getMark());
        Assert.assertTrue(player instanceof HumanPlayer);
        Assert.assertNotNull(player.getName());

    }

    @Test
    public void initHumanNought() {
        final Player player = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.NOUGHT);

        Assert.assertNotNull(player);
        Assert.assertEquals(Mark.NOUGHT, player.getMark());
        Assert.assertTrue(player instanceof HumanPlayer);
        Assert.assertNotNull(player.getName());

    }

    @Test
    public void initHumanRandom() {

        final Player player = TTTPlayerFactory.initPlayer(PlayerType.HUMAN, Mark.RANDOM);
        Assert.assertNull(player);

    }


    @Test
    public void initAiRandom() {

        final Player player = TTTPlayerFactory.initPlayer(PlayerType.AI, Mark.RANDOM);
        Assert.assertNotNull(player);
        Assert.assertTrue(player instanceof AiPlayer);
        Assert.assertNotNull(player.getName());

    }

    @Test
    public void initAiNought() {

        final Player player = TTTPlayerFactory.initPlayer(PlayerType.AI, Mark.NOUGHT);
        Assert.assertNotNull(player);
        Assert.assertEquals(Mark.NOUGHT, player.getMark());
        Assert.assertTrue(player instanceof AiPlayer);
        Assert.assertNotNull(player.getName());

    }

    @Test
    public void initAiCross() {

        final Player player = TTTPlayerFactory.initPlayer(PlayerType.AI, Mark.CROSS);
        Assert.assertNotNull(player);
        Assert.assertEquals(Mark.CROSS, player.getMark());
        Assert.assertTrue(player instanceof AiPlayer);
        Assert.assertNotNull(player.getName());

    }
}