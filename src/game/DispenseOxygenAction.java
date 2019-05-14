package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class DispenseOxygenAction extends Action {

	public DispenseOxygenAction() {}

	@Override
	public String execute(Actor actor, GameMap map) {
		
		return "blah";
	}
	
	@Override
	public String menuDescription(Actor actor) {
		return "blah";
	}
	
	@Override
	public String hotKey() {
		return "";
	}

}
