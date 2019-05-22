package game;

import edu.monash.fit2099.engine.*;

/**
 * Behaviour for Yugo attacks
 * Chooses from a random attack based on position to player
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class YugoAttackBehaviour implements ActionFactory {

    private Actor attacker;
    private Actor target;
    
    public YugoAttackBehaviour(Actor actor, Actor subject) {
        this.attacker = actor;
        this.target = subject;
    }
    
    @Override
	public Action getAction(Actor actor, GameMap map) {
        if (target == null){	// Safety check, in case target despawns
			return null;
        }
        
        Integer range = Utilities.distance(map.locationOf(attacker), map.locationOf(target));
        if (range <= 1){
            return new AttackAction(actor, target);
        }// else if (){} // TODO: additional attack types (if time permits)
        return null;
    }
}