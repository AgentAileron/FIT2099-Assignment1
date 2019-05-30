package game;

import edu.monash.fit2099.engine.*;

/**
 * Special skip turn action which does not have any console output -
 * useful as a default case for no NPC action
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class NPCSkipTurnAction extends SkipTurnAction {

    @Override
	public String menuDescription(Actor actor) {
		return actor + " is idle.";
	}
    
}
