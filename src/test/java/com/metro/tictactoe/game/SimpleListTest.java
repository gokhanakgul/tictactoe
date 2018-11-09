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

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mga on 11/8/18.
 */

public class SimpleListTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleListTest.class);

    @Test
    public void simpleListTest() {


        List<String> stringList = new ArrayList<>();
        stringList.add(stringList.size(),"test");
        stringList.add(stringList.size(),"test");
        stringList.add(stringList.size(),"test");

        Assert.assertNotNull(stringList.get(0));
        Assert.assertEquals(stringList.size(),3);

        Assert.assertNotNull(stringList.set(0,null));
        Assert.assertEquals(stringList.size(),3);


    }
}
