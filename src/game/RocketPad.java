package game;

import edu.monash.fit2099.engine.*;

/**
 * Ground item which holds rocket parts as player collects them 
 * Once all collected, Rocket may be constructed (replaces instance in location)
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class RocketPad extends Ground {

	/**
	 * Creates a ground type that represents the rocket pad. 
	 * Rocket engine and body are placed through allowable actions provided in this class.
	 */
	public RocketPad() {
		super('=');
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		Actions actions = new Actions();
		actions.add(new PlaceBodyAction(direction, location));
		actions.add(new PlaceEngineAction(direction, location));
		return actions;
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
