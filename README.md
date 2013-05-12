# Lucky : Somewhat safer PvP deaths

Coded for the Junction.at Minecraft servers -- http://junction.at/

### Contributors:
  * Elliot Speck [ElliotSpeck]

Based on the premise of "third-time lucky", the Lucky plugin will teleport a player back to the server's spawn after a preset number of deaths-by-other-player. This allows a slightly better protection against PvP spawn-camping, as camping at the player's bed will only work a few times.

Currently completely commandless, simply drop into your plugins folder.

## Configuration:

  * max-deaths
    * The number of deaths a player must experience before being teleported back to spawn.

## Current to-do list:
  * Implement the option to make the victim invulnerable instead of being teleported back to spawn.
  * Implement a time-based increment, so that being killed more than <x> minutes after your last death will not result in being teleported.