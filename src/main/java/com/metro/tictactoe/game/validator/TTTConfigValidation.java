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

package com.metro.tictactoe.game.validator;

import com.metro.game.Config;
import com.metro.game.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by mga on 10/31/18.
 */

public class TTTConfigValidation implements Validator<Config> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TTTConfigValidation.class);

    @Override
    public boolean validate(Config config) {
        boolean result = false;
        try {
            final Integer boardSize = Integer.valueOf(config.getValue("board.size"));
            if (boardSize >= 3 && boardSize <= 10)
                result = true;

        } catch (Exception ex) {
            return false;
        }


        return result;
    }
}
