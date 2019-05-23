package game;

import edu.monash.fit2099.engine.*;

/**
 * Behaviour to handle stuns by Ninja - only allows stuns when Ninja is at less than 5 units from player
 * MUST BE CALLED USING A FANCYPLAYER INSTANCE TO FUNCTION PROPERLY
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class StunBehaviour implements ActionFactory {
    private Actor subject;
    
    /**
     * Instantiate instance of stun behaviour, for use by ninjas on player
     * NB: MUST BE CALLED ON A FANCYPLAYER TO FUNCTION PROPERLY
     * @param subject
     */
    public StunBehaviour(Actor subject) {
        this.subject = subject;
    }
    
    @Override
	public Action getAction(Actor actor, GameMap map) {
        if (subject == null){	// Safety check, in case target despawns
			return null;
        }
        
        if (map.locationOf(subject) != null){
            Integer range = Gutils.distance(map.locationOf(actor), map.locationOf(subject));
            if (range <= 5)
                return new StunAction(subject);
        }
        return null;
    }
}