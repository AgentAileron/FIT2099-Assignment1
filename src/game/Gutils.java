package game;

import edu.monash.fit2099.engine.*;

/**
 * Static utility methods that can be used by any package classes
 * All static classes, gutils = Game Utilities
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
class Gutils {

    /**
	 * If the given actor has a given item, it returns the item
	 * @param actor - Actor whose inventory will be searched
	 * @param itemDisplayChar - Character that uniquely identifies the item type
	 * @return true or false
	 */
	protected static Item getItem(Actor actor, char itemDisplayChar) {
		for (int i = 0; i < actor.getInventory().size(); i++) {
			if (actor.getInventory().get(i).getDisplayChar() == itemDisplayChar) {
				return actor.getInventory().get(i);
			}
		}
		
		return null;
    }

    // Manhattan distance.
	protected static int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}