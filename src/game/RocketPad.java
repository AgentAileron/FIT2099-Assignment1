package game;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.demo.WindowSmashAction;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import java.util.*;

public class RocketPad extends Ground {

	public RocketPad() {
		super('=');
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		Actions actions = new Actions();
		actions.add(new PlaceBodyAction(direction, location));
		actions.add(new PlaceEngineAction(direction, location));
		return actions;
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
