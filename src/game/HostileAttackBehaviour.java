package game;

import edu.monash.fit2099.engine.*;

/**
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu>, Sarah Dennis <sden0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class HostileAttackBehaviour implements ActionFactory {

    private Actor attacker;
    private Actor subject;
    
    public HostileAttackBehaviour(Actor actor, Actor subject) {
        this.attacker = actor;
        this.subject = subject;
    }
    
    @Override
	public Action getAction(Actor actor, GameMap map) {
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