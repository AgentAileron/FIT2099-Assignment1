package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Hostile NPC - does not do damage to player and will evade when player within 5 units.
 * 50% chance of stunning player whilst within 5 units, player loses two turns per stun
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class Ninja extends Actor {

	public Ninja(String name, Actor player) {
		super(name, 'n', 5, 50);
		addBehaviour(new StunBehaviour(player));
		addBehaviour(new NinjaBehaviour(player));
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
