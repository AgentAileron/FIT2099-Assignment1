package game;

import edu.monash.fit2099.engine.*;

/**
 * Fully built rocket
 * Will be constructed by player upon placing all parts on rocket pad
 * Allows teleportation / warping to next stage, or triggering win condition
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class Rocket extends Ground {

	/**
	 * Instantiate a rocket - is a ground item, inpermeable
	 */
	public Rocket() {
		super('R');
		
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		return new Actions(new EnterRocketAction());
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
