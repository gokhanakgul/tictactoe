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

import com.metro.game.Config;
import com.metro.game.Game;
import com.metro.game.Result;
import com.metro.game.Scene;
import com.metro.game.player.Player;
import com.metro.game.player.PlayerType;
import com.metro.tictactoe.game.player.Mark;
import com.metro.tictactoe.game.player.TTTPlayerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mga on 10/29/18.
 */

public class TTTScene implements Scene {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTScene.class);

    private final String name;

    private TTTBoard board;

    private List<Player> players;

    private Config config;

    private boolean done = false;

    public TTTScene(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void preload(Game game) {

        this.config = game.getConfig();


    }


    @Override
    public void create(Game game) {

        initMarkers();

        initPlayers();

        initBoard();

    }


    private void initMarkers() {
        final String markCross = this.config.getValue("mark.cross");
        if (markCross != null) Mark.CROSS.setMark(markCross);

        final String markNought = this.config.getValue("mark.nought");
        if (markNought != null) Mark.NOUGHT.setMark(markNought);
    }

    private void initPlayers() {

        final PlayerType[] playerTypes = PlayerType.values();
        final Mark[] markTypes = Mark.values();

        players = new ArrayList<>();
        final Integer playerCount = Integer.valueOf(config.getValue("player.count"));
        for (int i = 0; i < playerCount; i++) {

            int plNum = i + 1;

            final Integer playerType = Integer.valueOf(config.getValue("player." + plNum + ".type"));

            final Integer playerMark = Integer.valueOf(config.getValue("player." + plNum + ".mark"));

            final Player player = TTTPlayerFactory.initPlayer(playerTypes[playerType], markTypes[playerMark]);
            if (player != null) {

                players.add(player);

            } else {

                LOGGER.error(String.format("PlayerType : %s ,playerMark : %s is not allowed "), playerType, playerMark);
            }
        }

        if (players.isEmpty())
            throw new RuntimeException("You can not play game without players");
    }


    private void initBoard() {

        int result = 3;
        try {
            final Integer boardSize = Integer.valueOf(config.getValue("board.size"));
            if (boardSize > 2 && boardSize < 11)
                result = boardSize;

        } catch (Exception ex) {
            LOGGER.error("Board size problem", ex);

        }
        board = new TTTBoard(result);
        board.render();
    }

    @Override
    public void update(Game game) {


        for (Player pl : this.players) {

            final Result result = pl.play(board);

            if (!Result.CONTINUE.equals(result)) {

                this.done = true;

                switch (result) {

                    case EXCEPTION:
                        LOGGER.debug("AN EXCEPTION OCCURRED! ");
                        break;

                    case WIN:
                        LOGGER.debug(String.format(" Congratulations %s", pl.getName()));
                        LOGGER.debug(String.format(" ~~~~  YOU WON THE GAME ! ~~~~", pl.getName()));
                        break;

                    case FINISHED:
                        LOGGER.debug("GAME FINISHED ! ");
                        LOGGER.debug("NOBODY WON THE GAME :(");
                        break;

                    default:
                        break;

                }

                break;
            }

        }

    }

    @Override
    public void end(Game game) {
        this.board.render();
    }

    @Override
    public boolean isDone(Game game) {
        return done;
    }
}