package game;

import edu.monash.fit2099.engine.*;

public class ShootWaterPistolAction extends Action {
	
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
		Item exoskeleton = getItem(target, 'x');
		
		// If the player has a water pistol
		if (waterPistol != null) {
			if (waterPistol.hasSkill(WaterPistolCharge.FULL)) {
				
				// Sets pistol charge to empty
				waterPistol.removeSkill(WaterPistolCharge.FULL);
				waterPistol.addSkill(WaterPistolCharge.EMPTY);
				
				// If the player is targeting the final boss
				if (target.getDisplayChar() == '¥') {
					// If the final boss still has their exo-skeleton
					if (exoskeleton != null) {
						// 70% chance to destroy their exo-skeleton
						if (Math.random() < 0.7) {
							target.removeItemFromInventory(exoskeleton);
							return actor + " shoots water pistol at " + target + ", it destroys their exo-skeleton!";
						}
						else
							return actor + " shoots water pistol at " + target + ", but it misses.";
					}
					else
						return actor + " attempts to shoot the water pistol at " + target + ", forgetting that the exo-skeleton has already been broken. Whoops.";
				}
				else
					return actor + " shoots water pistol at " + target + ", sadly it does absolutely nothing...";	
			}
			else 
				return actor + " attempts to shoot the water pistol, only to realise it has no water...";
		}
		else
			return actor + " does not have a water pistol, whoops...";
	}

	@Override
	public String menuDescription(Actor actor) {
		if (getItem(actor, '~') != null)
			return actor + " shoots water pistol at " + target;
		else
			return "";
	}

	@Override
	public String hotKey() {
		return "";
	}
	
}
