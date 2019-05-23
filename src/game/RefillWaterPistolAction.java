package game;

import edu.monash.fit2099.engine.*;

/**
 * Action for player to refill water pistol when near water on moon
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class RefillWaterPistolAction extends Action {
	
	/**
	 * Instantiate an instance of action to (attempt to) refill water pistol
	 */
	public RefillWaterPistolAction() {}

	@Override
	public String execute(Actor actor, GameMap map) {
		Item waterPistol = Gutils.getItem(actor, '~');
		
		if (waterPistol != null) {
			// If water pistol is empty
			if (waterPistol.hasSkill(WaterPistolCharge.EMPTY)) {
				
				// Changes pistol charge to full
				waterPistol.removeSkill(WaterPistolCharge.EMPTY);
				waterPistol.addSkill(WaterPistolCharge.FULL);
				
				return actor + " successfully refills their water pistol.";
			}
			else
				return actor + " attempts to fill their water pistol, only to realise that it is already full.";
		}
		else
			return actor + " does not have a water pistol.";
	}

	@Override
	public String menuDescription(Actor actor) {
		// Player is only able to refill the water pistol when they have one
		if (Gutils.getItem(actor, '~') != null)
			return actor + " refills water pistol";
		else
			return "";
	}

	@Override
	public String hotKey() {
		return "";
	}
	
}
