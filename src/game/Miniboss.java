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
	private boolean alert = false;
	
	public Miniboss(String name) {
		super(name, '§', 5, 25);
	}
	
	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		//If player hasn't entered the room, the Miniboss won't be alert
		if (alert == false)
			return idle;
		
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		
		
		return super.playTurn(actions,  map,  display);
	}
}
