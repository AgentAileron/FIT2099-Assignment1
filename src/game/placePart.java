package game;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Item;

public class placePart extends Action {
	
	private Location rocketPadLocation;
	private String direction;

	public placePart(String direction, Location rocketPadLocation) {
		this.direction = direction;
		this.rocketPadLocation = rocketPadLocation;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		Item engine = new Item("Rocket Engine", 'g');
		Item body = new Item("Rocket Body", 'h');

		if (actor.getInventory().contains(engine)) {
			return actor + " has placed the rocket engine.";
		}
		else if (actor.getInventory().contains(body)) {
			return actor + " has placed the rocket body.";
		}
		else if (actor.getInventory().contains(body) && actor.getInventory().contains(engine)) {
			return actor + " has placed the rocket body and rocket engine.";
		}
		else {
			return actor + " does not have any rocket parts.";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attempts to unlock the door to the " + direction;
	}

	@Override
	public String hotKey() {
		return "";
	}
}
