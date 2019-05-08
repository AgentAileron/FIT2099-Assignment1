package game;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Item;

public class enterRocket extends Action {
	
	private Location rocketLocation;

	public enterRocket(Location rocketLocation) {
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
