Design
------
Implementation is based on the Strategy pattern, where player strategy can be changed easily.

`Player` has a `PlayerStrategy` which is responsible for picking a player hand, e.g. We have two implementations of
player strategy `PaperPlayerStrategy` and `RandomPlayerStrategy`. We might also add something like `HumanPlayerStrategy`
when a human is responsible for picking the new hand if our game became popular.

Game Rules are specified using `GameRules` class where you specify which hands should win.
For example: `gameRules.addRule(Hand.ROCK, Hand.SCISSOR, Winner.FIRST);`. Here we specify that Rock beats Scissor.

This gives us the flexibility in changing game rules if we need to. Or even add new hands to the game.

How to run
----------
You can run the application using the command
`java -jar rock-scissor-paper-1.0-RELEASE.jar [rounds]`

The game defaults to 100 rounds

