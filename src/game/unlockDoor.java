package game;
import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class unlockDoor extends Action {

	private Key usedKey;
	private Location doorLocation;
	private String direction;
	
	public unlockDoor(Key usedKey, String direction, Location doorLocation) {
		this.usedKey = usedKey;
		this.direction = direction;
		this.doorLocation = doorLocation;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		// Get key at
		if(usedKey.isSameKey(((Door) doorLocation.getGround()).getKey())) {
			return actor + " has the wrong key.";
		}
		else {
			map.add(new Floor(), doorLocation);
			return "The door has been unlocked";
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
