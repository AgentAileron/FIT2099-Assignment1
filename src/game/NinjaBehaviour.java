package game;

import edu.monash.fit2099.engine.*;

/**
 * Behaviour handler for Ninja retreat action (does not provision stuns)
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class NinjaBehaviour implements ActionFactory{
  
    private Actor target;

    /**
     * Behaviour that causes the ninja to move away when the player is within range
     * @param target The actor to move away from (Will be the player)
     */
    public NinjaBehaviour(Actor target) {
		  this.target = (FancyPlayer) target;
	}


  @Override
	public Action getAction(Actor actor, GameMap map) {
    if (target == null){	// Safety check, in case target despawns
			return null;
    }
    
    Location here = map.locationOf(actor);
		Location there = map.locationOf(target);

    int currentDistance = Gutils.distance(here, there);

    if (currentDistance < 5){
      return new AttemptStunAction(target);
    }
    return null;
  }
}
