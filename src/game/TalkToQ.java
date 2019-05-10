package game;

import edu.monash.fit2099.engine.*;

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
			return "I can give you something that will help, but I'm going to need plans.";
		}
		else {
			return "Hand them over, I don't have all day!";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " talks with " + subject;
	}

	@Override
	public String hotKey() {
		return "t";
	}
}
