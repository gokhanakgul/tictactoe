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

import com.metro.game.Board;
import com.metro.game.Move;
import com.metro.game.Render;
import com.metro.game.Result;
import com.metro.tictactoe.game.player.Mark;
import com.metro.tictactoe.game.utils.PrintStreamRender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by mga on 10/31/18.
 */

public class SimpleBoard extends AbstractBoard {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleBoard.class);
    private final Render<String, Board<Move<Mark>>> render;

    public SimpleBoard(int size) {
        super(size);
        render = new PrintStreamRender(System.out);
    }

    @Override
    public Result set(Move<Mark> move) {

        this.board[move.getCol()][move.getRow()] = move;
        availableCells.remove(getIndexFromCoordiate(getSize(), move.getCol(), move.getRow()));

        return isAvailable() ? Result.CONTINUE : Result.FINISHED;
    }

    @Override
    public void render() {
        render.render(this);
    }
}
