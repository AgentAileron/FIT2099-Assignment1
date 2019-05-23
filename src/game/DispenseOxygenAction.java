package game;

import edu.monash.fit2099.engine.*;

/**
 * Action for player to interact with oxygen dispenser
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class DispenseOxygenAction extends Action {
	
	private Location dispenserLocation;
	
	public DispenseOxygenAction(Location dispenserLocation) {
		this.dispenserLocation = dispenserLocation;
	}
	
	private Item getItem(Location location, char itemDisplayChar) {
		for (int i = 0; i < location.getItems().size(); i++) {
			if (location.getItems().get(i).getDisplayChar() == itemDisplayChar) {
				return location.getItems().get(i);
			}
		}
		
		return null;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		Ground dispenser = map.groundAt(dispenserLocation);
		
		// If oxygen tank isn't already sitting in the dispensers location
		if (getItem(dispenserLocation, 'o') == null) {
			if (dispenser.hasSkill(Dispensing.INACTIVE)) {
				
				// Dispensing is activated
				dispenser.removeSkill(Dispensing.INACTIVE);
				dispenser.addSkill(Dispensing.ACTIVE);
				
				return "Oxygen Dispenser has been activated, oxygen tank will be completed in 1 turn.";
			}
			else if (dispenser.hasSkill(Dispensing.ACTIVE)) {
				
				// Dispensing is completed
				dispenser.removeSkill(Dispensing.ACTIVE);
				dispenser.addSkill(Dispensing.INACTIVE);
				
				// Creates oxygen tank
				Item oxygenTank = new Item("Oxygen Tank", 'o');
				map.addItem(oxygenTank, dispenserLocation.x(), dispenserLocation.y());
				
				return "Oxygen Dispenser has now completed the Oxygen Tank. Oxygen tank rolls out of the dispenser.";
			}
		}
		
		return "Oxygen Dispenser already has a completed oxygen tank ready to be taken.";
	}
	
	@Override
	public String menuDescription(Actor actor) {
		if (getItem(dispenserLocation, 'o') != null)
			return actor + " opens the Oxygen Dispenser";
		else
			return actor + " activates the Oxygen Dispenser";
	}
	
	@Override
	public String hotKey() {
		return "";
	}

}
