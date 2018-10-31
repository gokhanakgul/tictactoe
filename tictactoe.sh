#!/bin/bash

if [ ! -f  "target/tictactoe-standalone.jar" ]
then
    mvn clean package
fi

java -jar target/tictactoe-standalone.jar
