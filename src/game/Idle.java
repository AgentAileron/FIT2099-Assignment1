package game;

import game.ActionFactory;
import edu.monash.fit2099.engine.*;

public class Idle extends Action implements ActionFactory {
	
	public Idle() {}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		return menuDescription(actor);
	}
	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		return new MoveActorAction(this.location, "north");
	}

	@Override
	public String menuDescription(Actor actor) {
		return "";
	}
	
	@Override
	public String hotKey() {
		return "";
	}

}