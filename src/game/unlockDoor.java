package game;
import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class unlockDoor extends Action {

	private Location doorLocation;
	private String direction;
	
	public unlockDoor(String direction, Location doorLocation) {
		this.direction = direction;
		this.doorLocation = doorLocation;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		
		for (int i = 0; i < actor.getInventory().size(); i++) {
			if (actor.getInventory().get(i).getDisplayChar() == '$') {
				map.add(new Floor(), doorLocation);
				actor.removeItemFromInventory(actor.getInventory().get(i));
				return "The door has been unlocked";
			}
		}
		
		return actor + " does not have a key";
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
