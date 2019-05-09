package game;

import edu.monash.fit2099.engine.*;

/**
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu>, Sarah Dennis <sden0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class RandomWalkBehaviour implements ActionFactory{

    public RandomWalkBehaviour(){}

    @Override
	public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        map.add(new Floor(), here);
        
        if (Math.random() < 0.6){   // 60% chance that Q will move 
            for (Exit exit : here.getExits()){
                Location destination = exit.getDestination();
                if (destination.canActorEnter(actor)){
                	map.add(new AllowableActionsForQ(), destination);
                    return new MoveActorAction(destination, exit.getName());           
                }
            }
        }
		return new NPCSkipTurnAction();
	}
}