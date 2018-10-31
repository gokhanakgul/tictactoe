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

import com.metro.game.Board;
import com.metro.game.Move;
import com.metro.game.Render;
import com.metro.tictactoe.game.player.Mark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;

/**
 * Created by mga on 10/30/18.
 */

public class PrintStreamRender implements Render<String, Board<Move<Mark>>> {

    private static final String NEW_LINE = "\n";
    private static final String PIPE = "|";
    private static final String CORNER = "+";
    private static final String BORDER = "---";
    private static final String SPACE = " ";

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintStreamRender.class);

    private final PrintStream out;

    public PrintStreamRender(PrintStream out) {
        this.out = out;
    }

    @Override
    public String render(Board<Move<Mark>> board) {
        final String renderedBoard = printGridViewWithCoordinate(board);

        out.println(renderedBoard);
        return renderedBoard;
    }


    /**
     *
     *
     * +---+---+---+---+---+---+
     * |   |   |   |   |   |   |
     * +---+---+---+---+---+---+
     * |   |   |   |   |   |   |
     * +---+---+---+---+---+---+
     * |   |   |   |   |   |   |
     * +---+---+---+---+---+---+
     * |   |   |   |   |   |   |
     * +---+---+---+---+---+---+
     * |   |   |   |   |   |   |
     * +---+---+---+---+---+---+
     * |   |   |   |   |   |   |
     * +---+---+---+---+---+---+
     *
     * @param board
     * @return
     */
    private String printGridView(Board<Move<Mark>> board) {

        StringBuilder toString = new StringBuilder();
        StringBuilder lineSeperator = new StringBuilder();
        StringBuilder line;

        final int boardSize = board.getSize();
        for (int row = 0; row < boardSize; row++) {

            line = new StringBuilder(PIPE);
            lineSeperator = new StringBuilder(CORNER);

            for (int col = 0; col < boardSize; col++) {
                final Move<Mark> move = board.get(col, row);

                lineSeperator.append(BORDER).append(CORNER);

                line.append(SPACE).append(move == null ? SPACE : move.getValue().getMark()).append(SPACE).append(PIPE);
            }

            toString.append(lineSeperator).append(NEW_LINE).append(line).append(NEW_LINE);
        }

        toString.append(lineSeperator);

        return toString.toString();
    }

    /**
     *
     * +---+---+---+---+---+---+---+
     * |[0]|[1]|[2]|[3]|[4]|[5]|[6]|
     * +---+---+---+---+---+---+---+
     * |[1]|   |   |   |   |   |   |
     * +---+---+---+---+---+---+---+
     * |[2]|   |   |   |   |   |   |
     * +---+---+---+---+---+---+---+
     * |[3]|   |   |   |   |   |   |
     * +---+---+---+---+---+---+---+
     * |[4]|   |   |   |   |   |   |
     * +---+---+---+---+---+---+---+
     * |[5]|   |   |   |   |   |   |
     * +---+---+---+---+---+---+---+
     * |[6]|   |   |   |   |   |   |
     * +---+---+---+---+---+---+---+
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * @param board
     * @return
     */
    private String printGridViewWithCoordinate(Board<Move<Mark>> board) {

        StringBuilder toString = new StringBuilder();
        StringBuilder lineSeperator;
        StringBuilder line;

        final int boardSize = board.getSize();

        lineSeperator = new StringBuilder(CORNER);
        line = new StringBuilder(PIPE);
        for (int i = 0; i < boardSize + 1; i++) {
            lineSeperator.append(BORDER).append(CORNER);
            line.append("[").append(i).append("]").append(PIPE);
        }
        toString.append(lineSeperator).append(NEW_LINE).append(line).append(NEW_LINE);


        for (int row = 0; row < boardSize; row++) {

            line = new StringBuilder(PIPE);
            lineSeperator = new StringBuilder(CORNER);

            lineSeperator.append(BORDER).append(CORNER);

            line.append("[").append(row + 1).append("]").append(PIPE);
            for (int col = 0; col < boardSize; col++) {
                final Move<Mark> move = board.get(col, row);

                lineSeperator.append(BORDER).append(CORNER);

                line.append(SPACE).append(move == null ? SPACE : move.getValue().getMark()).append(SPACE).append(PIPE);
            }

            toString.append(lineSeperator).append(NEW_LINE).append(line).append(NEW_LINE);
        }

        toString.append(lineSeperator);

        return toString.toString();
    }
}
