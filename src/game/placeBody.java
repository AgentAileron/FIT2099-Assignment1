package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Item;

public class placeBody extends Action {
	
	private Location rocketPadLocation;
	private String direction;

	public placeBody(String direction, Location rocketPadLocation) {
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
		Item body = playerHasItem(actor, 'h');
		Item engine = rocketPadHasItem('e');
		
		if (body != null) {
			actor.removeItemFromInventory(body);
			rocketPadLocation.addItem(body);
			
			if (engine != null) {
				// Clear inventory
				rocketPadLocation.removeItem(body);
				rocketPadLocation.removeItem(engine);
				
				map.add(new Rocket(), rocketPadLocation);
				return actor + " has placed the rocket body.\nThe rocket has now been completed.";
			}
			
			return actor + " has placed the rocket body.";
		}
		else {
			return actor + " does not have a rocket body part.";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " places rocket body onto rocket pad in the " + direction;
	}

	@Override
	public String hotKey() {
		return "";
	}
}
