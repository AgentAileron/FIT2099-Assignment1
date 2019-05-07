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

	@Override
	public String execute(Actor actor, GameMap map) {
		Item body = new Item("Rocket Body", 'h');

		if (actor.getInventory().contains(body)) {
			actor.removeItemFromInventory(body);
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
