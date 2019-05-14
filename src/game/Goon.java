package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Hostile actor which is a subclass of Grunt - effectively a grunt which has a tazer (higher damage)
 * and has a 10% chance of hurling an insult 
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class Goon extends Grunt {

	/**
	 * Instantiate a Goon hostile NPC
	 * @param name name of the Goon (used for info messages)
	 * @param player player instance the goon will target
	 */
	public Goon(String name, Actor player) {
		super(name, player, 'G');
		addBehaviour(new InsultBehavior());
		Item tazer = new WeaponItem("tazer", '^', 10, "zaps");
		addItemToInventory(tazer);
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
		
		return new SkipTurnAction();	// Do nothing if no actions available
	}
}
