package game;

import edu.monash.fit2099.engine.*;

/**
 * Class for oxygen dispenser mpa object - allows player to get more oxygen
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class OxygenDispenser extends Ground {
	
	public OxygenDispenser() {
		super('╬');
		this.addSkill(Dispensing.INACTIVE);
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction) {
		return new Actions(new DispenseOxygenAction(location));
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
