<h1 align="center"> Tic Tac Toe Game </h1>

## Introduction

<p>We want to bring the pen-and-paper game Tic-tac-toe to the digital age, but
with a little twist: the size of the playfield should be configurable
between 3x3 and 10x10. And we also want the symbols (usually O and X) to be
configurable. Also it should be for 3 players instead of just 2. A player
can win the game by filling in a whole row, column or diagonal. If the
playfiled is 5x5 - then the player must fill all the 5 cells in a row,
column or diagonal to win.</p>

General Rules: https://en.wikipedia.org/wiki/Tic-tac-toe
<p>
The three players play all together against each other. One of the players
is an AI. Who is starting is random. In and output should be on the
console. Input of the AI is automatic, no user action should be required.
After each move, the new state of the playfield is displayed and the player
can enter the next position of their character one after another. The next
position should be provided in a format like 3,2. Invalid inputs are
expected to be handled appropriately.
</p>

## Technology

- [Maven 3](https://maven.apache.org/)
  - Chekstyle Plugin
  - PMD Plugin
  - FindBug Plugin
* [Java 1.8 latest](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## Usage

There are two script in project
* build.sh , prepares fat jar to package
* tictactoe.sh , runs prepared jar in commandline.


## Environment

If you are working on window environment you can install [cmder](http://cmder.net/)
to use for bash console

## Configuration

You can customize execution of tictactoe game with external config file.
if you dont provide a config file , jar loads a default configuration from inside.

* Create ``` app.properties ``` file in working directory.
* Following example configuration will help you
```
#--- GAME SETTING -----#
# game.name=Name of the Game


game.name=Tic Tac Toe Game


#--- BOARD SETTING -----#
# board.size=10


board.size=5


#--- MARK SETTINGS -----#
# mark.cross=X
# mark.nought=O

mark.cross=X
mark.nought=O


#--- PLAYER SETTINGS -----#
# player.count

player.count=3


#--- PLAYER TYPE -----
# HUMAN =0
# AI =1
#---  MARK TYPE  -----
# CROSS=0
# NOUGHT=1
# RANDOM=2

player.1.type=0
player.1.mark=0


player.2.type=1
player.2.mark=1


player.3.type=1
player.3.mark=2

```


## Design

in src folder there are mainly two packages.

* com.metro.game

  Game package is including interfaces which helps to define general concepts for a game.

  Game class is a general game definition for a game . You should inject into Config and Scenes for a game. Scene has got game loop logic in their.


  You have to check  Win Validation algoritm in WinValidator.

  I tried to implement test cases as much as I can.


* com.metro.tictactoe

   This package specific implemetation for tictactoe game.




## Author

* Gökhan Akgül <a href="mailto:gokhan.akgul@gmail.com">gokhan.akgul@gmail.com</a>
