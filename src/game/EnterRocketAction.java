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
	
	/**
	 * If the given actor has a given item, it returns the item
	 * @param actor - Actor whose inventory will be searched
	 * @param itemDisplayChar - Character that uniquely identifies the item type
	 * @return true or false
	 */
	private Item getItem(Actor actor, char itemDisplayChar) {
		for (int i = 0; i < actor.getInventory().size(); i++) {
			if (actor.getInventory().get(i).getDisplayChar() == itemDisplayChar) {
				return actor.getInventory().get(i);
			}
		}
		
		return null;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		if (actor instanceof FancyPlayer) {
			if (!((FancyPlayer) actor).isPlayerOnMoon()) {
				// If player is not on the moon
				if (getItem(actor, 'o') != null && getItem(actor, '8') != null) {
					((FancyPlayer) actor).movePlayerToMap("Moon");
					return actor + " has entered the rocket and gone to the moon.";
				}
				else if (getItem(actor, 'o') == null && getItem(actor, '8') == null)
					return actor + " tries to enter the rocket, but realises they neither have an oxygen tank nor a space suit.";
				else if (getItem(actor, 'o') == null)
					return actor + " tries to enter the rocket, but realises they don't have an oxygen tank.";
			
				return actor + " tries to enter the rocket, but realises they don't have a space suit.";
			}
			else {
				// If player is on the moon
				((FancyPlayer) actor).movePlayerToMap("Lair");
				return actor + " has entered the rocket and returned to Earth.";
			}
		}
		return "";
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
