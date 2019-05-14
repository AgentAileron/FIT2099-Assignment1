package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class WaterPool extends Ground {
	
	public WaterPool() {
		super('&');
	}

	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		// Actions to be made available: Refill water pistol
		return new Actions(new RefillWaterPistolAction());
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return false;
	}
	
}
