package game;

import edu.monash.fit2099.engine.*;
import java.util.*;

public class Qnpc extends Actor {

    public Qnpc(Actor player){
		super("Q", 'Q', 4, 9999);
		addBehaviour(new RandomWalkBehaviour());
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
		
		return super.playTurn(actions,  map,  display);	// Fallback to calling super
	}
}