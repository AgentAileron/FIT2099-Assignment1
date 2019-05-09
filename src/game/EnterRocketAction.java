package game;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Item;

/**
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu>, Sarah Dennis <sden0009@student.monash.edu>
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
		return actor + " has entered the rocket.";
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
