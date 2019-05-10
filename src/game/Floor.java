package game;

import edu.monash.fit2099.engine.Ground;

/**
 * Default floor - passable by all actors, can have items dropped on top
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <sden0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class Floor extends Ground {

	/**
	 * Instantiate a default ground panel
	 */
	public Floor() {
		super('.');
	}
}
