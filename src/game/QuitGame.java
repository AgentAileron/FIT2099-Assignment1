package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class QuitGame extends Action {

	public QuitGame() {}
		
	@Override
	public String execute(Actor actor, GameMap map) {
		FancyPlayer player = (FancyPlayer) actor;
		player.initiateEnd("exit");
		map.removeActor(actor);
		return actor + " exits the game.";
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Quit the game";
	}

	@Override
	public String hotKey() {
		return "-";
	}
}