package game;

import edu.monash.fit2099.engine.*;

/**
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu>, Sarah Dennis <sden0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class PlaceEngineAction extends Action {
	
	private Location rocketPadLocation;
	private String direction;

	public PlaceEngineAction(String direction, Location rocketPadLocation) {
		this.direction = direction;
		this.rocketPadLocation = rocketPadLocation;
	}

	private Item playerHasItem(Actor actor, char itemDisplayChar) {
		for (int i = 0; i < actor.getInventory().size(); i++) {
			if (actor.getInventory().get(i).getDisplayChar() == itemDisplayChar) {
				return actor.getInventory().get(i);
			}
		}
		
		return null;
	}
	
	private Item rocketPadHasItem(char itemDisplayChar) {
		for (int i = 0; i < rocketPadLocation.getItems().size(); i++) {
			if (rocketPadLocation.getItems().get(i).getDisplayChar() == itemDisplayChar) {
				return rocketPadLocation.getItems().get(i);
			}
		}
		
		return null;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		Item engine = playerHasItem(actor, 'e');
		Item body = rocketPadHasItem('h');
		
		if (engine != null) {
			actor.removeItemFromInventory(engine);
			rocketPadLocation.addItem(engine);
			
			if (body != null) {
				// Clear inventory
				rocketPadLocation.removeItem(body);
				rocketPadLocation.removeItem(engine);
				
				map.add(new Rocket(), rocketPadLocation);
				return actor + " has placed the rocket engine.\nThe rocket has now been completed.";
			}
			
			return actor + " has placed the rocket engine.";
		}
		else {
			return actor + " does not have a rocket engine part.";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " places rocket engine onto rocket pad in the " + direction;
	}

	@Override
	public String hotKey() {
		return "";
	}
}
