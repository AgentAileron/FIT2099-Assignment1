package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * Final boss hostile NPC ("Yugo Maxx")
 * Extends actor but uses certain attacks and weapons unique from lesser enemies
 * Is Russian
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class FinalBoss extends Actor {

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	private Action idle = new SkipTurnAction();
	
	/**
	 * Instantiate a Miniboss - can be done many times,
	 * likely only one instance will be used for actual game
	 * @param name
	 * @param player
	 */
	public FinalBoss(String name, Actor player) {
		super(name, '§', 6, 25);
		addBehaviour(new LightSaberAction(player));
		addBehaviour(new ShootLazerAction(player));
	}
	
	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {

		// Checks for any possible actions the miniboss may take
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		// If the miniboss can't make any actions, they will do nothing
		return idle;
	}
}
