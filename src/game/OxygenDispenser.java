package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class OxygenDispenser extends Ground {

	public OxygenDispenser() {
		super('╬');
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		return new Actions(new DispenseOxygenAction());
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return true;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return false;
	}

}
