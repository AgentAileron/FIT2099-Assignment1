package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Most basic hostile actor - follows player and deals melee damage when in range (can also drop keys and items)
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class Grunt extends Actor {

	// Grunts have 50 hitpoints and are always represented with a g
	/**
	 * Instantiate a Grunt - grunts have 40 hp and are always represented by a g
	 * @param name
	 * @param player
	 */
	public Grunt(String name, Actor player) {
		super(name, 'g', 5, 50);
		addBehaviour(new HostileAttackBehaviour(this, player));
		addBehaviour(new FollowBehaviour(player));
	}

	/**
	 * Constructor overload which allows a mapicon to be specified: 
	 * should only be used by Goon subclass
	 * @param name
	 * @param player
	 * @param mapIcon
	 */
	public Grunt(String name, Actor player, char mapIcon) {
		super(name, mapIcon, 5, 50);
		addBehaviour(new FollowBehaviour(player));
		addBehaviour(new HostileAttackBehaviour(this, player));
	}

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return new NPCSkipTurnAction();	// Do nothing if no actions available
	}
}
