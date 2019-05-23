package game;

import edu.monash.fit2099.engine.*;

/**
 * Waterpools - ground objects designated for spawning on moon
 * Actors cannot walk over water, used for player to refill water-pistol
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class WaterPool extends Ground {
	
	public WaterPool() {
		super('&');
	}

	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
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
