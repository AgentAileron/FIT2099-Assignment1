package game;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.demo.WindowSmashAction;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Action;
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
		// Player chooses key they want to use.
		return new Actions(new unlockDoor(key, direction, location));
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
