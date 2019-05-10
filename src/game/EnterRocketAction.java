package game;

import edu.monash.fit2099.engine.*;

/**
 * Action for player to enter a completely assembled rocket
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <sden0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class EnterRocketAction extends Action {
	
	private Location rocketLocation;

	public EnterRocketAction(Location rocketLocation) {
		this.rocketLocation = rocketLocation;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		map.removeActor(actor);
		return actor + " has entered the rocket and has made their escape into outer space./nCongratulations, you win!";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " enters the rocket.";
	}

	@Override
	public String hotKey() {
		return "";
	}
}
