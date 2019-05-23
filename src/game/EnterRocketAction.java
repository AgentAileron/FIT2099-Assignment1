package game;

import edu.monash.fit2099.engine.*;

/**
 * Action for player to enter a completely assembled rocket
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
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
		if (Gutils.getItem(actor, 'o') != null && Gutils.getItem(actor, '8') != null) {
			if (actor instanceof FancyPlayer){
				((FancyPlayer) actor).movePlayerToMap("Moon");
			}
			return actor + " has entered the rocket and gone to the moon.";
		}
		else if (Gutils.getItem(actor, 'o') == null)
			return actor + " tries to enter the rocket, but realises they don't have an oxygen tank.";
		
		return actor + " tries to enter the rocket, but realises they don't have a space suit.";
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
