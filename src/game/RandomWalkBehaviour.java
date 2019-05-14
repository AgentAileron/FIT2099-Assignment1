package game;

import edu.monash.fit2099.engine.*;

/**
 * Behaviour handler for NPC random walk - 60% chance per turn of movement happening
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class RandomWalkBehaviour implements ActionFactory{

    public RandomWalkBehaviour() {}

    @Override
	public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        
        if (Math.random() < 0.6){   // 60% chance that NPC will move 

            for (int i=0; i < 4; i++){
                int exitChosen = (int) (Math.random()*3);
                Location destination = here.getExits().get(exitChosen).getDestination();
                if (destination.canActorEnter(actor)){
                    return new MoveActorAction(destination, here.getExits().get(exitChosen).getName());  
                }
            }
        }
		return new NPCSkipTurnAction();
	}
}