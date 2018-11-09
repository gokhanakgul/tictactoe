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

package com.optimo.boardgames.tictactoe.render;

import com.optimo.boardgames.Action;
import com.optimo.boardgames.Board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by mga on 11/8/18.
 */

public class BoardRenderImpl implements BoardRender {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardRenderImpl.class);

    private static final String FRAME_LEFT = "[";
    private static final String FRAME_RIGHT = "]";
    private static final String NEW_LINE = "\n";
    private static final String PIPE = "|";
    private static final String CORNER = "+";
    private static final String BORDER = "---";
    private static final String SPACE = " ";

    @Override
    public String render(Board board) {

        return printGridViewWithCoordinate(board);

    }

    /**
     * +---+---+---+---+---+---+ |   |   |   |   |   |   | +---+---+---+---+---+---+ |   |   |   | |
     * |   | +---+---+---+---+---+---+ |   |   |   |   |   |   | +---+---+---+---+---+---+ |   | | |
     * |   |   | +---+---+---+---+---+---+ |   |   |   |   |   |   | +---+---+---+---+---+---+ | | |
     * |   |   |   | +---+---+---+---+---+---+
     */
    private String printGridView(Board board) {

        StringBuilder toString = new StringBuilder();
        StringBuilder lineSeperator = new StringBuilder();
        StringBuilder line;

        final int boardSize = board.getSize();
        for (int row = 0; row < boardSize; row++) {

            line = new StringBuilder(PIPE);
            lineSeperator = new StringBuilder(CORNER);

            for (int col = 0; col < boardSize; col++) {
                Action action = board.get(col, row);

                lineSeperator.append(BORDER).append(CORNER);

                line.append(SPACE).append(action == null ? SPACE : action.getStone().getSymbol()).append(SPACE).append(PIPE);
            }

            toString.append(lineSeperator).append(NEW_LINE).append(line).append(NEW_LINE);
        }

        toString.append(lineSeperator);

        return toString.toString();
    }

    /**
     * +---+---+---+---+---+---+---+ |[0]|[1]|[2]|[3]|[4]|[5]|[6]| +---+---+---+---+---+---+---+
     * |[1]|   |   |   |   |   |   | +---+---+---+---+---+---+---+ |[2]|   |   |   |   |   |   |
     * +---+---+---+---+---+---+---+ |[3]|   |   |   |   |   |   | +---+---+---+---+---+---+---+
     * |[4]|   |   |   |   |   |   | +---+---+---+---+---+---+---+ |[5]|   |   |   |   |   |   |
     * +---+---+---+---+---+---+---+ |[6]|   |   |   |   |   |   | +---+---+---+---+---+---+---+
     */


    private String printGridViewWithCoordinate(Board board) {

        StringBuilder toString = new StringBuilder();
        StringBuilder lineSeperator;
        StringBuilder line;

        final int boardSize = board.getSize();

        lineSeperator = new StringBuilder(CORNER);
        line = new StringBuilder(PIPE);
        for (int i = 0; i < boardSize + 1; i++) {
            lineSeperator.append(BORDER).append(CORNER);
            line.append(FRAME_LEFT).append(i).append(FRAME_RIGHT).append(PIPE);
        }
        toString.append(lineSeperator).append(NEW_LINE).append(line).append(NEW_LINE);


        for (int row = 0; row < boardSize; row++) {

            line = new StringBuilder(PIPE);
            lineSeperator = new StringBuilder(CORNER).append(BORDER).append(CORNER);

            line.append(FRAME_LEFT).append(row + 1).append(FRAME_RIGHT).append(PIPE);
            for (int col = 0; col < boardSize; col++) {
                Action action = board.get(col, row);

                lineSeperator.append(BORDER).append(CORNER);

                line.append(SPACE).append(action == null ? SPACE : action.getStone().getSymbol()).append(SPACE).append(PIPE);
            }

            toString.append(lineSeperator).append(NEW_LINE).append(line).append(NEW_LINE);
        }

        toString.append(lineSeperator);

        return toString.toString();
    }


}
