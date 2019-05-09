package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Actions;

public class Rocket extends Ground {

	public Rocket() {
		super('R');
		
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		return new Actions(new EnterRocketAction(location));
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

}
