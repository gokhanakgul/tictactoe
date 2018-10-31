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

import java.time.Instant;

/**
 * Created by mga on 10/29/18.
 *
 * Basic Game Scene Interface
 *
 */
public interface Scene {

    /**
     * Scene start include default logic of a scene loop scenario
     *
     * @param game
     */
    default void start(Game game) {
        preload(game);
        create(game);
        while (!isDone(game)) {
            update(game);
        }
        end(game);
    }

    /**
     * Preload asset for Scene
     */
    void preload(Game game);

    /**
     * Create neccesary inventories for Scene
     */
    void create(Game game);

    /**
     * Update scene step
     */
    void update(Game game);

    /**
     * Stop scene step
     */
    void end(Game game);

    /**
     * You should decide Scene is done or continue to update;
     */
    boolean isDone(Game game);

}