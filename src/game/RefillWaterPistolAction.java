package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class RefillWaterPistolAction extends Action {
	
	/*
	 * TO DO
	 * Modify the allowable actions for player depending on if their pistol needs water or not
	 * When players pistol is empty, they don't have the shoot water pistol action
	 */

	private Actions possibleActions = new Actions();
	
	public RefillWaterPistolAction() {}
	
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
			// If water pistol is empty
			possibleActions.add(new ShootWaterPistolAction());
			// If water pistol is not empty
			return "";
		}
		else
			return actor + " does not have a water pistol.";
	}

	@Override
	public String menuDescription(Actor actor) {
		// Player is only able to refill the water pistol when they have one
		if (getItem(actor, '~') != null)
			return actor + " refills water pistol";
		else
			return "";
	}

	@Override
	public String hotKey() {
		return "";
	}
	
}
