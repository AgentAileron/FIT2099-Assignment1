package game;

import edu.monash.fit2099.engine.*;

/**
 * Behaviour to handle stuns by Ninja - only allows stuns when Ninja is at less than 5 units from player
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class StunBehaviour implements ActionFactory {
    private Actor subject;
    
    public StunBehaviour(Actor subject) {
        this.subject = subject;
    }
    
    @Override
	public Action getAction(Actor actor, GameMap map) {
        if (subject == null){	// Safety check, in case target despawns
			return null;
        }
        
        if (map.locationOf(subject) != null){
            Integer range = distance(map.locationOf(actor), map.locationOf(subject));
            if (range <= 5)
                return new StunAction(subject);
        }
        return null;
    }

    // Manhattan distance.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}