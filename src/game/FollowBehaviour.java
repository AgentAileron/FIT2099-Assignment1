package game;

import edu.monash.fit2099.engine.*;

/**
 * Behaviour which handles NPC following - finds distance to player and moves 1 tile closer
 * each turn.
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class FollowBehaviour implements ActionFactory {

	private Actor target;

	/**
	 * Create new bahviour handler for following another Actor
	 * @param subject Actor to follow
	 */
	public FollowBehaviour(Actor subject) {
		this.target = subject;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		if (target == null){	// Safety check, in case target despawns
			return null;
		}

		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);

		int currentDistance = Utilities.distance(here, there);
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				int newDistance = Utilities.distance(destination, there);
				if (newDistance < currentDistance) {
					return new MoveActorAction(destination, exit.getName());
				}
			}
		}

		return null;
	}
}