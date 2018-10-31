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

import com.metro.game.Board;
import com.metro.game.Result;
import com.metro.game.player.Player;
import com.metro.tictactoe.game.utils.ConsoleStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;


/**
 * Created by mga on 10/31/18.
 */

public class TTTAbstractPlayer extends ConsoleStream implements Player {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTAbstractPlayer.class);

    protected static final List<Mark> MARK_RND_LIST = Arrays.asList(Mark.NOUGHT, Mark.CROSS);

    protected final Mark mark;
    protected final String name;
    protected final String id;

    public TTTAbstractPlayer(Mark mark, String name, String id) {
        super(System.in);
        this.mark = mark;
        this.name = name;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }


    @Override
    public Result play(Board board) {
        return Result.EXCEPTION;
    }


    public String getName() {
        return this.name;
    }

    @Override
    public Mark getMark() {
        return this.mark;
    }


}
