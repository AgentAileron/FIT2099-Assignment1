package game;

import edu.monash.fit2099.engine.*;

/**
 * Action for player to use water pistol
 * Pistol defeats exoskeleton of Yugo if hit, otherwise has no effect on target
 * One shot before reloads
 * Requires fancyplayer to function
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class ShootWaterPistolAction extends Action {
	
	private Actor target;
	
	public ShootWaterPistolAction(Actor target) {
		this.target = target;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		Item waterPistol = Gutils.getItem(actor, '~');
		Item exoskeleton = Gutils.getItem(target, 'x');
		
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
		if (Gutils.getItem(actor, '~') != null)
			return actor + " shoots water pistol at " + target;
		else
			return "";
	}

	@Override
	public String hotKey() {
		return "";
	}
	
}
