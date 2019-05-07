package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Item;

public class placeEngine extends Action {
	
	private Location rocketPadLocation;
	private String direction;

	public placeEngine(String direction, Location rocketPadLocation) {
		this.direction = direction;
		this.rocketPadLocation = rocketPadLocation;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		Item engine = new Item("Rocket Engine", 'e');

		if (actor.getInventory().contains(engine)) {
			actor.removeItemFromInventory(engine);
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
