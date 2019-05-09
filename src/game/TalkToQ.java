package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Item;

public class TalkToQ extends Action {
	
	private Actor subject;

	public TalkToQ(Actor subject) {
		this.subject = subject;
	}

	private Item playerHasItem(Actor actor, char itemDisplayChar) {
		for (int i = 0; i < actor.getInventory().size(); i++) {
			if (actor.getInventory().get(i).getDisplayChar() == itemDisplayChar) {
				return actor.getInventory().get(i);
			}
		}
		
		return null;
	}
	
	
	@Override
	public String execute(Actor actor, GameMap map) {
		Item plan = playerHasItem(actor, 'p');
		
		if (plan != null) {
			return subject + " blah";
		}
		else {
			return subject + " blah";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " talks with " + subject;
	}

	@Override
	public String hotKey() {
		return "";
	}
}
