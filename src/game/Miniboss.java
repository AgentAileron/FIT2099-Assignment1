package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.SkipTurnAction;

public class Miniboss extends Actor {

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	private Action idle = new SkipTurnAction();
	
	public Miniboss(String name, Actor player) {
		super(name, '§', 6, 25);
		addBehaviour(new LightSaberAction(player));
		addBehaviour(new shootsLazers(player));
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
