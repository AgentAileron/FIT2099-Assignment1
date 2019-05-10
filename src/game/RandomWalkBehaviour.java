package game;

import edu.monash.fit2099.engine.*;

/**
 * Behaviour handler for Q random walk - 60% chance per turn of movement happening
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <sden0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class RandomWalkBehaviour implements ActionFactory{

    public RandomWalkBehaviour() {}

    @Override
	public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        
        if (Math.random() < 0.6){   // 60% chance that Q will move 
            for (Exit exit : here.getExits()){
                Location destination = exit.getDestination();
                if (destination.canActorEnter(actor)){
                    return new MoveActorAction(destination, exit.getName());           
                }
            }
        }
        if (actor instanceof Qnpc){
            Qnpc Q = (Qnpc) actor;
            if (Q.readyForExile){
                return null;
            }
        }
		return new NPCSkipTurnAction();
	}
}