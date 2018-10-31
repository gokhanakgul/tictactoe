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
import com.metro.game.Move;
import com.metro.game.player.Player;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


/**
 * Created by mga on 10/29/18.
 */

public class TTTMove<Mark> extends TTTCoordinate implements Move<Mark> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTMove.class);

    private final Player<Mark> player;
    private final Mark mark;

    public TTTMove(Coordinate coordinate, Player<Mark> player) {
        this(coordinate.getCol(), coordinate.getRow(), player);
    }

    public TTTMove(int col, int row, Player<Mark> player) {
        super(col, row);
        this.player = player;
        this.mark = player.getMark();
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public Mark getValue() {
        return mark;
    }

    @Override
    public String toString() {
        return "TTTMove{" +
                "player=" + player +
                ", col=" + col +
                ", row=" + row +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TTTMove<?> tttMove = (TTTMove<?>) o;
        return Objects.equals(player, tttMove.player) &&
                Objects.equals(mark, tttMove.mark) &&
                Objects.equals(getCol(), tttMove.getCol()) &&
                Objects.equals(getRow(), tttMove.getCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), player, mark);
    }
}