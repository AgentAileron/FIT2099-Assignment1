package game;

import edu.monash.fit2099.engine.*;

/**
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu>, Sarah Dennis <sden0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class Door extends Ground {

	public Door() {
		super('D');
	}

	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		return new Actions(new UnlockDoorAction(direction, location));
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
