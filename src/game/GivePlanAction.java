package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Item;

public class GivePlanAction extends Action {
	
	private Actor subject;

	public GivePlanAction(Actor subject) {
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
	
	private Item qHasItem(Actor actor, char itemDisplayChar) {
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
		Item body = qHasItem(subject, 'h');
		
		if (plan != null) {
			actor.removeItemFromInventory(plan);
			subject.removeItemFromInventory(body);
			actor.addItemToInventory(body);
			
			map.removeActor(subject);
			return subject + " traded a Rocket Body to " + actor + " for a Rocket Plan";
		}
		else {
			return subject + " says: Hey! You don't have any rocket plans. Are you trying to swindle me, Bucko?";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Trade " + subject + " a rocket plan in return for a rocket body part";
	}

	@Override
	public String hotKey() {
		return "";
	}
}
