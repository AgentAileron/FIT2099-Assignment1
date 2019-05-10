package game;

import edu.monash.fit2099.engine.*;

/**
 * Behaviour for hostile attacking - essentially restricts all attacks by grunts and goons
 * to melee only (distance of 1 or less to the player)
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <sden0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class HostileAttackBehaviour implements ActionFactory {

    private Actor attacker;
    private Actor subject;
    
    /**
     * Instantiate a new hostile attack behaviour for an Actor
     * @param actor The actor being assigned to - the hostile NPC
     * @param subject The target actor (EG: the player)
     */
    public HostileAttackBehaviour(Actor actor, Actor subject) {
        this.attacker = actor;
        this.subject = subject;
    }
    
    @Override
	public Action getAction(Actor actor, GameMap map) {
        if (target == null){	// Safety check, in case target despawns
			return null;
        }
        
        Integer range = distance(map.locationOf(attacker), map.locationOf(subject));
        if (range <= 1){
            return new AttackAction(actor, subject);
        }else{
            return null;
        }
    }

    // Manhattan distance.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}