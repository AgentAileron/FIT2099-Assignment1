package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Actions;


public class Door extends Ground {
	
	private Key assignedKey;

	public Door() {
		super('D');
	}
	
	public void setKey(Key newKey) {
		this.assignedKey = newKey;
	}
	
	public Key getKey() {
		return assignedKey;
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){

		// If player has the assigned key, allow them to unlock the door
		for (int i = 0; i < actor.getInventory().size(); i++) {
			if (actor.getInventory().get(i) == this.assignedKey) {
				return new Actions(new unlockDoor(this.assignedKey, direction, location));
			}
		}
		
		return null;
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return false;
	}
}
