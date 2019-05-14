package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class ShootWaterPistolAction extends Action {

	/*
	 * INCOMPLETE
	 */
	
	private Actor target;
	
	public ShootWaterPistolAction(Actor target) {
		this.target = target;
	}
	
	/**
	 * If the given actor has a given item, it returns the item
	 * @param actor - Actor whose inventory will be searched
	 * @param itemDisplayChar - Character that uniquely identifies the item type
	 * @return true or false
	 */
	private Item getItem(Actor actor, char itemDisplayChar) {
		for (int i = 0; i < actor.getInventory().size(); i++) {
			if (actor.getInventory().get(i).getDisplayChar() == itemDisplayChar) {
				return actor.getInventory().get(i);
			}
		}
		
		return null;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		Item waterPistol = getItem(actor, '~');
		
		if (waterPistol != null) {
			//70% chance to destory exoskeleton
		}
		else
			return actor + " does not have a water pistol.";
	}

	@Override
	public String menuDescription(Actor actor) {
		if (getItem(actor, '~') != null)
			return actor + " shoots water pistol";
		else
			return "";
	}

	@Override
	public String hotKey() {
		return "";
	}
	
}
