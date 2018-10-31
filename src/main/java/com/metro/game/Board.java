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

package com.metro.game;

import java.util.List;


/**
 * An Board interface for a board games
 *
 * Created by mga on 10/29/18.
 */
public interface Board <T>{

    /**
     * Retrieve a coordinate from board it will return previously made move
     * if any player has setted a move that cell
     * @param col column coordinate zero based
     * @param row row coordinate zero based
     * @return
     */
    T get(int col, int row);

    /**
     * A player can try to set a move on the board.
     * @param move
     * @return
     */
    Result set(T move);

    /**
     * it should show if the Board is available for play or not
     * @return
     */
    boolean isAvailable();

    /**
     * it should return the Board one row or column length.
     * @return
     */
    int getSize();


    /**
     * it should return empty cell counts of the board .
     * When the game starts you would have got (board.size * board.size) empty cells.
     * @return
     */

    int getAvailableCellCount();

    /**
     * it should returns available cell coordinates collection.
     * @return
     */
    List<Coordinate> getAvailableCellCoordinates();

    /**
     * it should helps you to render on appropriate out platform.
     */
    void render();
}