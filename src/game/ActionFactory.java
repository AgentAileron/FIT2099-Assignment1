package game;

import edu.monash.fit2099.engine.*;

/**
 * Interface for action factories (action handlers)
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <sden0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public interface ActionFactory {
	Action getAction(Actor actor, GameMap map);
}
